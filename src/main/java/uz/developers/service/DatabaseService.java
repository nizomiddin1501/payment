package uz.developers.service;

import uz.developers.model.Account;
import uz.developers.model.Result;
import uz.developers.model.Transactions;
import uz.developers.model.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseService {


    private Connection connection;

    CallableStatement callableStatement;


    PreparedStatement preparedStatement;

    ResultSet resultSet;

    public DatabaseService(Connection connection) {
        this.connection = connection;
    }


    //ps


    public void getAccounts() {
        try {
            String query = "select * from get_accounts()";
            callableStatement = this.connection.prepareCall(query);
            resultSet = callableStatement.executeQuery();
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
        String query = "select * from getAccountById(?)";
        Account account = null;
        try {
            callableStatement = this.connection.prepareCall(query);
            callableStatement.setInt(1, userId);

            resultSet = callableStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String phone_number = resultSet.getString("phone_number");
                int balance = resultSet.getInt("balance");
                String card_number = resultSet.getString("card_number");

                account = new Account(id, username, phone_number, card_number, balance);
                System.out.println(account);
            }
        } catch (SQLException e) {

            throw new RuntimeException("Error while fetching user by ID", e);
        }
        return account;
    }

    public void addAccount(Account user) {
        try {
            String query = "call add_account(?,?,?,?,?)";
            String status_message = "";
            callableStatement = this.connection.prepareCall(query);
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
            String query = "call transfer(?,?,?,?)";
            String statusMessage = "";
            callableStatement = this.connection.prepareCall(query);
            callableStatement.setString(1, senderCardNumber);
            callableStatement.setString(2, receiverCardNumber);
            callableStatement.setInt(3, amount);
            callableStatement.registerOutParameter(4, Types.VARCHAR);
            callableStatement.execute();
            statusMessage = callableStatement.getString(4);

            Transactions transactions = new Transactions();
            LocalDate transactionDate = LocalDate.now();
            query = "insert into transactions(amount,date,sender_card_number,receiver_card_number) values(?,?,?,?) ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDouble(1, amount);
            preparedStatement.setDate(2, Date.valueOf(transactionDate));
            preparedStatement.setString(3,senderCardNumber);
            preparedStatement.setString(4,receiverCardNumber);
            preparedStatement.executeUpdate();
            System.out.println(statusMessage);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void editAccount(Account account) {
        try {
            String query = "update accounts set username=?,phone_number=?,card_number=? where id=?";
            preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPhone_number());
            preparedStatement.setString(3, account.getCard_number());
            preparedStatement.setInt(4, account.getId());
            preparedStatement.executeUpdate();
            System.out.println("User is edited by prepareStatement");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void deleteAccount(int userId) {
        try {
            String query = "delete from accounts where id =?";
            preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();
            System.out.println("Account is deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    //register user



}
