package uz.developers.service;

import uz.developers.model.Bank;
import uz.developers.model.Card;
import uz.developers.model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BankService {


    private Connection connection;

    PreparedStatement preparedStatement;
    PreparedStatement preparedStatement1;


    ResultSet resultSet;

    public BankService(Connection connection) {
        this.connection = connection;
    }

    public List<Bank> getAllBankList() {
        List<Bank> bankList = new ArrayList<>();
        try {
            String query = "select * from bank";
            preparedStatement = this.connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String iban = resultSet.getString("iban");
                String photo = resultSet.getString("photo");
                bankList.add(new Bank(id, name, address, iban, photo));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bankList;
    }


    public Bank getBankById(int bankId) {
        Bank bank = new Bank();
        try {
            String query = "select * from bank where id=?";
            preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1, bankId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String iban = resultSet.getString("iban");
                String photo = resultSet.getString("photo");

                bank = new Bank(id, name, address, iban, photo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bank;
    }


    public void addBank(Bank bank) {
        int count = 0;
        try {
            String checkNameQuery = "select count(*) from bank where name='" + bank.getName() + "'";
            preparedStatement = this.connection.prepareStatement(checkNameQuery);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }
            if (count > 0) {
                System.out.println("This name is already exist");
            }

            String checkIbanQuery = "select count(*) from bank where iban='" + bank.getIban() + "'";
            preparedStatement = this.connection.prepareStatement(checkIbanQuery);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }
            if (count > 0) {
                System.out.println("This iban is already exist");
            }


            String insertQuery = "insert into bank(name,address,iban,photo) values(?,?,?,?);";
            preparedStatement = this.connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, bank.getName());
            preparedStatement.setString(2, bank.getAddress());
            preparedStatement.setString(3, bank.getIban());
            preparedStatement.setString(4, bank.getPhoto());
            preparedStatement.executeUpdate();
            System.out.println("Bank added successfully!!!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public boolean updateBank(Bank bank) {
        boolean rowUpdated = false;
        try {
            String updateQuery = "update bank set name=?,address=?,iban=?,photo=? where id=?";
            preparedStatement = this.connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, bank.getName());
            preparedStatement.setString(2, bank.getAddress());
            preparedStatement.setString(3, bank.getIban());
            preparedStatement.setString(4, bank.getPhoto());
            preparedStatement.setInt(5, bank.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error while updating bank", e);
        }
        return rowUpdated;
    }

    public void deleteBank(int id) {
        try {
            String deleteQuery = "delete from bank where id =?";
            preparedStatement = this.connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Bank is deleted");
        } catch (SQLException e) {
            throw new RuntimeException("Error while deleting bank", e);
        }
    }





    public boolean buyNewCard(Order order, Card card) {
        try {

            String insertOrderQuery = "insert into card_order(users_id) values(?) returning id;";
            String insertCardQuery = "insert into card(order_id,card_number,cardholder_name,expiry_date," +
                    "issue_date,status,balance,currency,users_id,card_type,bank_name) " +
                    "values(?,?,?,?,?,?,?,?,?,?,?);";

            preparedStatement = this.connection.prepareStatement(insertOrderQuery);
            preparedStatement1 = this.connection.prepareStatement(insertCardQuery);
            preparedStatement.setInt(1, order.getUserId());

            int order_id = -1;
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
               order_id = resultSet.getInt("id");
//               order.setOrderId(order_id);
//               card.setOrder_id(order_id);
            }


            if (order_id!=-1) {
                preparedStatement1.setInt(1, card.getOrder_id());
                preparedStatement1.setString(2, card.getCard_number());
                preparedStatement1.setString(3, card.getCardholder_name());
                preparedStatement1.setDate(4, (Date) card.getExpiry_date());
                preparedStatement1.setDate(5, (Date) card.getIssue_date());
                preparedStatement1.setString(6, card.getStatus());
                preparedStatement1.setBigDecimal(7, card.getBalance());
                preparedStatement1.setString(8, card.getCurrency());
                preparedStatement1.setInt(9, card.getUser_id());
                preparedStatement1.setString(10, card.getCard_type());
                preparedStatement1.setString(11, card.getBank_name());

                int rowsInserted = preparedStatement1.executeUpdate();
                return rowsInserted > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
