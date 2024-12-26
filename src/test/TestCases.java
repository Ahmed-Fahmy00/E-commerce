package test;

import Backend.dao.*;
import Backend.entity.*;
import Backend.entity.Enum.AdminRole;
import Backend.entity.Enum.Brand;
import Backend.entity.Enum.Gender;

import java.util.Date;

public class TestCases {
    static AdminDAO adminDAO = new AdminDAO();
    static CustomerDAO customerDAO = new CustomerDAO();
    static ProductDAO productDAO = new ProductDAO();

    public static void te() {
        Customer customer1 = new Customer("John", "Doe", "johndoe", "john@example.com", Gender.MALE, "password123", "123 Main St", "555-1234", "123 Main St", new Date());
        Customer customer2 = new Customer("Jane", "Smith", "janesmith", "jane@example.com", Gender.FEMALE, "password456", "456 Elm St", "555-5678", "456 Elm St", new Date());
        customerDAO.createCustomer(customer1);
        customerDAO.createCustomer(customer2);

        Admin admin1 = new Admin("a", "Johnson", "alicej", "alice@example.com", Gender.FEMALE, "a", AdminRole.Administrator, "09:00-17:00", new Date(), "789 Oak St", "555-7890");
        Admin admin2 = new Admin("Bob", "Brown", "bobb", "bob@example.com", Gender.MALE, "adminpass2", AdminRole.Administrator, "10:00-18:00", new Date(), "321 Pine St", "555-3210");
        adminDAO.addAdmin(admin1);
        adminDAO.addAdmin(admin2);

// Electronics
        Product product1 = new Product("Laptop", 999.99, "Electronics", Brand.HP, 4.5);
        Product product2 = new Product("Smartphone", 499.99, "Electronics", Brand.Samsung, 4.3);
        Product product3 = new Product("Tablet", 299.99, "Electronics", Brand.Apple, 4.2);
        Product product4 = new Product("Smartwatch", 199.99, "Electronics", Brand.Apple, 4.0);
        Product product5 = new Product("Headphones", 99.99, "Electronics", Brand.Samsung, 4.4);

// Home Appliances (Assuming default or shared brand)
        Product product6 = new Product("Air Conditioner", 899.99, "Home Appliances", Brand.Samsung, 4.6);
        Product product7 = new Product("Refrigerator", 599.99, "Home Appliances", Brand.Samsung, 4.5);
        Product product8 = new Product("Microwave Oven", 199.99, "Home Appliances", Brand.Samsung, 4.3);
        Product product9 = new Product("Vacuum Cleaner", 149.99, "Home Appliances", Brand.Samsung, 4.4);
        Product product10 = new Product("Washing Machine", 799.99, "Home Appliances", Brand.Samsung, 4.7);

// Clothing (Assuming a default brand for now)
        Product product11 = new Product("T-Shirt", 19.99, "Clothing", Brand.Apple, 4.1);
        Product product12 = new Product("Jeans", 39.99, "Clothing", Brand.Apple, 4.3);
        Product product13 = new Product("Jacket", 79.99, "Clothing", Brand.Apple, 4.4);
        Product product14 = new Product("Sneakers", 59.99, "Clothing", Brand.Apple, 4.5);
        Product product15 = new Product("Hat", 14.99, "Clothing", Brand.Apple, 4.2);

// Groceries (Assuming no specific brand, use a placeholder)
        Product product16 = new Product("Milk", 2.99, "Groceries", Brand.HP, 4.7);
        Product product17 = new Product("Bread", 1.99, "Groceries", Brand.HP, 4.6);
        Product product18 = new Product("Eggs", 3.99, "Groceries", Brand.HP, 4.5);
        Product product19 = new Product("Apple", 0.99, "Groceries", Brand.HP, 4.8);
        Product product20 = new Product("Cheese", 4.99, "Groceries", Brand.HP, 4.7);

// Sports (Assuming a default brand)
        Product product21 = new Product("Football", 29.99, "Sports", Brand.Microsoft, 4.3);
        Product product22 = new Product("Tennis Racket", 49.99, "Sports", Brand.Microsoft, 4.5);
        Product product23 = new Product("Basketball", 24.99, "Sports", Brand.Microsoft, 4.4);
        Product product24 = new Product("Yoga Mat", 19.99, "Sports", Brand.Microsoft, 4.6);
        Product product25 = new Product("Dumbbells", 39.99, "Sports", Brand.Microsoft, 4.7);


// Add products to the ProductDAO
        productDAO.addProduct(product1);
        productDAO.addProduct(product2);
        productDAO.addProduct(product3);
        productDAO.addProduct(product4);
        productDAO.addProduct(product5);
        productDAO.addProduct(product6);
        productDAO.addProduct(product7);
        productDAO.addProduct(product8);
        productDAO.addProduct(product9);
        productDAO.addProduct(product10);
        productDAO.addProduct(product11);
        productDAO.addProduct(product12);
        productDAO.addProduct(product13);
        productDAO.addProduct(product14);
        productDAO.addProduct(product15);
        productDAO.addProduct(product16);
        productDAO.addProduct(product17);
        productDAO.addProduct(product18);
        productDAO.addProduct(product19);
        productDAO.addProduct(product20);
        productDAO.addProduct(product21);
        productDAO.addProduct(product22);
        productDAO.addProduct(product23);
        productDAO.addProduct(product24);
        productDAO.addProduct(product25);
        System.out.println("Customers, admins, and products have been added to the database.");
    }
}
