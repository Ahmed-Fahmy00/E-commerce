package test;

import dao.*;
import entity.Admin;
import entity.Customer;
import entity.Gender;
import entity.Product;

import java.util.Date;

public class TestCases {
    public static void te() {

        Customer customer1 = new Customer("John", "Doe", "johndoe", "john@example.com", Gender.MALE, "password123", "Customer", "123 Main St", "555-1234", "123 Main St", new Date());
        Customer customer2 = new Customer("Jane", "Smith", "janesmith", "jane@example.com", Gender.FEMALE, "password456", "Customer", "456 Elm St", "555-5678", "456 Elm St", new Date());
        CustomerDAO.addCustomer(customer1);
        CustomerDAO.addCustomer(customer2);

        Admin admin1 = new Admin("Alice", "Johnson", "alicej", "alice@example.com", Gender.FEMALE, "adminpass", "Manager", "09:00-17:00", new Date(), "789 Oak St", "555-7890");
        Admin admin2 = new Admin("Bob", "Brown", "bobb", "bob@example.com", Gender.MALE, "adminpass2", "Supervisor", "10:00-18:00", new Date(), "321 Pine St", "555-3210");
        AdminDAO.addAdmin(admin1);
        AdminDAO.addAdmin(admin2);

        Product product1 = new Product(10, "Electronics", 999.99, "Laptop");
        Product product2 = new Product(20, "Electronics", 499.99, "Smartphone");
        ProductDAO.addProduct(product1);
        ProductDAO.addProduct(product2);

        System.out.println("Customers, admins, and products have been added to the database.");
    }
}
