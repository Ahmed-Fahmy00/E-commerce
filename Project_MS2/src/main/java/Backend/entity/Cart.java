package Backend.entity;

import java.util.ArrayList;

public class Cart {
    private static int IdCounter = 1;
    private int cartId;
    private Customer customer;
    private ArrayList<Product> products;
    private int[] count;
    private double totalAmount;

    public Cart(Customer customer) {
        this.cartId = IdCounter++;
        this.customer = customer;
        this.products = new ArrayList<>();
        this.count = new int[0];
    }

    public int getCartId() {
        return cartId;
    }
    public Customer getCustomer() {
        return customer;
    }
    public ArrayList<Product> getProducts() {
        return products;
    }
    public int[] getCount() {
        return count;
    }
    public double getTotalAmount() {
        return totalAmount;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
    public void setCount(int[] count) {
        this.count = count;
    }
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

}
