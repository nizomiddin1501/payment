package uz.developers.model;

public class Bank {

    private Integer id;
    private String name;
    private String address;
    private String iban;
    private String photo;

    public Bank() {
    }

    public Bank(String name, String address, String iban, String photo) {
        this.name = name;
        this.address = address;
        this.iban = iban;
        this.photo = photo;
    }

    public Bank(Integer id, String name, String address, String iban, String photo) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.iban = iban;
        this.photo = photo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", iban='" + iban + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
