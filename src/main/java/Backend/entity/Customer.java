package Backend.entity;

import Backend.dao.CartDAO;
import Backend.entity.Enum.Gender;
import Database.Database;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Customer extends User {
    private String shippingAddress;
    private double balance;
    private static int IdCounter = 1;
    private int Id;

    public Customer() {
        super();
        this.balance = 0.0;
        this.Id= IdCounter++;
    }
    public Customer(String firstname, String lastname, String username, String email, Gender gender, String password, String address, String phone, String shippingAddress, Date dateOfBirth) {
        super(firstname, lastname, username, email, gender, password, address, phone, dateOfBirth);
        this.shippingAddress = shippingAddress;
        this.balance = 0.0;
        this.Id= IdCounter++;
    }

    public int getId() {
        return Id;
    }
    public String getShippingAddress() { return shippingAddress; }
    public double getBalance() { return balance; }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
    public void setBalance(double amount) {
        this.balance = amount;
    }

    @Override
    public String toString() {
        return "------ Customer's Details ------" +
                "\n  Firstname: " + getFirstnameName() +
                "\n  Lastname: " + getLastnameName() +
                "\n  Username: " + getUsername() +
                "\n  Email: " + getEmail() +
                "\n Shipping Address: " + getShippingAddress();
    }
}
