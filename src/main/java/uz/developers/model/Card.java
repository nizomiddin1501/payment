package uz.developers.model;

import java.math.BigDecimal;
import java.sql.Date;

public class Card {

    private Integer id;

    private Integer order_id;
    private String card_type;
    private String bank_name;

    private String card_number;
    private String cardholder_name;
    private Date expiry_date;
    private Date issue_date;
    private String status;
    private BigDecimal balance;
    private String currency;
    private Integer user_id;

    public Card(String cardNumber, String cardholderName, Date expiryDate, Date issueDate, String status, BigDecimal balance, String currency, int userId, String cardType, String bankName) {
        this.card_number = cardNumber;
        this.cardholder_name = cardholderName;
        this.expiry_date = expiryDate;
        this.issue_date = issueDate;
        this.status = status;
        this.balance = balance;
        this.currency = currency;
        this.user_id = userId;
        this.card_type = cardType;
        this.bank_name = bankName;


    }

    public Card(Integer order_id, String card_type, String bank_name, String card_number, String cardholder_name, Date expiry_date, Date issue_date, String status, BigDecimal balance, String currency, Integer user_id) {
        this.order_id = order_id;
        this.card_type = card_type;
        this.bank_name = bank_name;
        this.card_number = card_number;
        this.cardholder_name = cardholder_name;
        this.expiry_date = expiry_date;
        this.issue_date = issue_date;
        this.status = status;
        this.balance = balance;
        this.currency = currency;
        this.user_id = user_id;
    }

    public Card(Integer id, Integer order_id, String card_type, String bank_name, String card_number, String cardholder_name, Date expiry_date, Date issue_date, String status, BigDecimal balance, String currency, Integer user_id) {
        this.id = id;
        this.order_id = order_id;
        this.card_type = card_type;
        this.bank_name = bank_name;
        this.card_number = card_number;
        this.cardholder_name = cardholder_name;
        this.expiry_date = expiry_date;
        this.issue_date = issue_date;
        this.status = status;
        this.balance = balance;
        this.currency = currency;
        this.user_id = user_id;
    }

    public Card(String card_type, String bank_name, String card_number, String cardholder_name, Date expiry_date, Date issue_date, String status, BigDecimal balance, String currency, Integer user_id) {
        this.card_type = card_type;
        this.bank_name = bank_name;
        this.card_number = card_number;
        this.cardholder_name = cardholder_name;
        this.expiry_date = expiry_date;
        this.issue_date = issue_date;
        this.status = status;
        this.balance = balance;
        this.currency = currency;
        this.user_id = user_id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public String getCard_type() {
        return card_type;
    }

    public void setCard_type(String card_type) {
        this.card_type = card_type;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getCardholder_name() {
        return cardholder_name;
    }

    public void setCardholder_name(String cardholder_name) {
        this.cardholder_name = cardholder_name;
    }

    public Date getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(Date expiry_date) {
        this.expiry_date = expiry_date;
    }

    public Date getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(Date issue_date) {
        this.issue_date = issue_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }




    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", card_number='" + card_number + '\'' +
                ", cardholder_name='" + cardholder_name + '\'' +
                ", expiry_date=" + expiry_date +
                ", issue_date=" + issue_date +
                ", status='" + status + '\'' +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}

