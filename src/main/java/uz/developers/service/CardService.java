package uz.developers.service;

import uz.developers.model.Bank;
import uz.developers.model.Card;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CardService {


    private Connection connection;

    PreparedStatement preparedStatement;

    ResultSet resultSet;


    public CardService(Connection connection) {
        this.connection = connection;
    }



    public List<Card> getAllCardList() {
        List<Card> cardList = new ArrayList<>();
        try {
            String query = "select * from card";
            preparedStatement = this.connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String card_number = resultSet.getString("card_number");
                String cardholder_name = resultSet.getString("cardholder_name");
                Date expiry_date = resultSet.getDate("expiry_date");
                String status = resultSet.getString("status");
                BigDecimal balance = resultSet.getBigDecimal("balance");
                String card_type = resultSet.getString("card_type");
                String bank_name = resultSet.getString("bank_name");
                cardList.add(new Card(id,card_type,bank_name, card_number,cardholder_name,expiry_date,status,balance));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cardList;
    }




    public void addCard(Card card) {
        int count = 0;
        try {
            String checkCardNumberQuery = "select count(*) from card where card_number='" + card.getCard_number() + "'";
            preparedStatement = this.connection.prepareStatement(checkCardNumberQuery);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }
            if (count > 0) {
                System.out.println("This card is already exist");
            }

            String insertQuery = "insert into card(card_number,address,iban,photo) values(?,?,?,?);";
            preparedStatement = this.connection.prepareStatement(insertQuery);
//            preparedStatement.setString(1, bank.getName());
//            preparedStatement.setString(2, bank.getAddress());
//            preparedStatement.setString(3, bank.getIban());
//            preparedStatement.setString(4, bank.getPhoto());
            preparedStatement.executeUpdate();
            System.out.println("Bank added successfully!!!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
