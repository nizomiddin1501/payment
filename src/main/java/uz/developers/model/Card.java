package uz.developers.model;

import java.util.Date;

public class Card {
    private Integer id;
    private String BankName;
    private String number;
    private String expiryDate;
    private Integer phone_number;

    public Card() {
    }

    public Card(String bankName, String number, String expiryDate, Integer phone_number) {
        this.BankName = bankName;
        this.number = number;
        this.expiryDate = expiryDate;
        this.phone_number = phone_number;
    }

    public Card(Integer id, String bankName, String number, String expiryDate, Integer phone_number) {
        this.id = id;
        this.BankName = bankName;
        this.number = number;
        this.expiryDate = expiryDate;
        this.phone_number = phone_number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBankName() {
        return BankName;
    }

    public void setBankName(String bankName) {
        BankName = bankName;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Integer getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(Integer phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", BankName='" + BankName + '\'' +
                ", number='" + number + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", phone_number=" + phone_number +
                '}';
    }
}

