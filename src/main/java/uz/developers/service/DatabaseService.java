package uz.developers.service;

import uz.developers.model.Account;
import uz.developers.model.Result;
import uz.developers.model.Transactions;
import uz.developers.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseService {

    private String url = "jdbc:postgresql://localhost:5432/relearn";
    private String dbUser = "postgres";
    private String dbPassword = "1234";


    //ps


    public void getAccounts() {
        try {
            Connection connection = DriverManager.getConnection(url, dbUser, dbPassword);
            String query = "select * from get_accounts()";
            CallableStatement callableStatement = connection.prepareCall(query);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String username = resultSet.getString(2);
                String phone_number = resultSet.getString(3);
                int balance = resultSet.getInt(4);
                String card_number = resultSet.getString(5);
                Account user = new Account(id, username, phone_number, card_number, balance);
                System.out.println(user);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error while retrieving accounts", e);
        }
    }

    public Account getAccount(int userId) {
        //List<User> users = new ArrayList<>();
        String query = "select * from getAccountById(?)";
        Account user = null;
        try {
            Connection connection = DriverManager.getConnection(url, dbUser, dbPassword);
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setInt(1, userId);

            ResultSet resultSet = callableStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String phone_number = resultSet.getString("phone_number");
                int balance = resultSet.getInt("balance");
                String card_number = resultSet.getString("card_number");

                user = new Account(id, username, phone_number, card_number, balance);
                System.out.println(user);
            }
        } catch (SQLException e) {

            throw new RuntimeException("Error while fetching user by ID", e);
        }
        return user;
    }

    public void addAccount(Account user) {
        try {
            Connection connection = DriverManager.getConnection(url, dbUser, dbPassword);
            String query = "call add_account(?,?,?,?,?)";
            String status_message = "";
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setString(1, user.getUsername());
            callableStatement.setString(2, user.getPhone_number());
            callableStatement.setInt(3, user.getBalance());
            callableStatement.setString(4, user.getCard_number());
            callableStatement.registerOutParameter(5, Types.VARCHAR);

            callableStatement.execute();

            status_message = callableStatement.getString(5);
            System.out.println(status_message);

        } catch (SQLException e) {
            throw new RuntimeException("Error while adding account", e);
        }
    }

    public void transfer(String senderCardNumber, String receiverCardNumber, int amount) {
        try {
            Connection connection = DriverManager.getConnection(url, dbUser, dbPassword);
            String query = "call transfer(?,?,?,?)";
            String statusMessage = "";
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setString(1, senderCardNumber);
            callableStatement.setString(2, receiverCardNumber);
            callableStatement.setInt(3, amount);
            callableStatement.registerOutParameter(4, Types.VARCHAR);
            callableStatement.execute();
            statusMessage = callableStatement.getString(4);

            Transactions transactions = new Transactions();
            query = "insert into transaction(amount,date,senderCardNumber,receiverCardNumber) values(?,?,?,?) ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDouble(1, transactions.getAmount());
            preparedStatement.setString(2, String.valueOf(transactions.getDate()));
            preparedStatement.setString(3,transactions.getSenderCardNumber());
            preparedStatement.setString(4,transactions.getReceiverCardNumber());
            preparedStatement.executeUpdate();
            System.out.println(statusMessage);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void editAccount(Account account) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, dbUser, dbPassword);
            String query = "update accounts set username=?,phone_number=?,card_number=?,balance=? where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPhone_number());
            preparedStatement.setString(3, account.getCard_number());
            preparedStatement.setInt(4, account.getBalance());
            preparedStatement.setInt(5, account.getId());
            preparedStatement.executeUpdate();
            System.out.println("User is edited by prepareStatement");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public void deleteAccount(int userId) {
        try {
            Connection connection = DriverManager.getConnection(url, dbUser, dbPassword);
            String query = "delete from accounts where id =?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();
            System.out.println("Account is deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    //register user


    public Result registerUser(User user) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        int count = 0;

        try {
            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection(url, dbUser, dbPassword);
            String checkUsernameQuery = "select count(*) from users where username='" + user.getUsername() + "'";
            PreparedStatement preparedStatement = connection.prepareStatement(checkUsernameQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }
            if (count > 0) {
                return new Result("Username already exist", false);
            }

            String checkPasswordQuery = "select count(*) from users where password='" + user.getPassword() + "'";
            PreparedStatement preparedStatement1 = connection.prepareStatement(checkPasswordQuery);
            ResultSet resultSet1 = preparedStatement1.executeQuery();
            while (resultSet1.next()) {
                count = resultSet1.getInt(1);
            }
            if (count > 0) {
                return new Result("Password is already exist", false);
            }


            String sql = "CALL insert_users(?, ?, ?, ?)";
            callableStatement = connection.prepareCall(sql);
            callableStatement.setString(1, user.getFirstname());
            callableStatement.setString(2, user.getLastname());
            callableStatement.setString(3, user.getUsername());
            callableStatement.setString(4, user.getPassword());
            callableStatement.execute();
            return new Result("Successfully registered", true);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return new Result("Error in server", false);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    //login user

    public User login(String username, String password) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, dbUser, dbPassword);
            String query = "select * from users where username=? and password=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                username = resultSet.getString(2);
                String firstname = resultSet.getString(3);
                String lastname = resultSet.getString(4);
                password = resultSet.getString(5);
                User user = new User(
                        id,
                        firstname,
                        lastname,
                        password,
                        username);
                return user;
            }
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    public void deleteUser(int userId) {
        try {
            Connection connection = DriverManager.getConnection(url, dbUser, dbPassword);
            String query = "delete from users where id =?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();
            System.out.println("User is deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Transactions> getAllTransactions(){
        List<Transactions> transactionsList = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url,dbUser,dbPassword);
            String query = "select * from transactions";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Transactions transactions = new Transactions();
                transactions.setId(resultSet.getInt(1));
                transactions.setAmount(Double.valueOf(resultSet.getString(2)));
                transactions.setDate(resultSet.getDate(3));
                transactions.setSenderCardNumber(resultSet.getString(4));
                transactions.setReceiverCardNumber(resultSet.getString(5));
                transactionsList.add(transactions);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return transactionsList;
    }
}
