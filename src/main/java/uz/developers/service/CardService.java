package uz.developers.service;

import uz.developers.model.Bank;
import uz.developers.model.Card;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CardService {


    private Connection connection;

    PreparedStatement preparedStatement;

    ResultSet resultSet;


    public CardService(Connection connection) {
        this.connection = connection;
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
