package uz.developers.service;

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
                User user = new User(id,username,phone_number,card_number,balance);
                System.out.println(user);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error while retrieving accounts",e);
        }
    }










    public User getAccount(int userId){
        //List<User> users = new ArrayList<>();
            String query = "select * from getAccountById(?)";
            User user = null;
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

                user = new User(id,username,phone_number,card_number,balance);
                System.out.println(user);
            }
        } catch (SQLException e) {

            throw new RuntimeException("Error while fetching user by ID",e);
        }
       return user;
    }
    public void addAccount(User user) {
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


}
