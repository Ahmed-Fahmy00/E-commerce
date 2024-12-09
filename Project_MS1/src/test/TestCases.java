package test;

import dao.CustomerDAO;
import entity.Admin;
import entity.Customer;
import entity.Gender;
import entity.Product;

public class TestCases {

    public static void main(String[] args) {
        // Create and store customers
        Customer customer1 = new Customer("John", "Doe", "johndoe", "john@example.com", Gender.MALE, "password123", new Date(), "123 Main St", "555-1234");
        Customer customer2 = new Customer("Jane", "Smith", "janesmith", "jane@example.com", Gender.FEMALE, "password456", new Date(), "456 Elm St", "555-5678");
        CustomerDAO.addCustomer(customer1);
        CustomerDAO.addCustomer(customer2);

        // Create and store admins
        Admin admin1 = new Admin("Alice", "Johnson", "alicej", "alice@example.com", Gender.FEMALE, "adminpass", "Manager", "09:00-17:00", new Date(), "789 Oak St", "555-7890");
        Admin admin2 = new Admin("Bob", "Brown", "bobb", "bob@example.com", Gender.MALE, "adminpass2", "Supervisor", "10:00-18:00", new Date(), "321 Pine St", "555-3210");
        AdminDAO.addAdmin(admin1);
        AdminDAO.addAdmin(admin2);

        // Create and store products
        Product product1 = new Product("Laptop", "Electronics", 999.99, 10);
        Product product2 = new Product("Smartphone", "Electronics", 499.99, 20);
        ProductDAO.addProduct(product1);
        ProductDAO.addProduct(product2);

        System.out.println("Customers, admins, and products have been added to the database.");
    }
}
