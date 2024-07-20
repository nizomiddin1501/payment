package uz.developers.model;

public class User {
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone_number;

    private String photo;
    private String password;
    private String card_id;
    private String card_name;


    public User(Integer id, String firstname, String lastname, String email, String phone_number, String photo, String password) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone_number = phone_number;
        this.photo = photo;
        this.password = password;
    }

    public User() {
    }

    public User(String firstname, String lastname, String email, String phone_number, String photo, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone_number = phone_number;
        this.photo = photo;
        this.password = password;
    }

    public User(Integer id, String firstname, String lastname, String email, String password) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    public User(String firstname, String lastname, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }


    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public String getCard_name() {
        return card_name;
    }

    public void setCard_name(String card_name) {
        this.card_name = card_name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", phone_number=" + phone_number +
                ", photo='" + photo + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
