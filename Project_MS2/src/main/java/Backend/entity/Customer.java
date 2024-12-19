package Backend.entity;

import Backend.entity.Enum.Gender;

import java.util.Date;

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
    public void SetBalance(double amount) {
        this.balance = amount;
    }
    public void updateProfile(String firstname, String lastname, String address, String phone, String shippingAddress) {
        super.setFirstName(firstname);
        super.setLastname(lastname);
        super.setAddress(address);
        super.setPhone(phone);
        this.setShippingAddress(shippingAddress);
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
}
