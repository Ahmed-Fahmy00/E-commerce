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

        Admin admin1 = new Admin("a", "Johnson", "alicej", "alice@example.com", Gender.FEMALE, "a", "Manager", "09:00-17:00", new Date(), "789 Oak St", "555-7890");
        Admin admin2 = new Admin("Bob", "Brown", "bobb", "bob@example.com", Gender.MALE, "adminpass2", "Supervisor", "10:00-18:00", new Date(), "321 Pine St", "555-3210");
        AdminDAO.addAdmin(admin1);
        AdminDAO.addAdmin(admin2);

// Electronics
        Product product1 = new Product(1, "Laptop", 999.99, "Electronics");
        Product product2 = new Product(2, "Smartphone", 499.99, "Electronics");
        Product product3 = new Product(3, "Tablet", 299.99, "Electronics");
        Product product4 = new Product(4, "Smartwatch", 199.99, "Electronics");
        Product product5 = new Product(5, "Headphones", 99.99, "Electronics");

// Home Appliances
        Product product6 = new Product(6, "Air Conditioner", 899.99, "Home Appliances");
        Product product7 = new Product(7, "Refrigerator", 599.99, "Home Appliances");
        Product product8 = new Product(8, "Microwave Oven", 199.99, "Home Appliances");
        Product product9 = new Product(9, "Vacuum Cleaner", 149.99, "Home Appliances");
        Product product10 = new Product(10, "Washing Machine", 799.99, "Home Appliances");

// Clothing
        Product product11 = new Product(11, "T-Shirt", 19.99, "Clothing");
        Product product12 = new Product(12, "Jeans", 39.99, "Clothing");
        Product product13 = new Product(13, "Jacket", 79.99, "Clothing");
        Product product14 = new Product(14, "Sneakers", 59.99, "Clothing");
        Product product15 = new Product(15, "Hat", 14.99, "Clothing");

// Groceries
        Product product16 = new Product(16, "Milk", 2.99, "Groceries");
        Product product17 = new Product(17, "Bread", 1.99, "Groceries");
        Product product18 = new Product(18, "Eggs", 3.99, "Groceries");
        Product product19 = new Product(19, "Apple", 0.99, "Groceries");
        Product product20 = new Product(20, "Cheese", 4.99, "Groceries");

// Sports
        Product product21 = new Product(21, "Football", 29.99, "Sports");
        Product product22 = new Product(22, "Tennis Racket", 49.99, "Sports");
        Product product23 = new Product(23, "Basketball", 24.99, "Sports");
        Product product24 = new Product(24, "Yoga Mat", 19.99, "Sports");
        Product product25 = new Product(25, "Dumbbells", 39.99, "Sports");

// Add products to the ProductDAO
        ProductDAO.addProduct(product1);
        ProductDAO.addProduct(product2);
        ProductDAO.addProduct(product3);
        ProductDAO.addProduct(product4);
        ProductDAO.addProduct(product5);
        ProductDAO.addProduct(product6);
        ProductDAO.addProduct(product7);
        ProductDAO.addProduct(product8);
        ProductDAO.addProduct(product9);
        ProductDAO.addProduct(product10);
        ProductDAO.addProduct(product11);
        ProductDAO.addProduct(product12);
        ProductDAO.addProduct(product13);
        ProductDAO.addProduct(product14);
        ProductDAO.addProduct(product15);
        ProductDAO.addProduct(product16);
        ProductDAO.addProduct(product17);
        ProductDAO.addProduct(product18);
        ProductDAO.addProduct(product19);
        ProductDAO.addProduct(product20);
        ProductDAO.addProduct(product21);
        ProductDAO.addProduct(product22);
        ProductDAO.addProduct(product23);
        ProductDAO.addProduct(product24);
        ProductDAO.addProduct(product25);
        System.out.println("Customers, admins, and products have been added to the database.");


    }
}
