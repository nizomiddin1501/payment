package uz.developers.service;

import uz.developers.model.Account;
import uz.developers.model.User;

import java.sql.*;

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
                Account user = new Account(id,username,phone_number,card_number,balance);
                System.out.println(user);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error while retrieving accounts",e);
        }
    }
    public Account getAccount(int userId){
        //List<User> users = new ArrayList<>();
            String query = "select * from getAccountById(?)";
            Account user = null;
        try {
            Connection connection = DriverManager.getConnection(url,dbUser,dbPassword);
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setInt(1,userId);

            ResultSet resultSet = callableStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String phone_number = resultSet.getString("phone_number");
                int balance = resultSet.getInt("balance");
                String card_number = resultSet.getString("card_number");

                user = new Account(id,username,phone_number,card_number,balance);
                System.out.println(user);
            }
        } catch (SQLException e) {

            throw new RuntimeException("Error while fetching user by ID",e);
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
                callableStatement.registerOutParameter(5,Types.VARCHAR);

                callableStatement.execute();

                status_message = callableStatement.getString(5);
                System.out.println(status_message);

            } catch (SQLException e) {
                throw new RuntimeException("Error while adding account", e);
            }
    }
    public void editAccount(String senderCardNumber, String receiverCardNumber, int amount) {
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

            System.out.println(statusMessage);
        } catch (SQLException e) {
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


    public void registerUser(User user){
        Connection connection = null;
        CallableStatement callableStatement = null;

        try {
            Class.forName("org.postgresql.Driver");
            String sql = "CALL insert_users(?, ?, ?, ?)";
            connection = DriverManager.getConnection(url,dbUser,dbPassword);
            callableStatement = connection.prepareCall(sql);
            callableStatement.setString(1,user.getFirstname());
            callableStatement.setString(2,user.getLastname());
            callableStatement.setString(3,user.getUsername());
            callableStatement.setString(4,user.getPassword());
            callableStatement.execute();
            System.out.println("User is added by callableStatement");
            callableStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
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



}
