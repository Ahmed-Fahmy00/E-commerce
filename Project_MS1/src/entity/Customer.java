package entity;

import java.util.Date;

public class Customer extends User {
    private String shippingAddress;
    private double balance;
    private static int counter=0;
    private int id;
    public Customer() {
        super();
        this.balance = 0.0; // Initialize balance to 0

        this.id= counter++;
    }
    public Customer(String firstname, String lastname, String username, String email, Gender gender, String password, String role, String address, String phone, String shippingAddress, Date dateOfBirth) {
        super(firstname, lastname, username, email, gender, password, "Customer", address, phone, dateOfBirth);
        this.shippingAddress = shippingAddress;
        this.balance = 0.0; // Initialize balance to
        this.id= counter++;
    }

    public String getShippingAddress() { return shippingAddress; }
    public double getBalance() { return balance; }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public void addBalance(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be greater than 0.");
        this.balance += amount;
    }

    public void updateProfile(String firstname, String lastname, String address, String phone, String shippingAddress) {
        setFirstName(firstname);
        setLastname(lastname);
        setAddress(address);
        setPhone(phone);
        setShippingAddress(shippingAddress);
    }

    @Override
    public String toString() {
        return "------" + getUsername() + "'s Personal Information------" +
                "\n  Firstname: " + getFirstnameName() +
                "\n  Lastname: " + getLastnameName() +
                "\n  Email: " + getEmail() +
                "\n  Gender: " + getGender() +
                "\n  Shipping Address: " + getShippingAddress() +
                "\n  Address: " + getAddress() +
                "\n  Phone: " + getPhone() +
                "\n  Date of Birth: " + getDateOfBirth() +
                "\n  Balance: " + getBalance() +
                "\n--------------------------------------";
    }

    public int getId() {
        return id;
    }
}
