package uz.developers.service;

import uz.developers.model.Result;
import uz.developers.model.Transactions;
import uz.developers.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {


    private Connection connection;

    CallableStatement callableStatement;


    PreparedStatement preparedStatement;

    ResultSet resultSet;


    public UserService(Connection connection) {
        this.connection = connection;
    }


    public List<User> getAllClientList() {
        List<User> userList = new ArrayList<>();
        try {
            String selectQuery = "select * from users;";
            preparedStatement = this.connection.prepareStatement(selectQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String email = resultSet.getString("email");
                String phone_number = resultSet.getString("phone_number");
                String photo = resultSet.getString("photo");
                String password = resultSet.getString("password");


                userList.add(new User(id, firstname, lastname, email, phone_number,photo,password));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }




    public User getClientById(int userId) {
        User user = new User();
        try {
            String query = "select * from users where id = ?;";
            preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String email = resultSet.getString("email");
                String phone_number = resultSet.getString("phone_number");
                String password = resultSet.getString("password");
                String photo = resultSet.getString("photo");

                user = new User(id, firstname,lastname,email,phone_number,photo,password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }



    public boolean editUser(User user) {
        boolean rowUpdated = false;
        try {
            String query = "update users set firstname = ?, lastname = ?, email = ?, phone_number = ?, photo = ?, password = ? where id = ?";
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, user.getFirstname());
            preparedStatement.setString(2, user.getLastname());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPhone_number());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setString(6, user.getPhoto());

            preparedStatement.setInt(7, user.getId());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }



    public void deleteClient(int id) {
        try {
            String deleteQuery = "delete from users where id =?";
            preparedStatement = this.connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Client is deleted");
        } catch (SQLException e) {
            throw new RuntimeException("Error while deleting client", e);
        }
    }








    public Result registerUser(User user) {
        int count = 0;
        try {
            String checkEmailQuery = "select count(*) from users where email='" + user.getEmail() + "'";
            preparedStatement = this.connection.prepareStatement(checkEmailQuery);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }
            if (count > 0) {
                return new Result("Email already exist", false);
            }
            String checkPasswordQuery = "select count(*) from users where password='" + user.getPassword() + "'";
            preparedStatement = this.connection.prepareStatement(checkPasswordQuery);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }
            if (count > 0) {
                return new Result("Password is already exist", false);
            }

            String checkPhoneNumberQuery = "select count(*) from users where phone_number='" + user.getPhone_number() + "'";
            preparedStatement = this.connection.prepareStatement(checkPhoneNumberQuery);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }
            if (count > 0) {
                return new Result("Phone Number is already exist", false);
            }
            String sql = "call insert_users(?, ?, ?, ?, ?, ?)";
            callableStatement = this.connection.prepareCall(sql);
            callableStatement.setString(1, user.getFirstname());
            callableStatement.setString(2, user.getLastname());
            callableStatement.setString(3, user.getEmail());
            callableStatement.setString(4, user.getPhone_number());
            callableStatement.setString(5, user.getPhoto());
            callableStatement.setString(6, user.getPassword());
            callableStatement.execute();
            return new Result("Successfully registered", true);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return new Result("Error in server", false);
        }
    }


    //login user

    public User login(String email, String password) {
        try {
            String query = "select * from users where email=? and password=?";
            preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String firstname = resultSet.getString(2);
                String lastname = resultSet.getString(3);
                email = resultSet.getString(4);
                String phone_number = resultSet.getString(5);
                String photo = resultSet.getString(6);
                password = resultSet.getString(7);
                User user = new User(id, firstname, lastname, email, phone_number, photo, password);
                return user;
            }
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


    public void deleteUser(int userId) {
        try {
            String query = "delete from users where id =?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();
            System.out.println("User is deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Transactions> getAllTransactions() {
        List<Transactions> transactionsList = new ArrayList<>();
        try {
            String query = "select * from transactions";
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Transactions transactions = new Transactions();
                transactions.setId(resultSet.getInt(1));
                transactions.setAmount(Double.valueOf(resultSet.getString(2)));
                transactions.setDate(resultSet.getDate(3));
                transactions.setSender_card_number(resultSet.getString(4));
                transactions.setReceiver_card_number(resultSet.getString(5));
                transactionsList.add(transactions);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return transactionsList;
    }
}
