package entity;

import java.util.ArrayList;

public class Cart {
    private int cartId;
    private Customer customer;
    private ArrayList<Product> products;
    private int[] count;

    public Cart(int cartId, Customer customer) {
        this.cartId = cartId;
        this.customer = customer;
        this.products = new ArrayList<>(20);
        this.count = new int[20];
    }

    public int getCartId() {
        return cartId;
    }
    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public int[] getCount() {
        return count;
    }
    public void setCount(int[] count) {
        this.count = count;
    }
}
