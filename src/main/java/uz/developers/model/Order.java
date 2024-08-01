package uz.developers.model;

public class Order {

    private int orderId;
    private int userId;


    public Order(int orderId) {
        this.orderId = orderId;
        this.userId = userId;
    }

    public Order() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
