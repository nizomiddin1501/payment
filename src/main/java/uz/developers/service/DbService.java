package uz.developers.service;

import uz.developers.model.Account;
import uz.developers.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbService {


    private Connection connection;

    CallableStatement callableStatement;


    PreparedStatement preparedStatement;

    ResultSet resultSet;

    public DbService(Connection connection) {
        this.connection = connection;
    }

    private static final String insertAccountQuery = "insert into users(username,phone_number,balance,card_number) values(?,?,?,?);";
    private static final String getAccountByIdQuery = "select id, username, phone_number, balance, card_number from accounts where id=?";
    private static final String getAccountsQuery = "select * from accounts";
    private static final String deleteAccountQuery = "delete from accounts where id =?";
    private static final String updateAccountQuery = "update accounts set username=?,phone_number=?,card_number=?where id=?";



    //insert account

    public void addAccount(Account account){
        try(PreparedStatement preparedStatement = connection.prepareStatement(insertAccountQuery)) {
            preparedStatement.setString(1,account.getUsername());
            preparedStatement.setString(2,account.getPhone_number());
            preparedStatement.setInt(3,account.getBalance());
            preparedStatement.setString(4,account.getCard_number());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //update account
    public boolean updateAccount(Account account){
        boolean rowUpdated;
        try(PreparedStatement preparedStatement = connection.prepareStatement(updateAccountQuery)) {
            preparedStatement.setString(1,account.getUsername());
            preparedStatement.setString(2,account.getPhone_number());
            preparedStatement.setInt(3,account.getBalance());
            preparedStatement.setString(4,account.getCard_number());
            preparedStatement.setInt(4,account.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowUpdated;
    }

    //select account by id
    public Account getAccount(int accountId){  //selectUser
        Account account = null;
        try(PreparedStatement preparedStatement = connection.prepareStatement(getAccountByIdQuery)) {
            preparedStatement.setInt(1,accountId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String phone_number = resultSet.getString("phone_number");
                int balance = resultSet.getInt("balance");
                String card_number = resultSet.getString("card_number");
                account = new Account(accountId,username,phone_number,card_number,balance);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return account;
    }

    //select accounts
    public List<Account> getAccounts(){   //selectAllUsers
        List<Account> accounts = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement(getAccountsQuery)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String phone_number = resultSet.getString("phone_number");
                int balance = resultSet.getInt("balance");
                String card_number = resultSet.getString("card_number");
                accounts.add(new Account(id,username,phone_number,card_number,balance));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return accounts;
    }

    //delete account
    public boolean deleteAccount(int accountId){
        boolean rowDeleted;
        try(PreparedStatement preparedStatement = connection.prepareStatement(deleteAccountQuery)) {
            preparedStatement.setInt(1,accountId);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDeleted;
    }


    //exception

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }







}
