package uz.developers.model;

public class User {

    private int id;
    private String username;
    private String phone_number;

    private String card_number;
    private int balance;

    public User(int id, String username, String phone_number, String card_number, int balance) {
        this.id = id;
        this.username = username;
        this.phone_number = phone_number;
        this.card_number = card_number;
        this.balance = balance;
    }

    public User() {
    }


    public User(String username, String phone_number, String card_number, int balance) {
        this.username = username;
        this.phone_number = phone_number;
        this.card_number = card_number;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", card_number='" + card_number + '\'' +
                ", balance=" + balance +
                '}';
    }
}
