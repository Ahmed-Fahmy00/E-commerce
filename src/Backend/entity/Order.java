package Backend.entity;

import Backend.entity.Enum.PaymentMethod;

import java.util.List;

public class Order {
    private static int Idcounter = 1;
    private int orderId;
    private Customer customer;
    private List<Product> products;
    private double totalAmount;
    private PaymentMethod paymentMethod;

    public Order(Customer customer, List<Product> products, PaymentMethod paymentMethod,double totalAmount) {
        this.orderId = Idcounter++;
        this.customer = customer;
        this.products = products;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
    }

    public int getOrderId() {
        return orderId;
    }
    public Customer getCustomer() {
        return customer;
    }
    public List<Product> getProducts() {
        return products;
    }
    public double getTotalAmount() {
        return totalAmount;
    }
    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

}

