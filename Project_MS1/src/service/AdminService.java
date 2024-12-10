package service;

import dao.*;
import entity.Customer;
import entity.Order;
import entity.Product;
import main.Main;
import java.util.Scanner;


public class AdminService {
    static Scanner scanner = new Scanner(System.in);
    public static void adminMenu() {
        final Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. View All Entities (Customers, Products, Orders)");
            System.out.println("2. View All Customers");
            System.out.println("3. View All Products");
            System.out.println("4. View All Orders");
            System.out.println("5. View Products by Category");
            System.out.println("6. Create new Product");
            System.out.println("7. Create new Customer");
            System.out.println("8. Remove Customer by Username");
            System.out.println("9. Remove Product by ID");
            System.out.println("10. Remove Order by ID");
            System.out.println("11. Exit");

            System.out.print("\nChoose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    viewAllEntities();
                    break;
                case 2:
                    viewAllCustomers();
                    break;
                case 3:
                    viewAllProducts();
                    break;
                case 4:
                    viewAllOrders();
                    break;
                case 5:
                    System.out.print("Enter category name to view products: ");
                    String categoryName = scanner.nextLine();
                    viewProductsByCategory(categoryName);
                    break;
                case 6:
                    createNewProduct();
                    break;
                case 7:
                    createNewCustomer();
                    break;
                case 8:
                    System.out.print("Enter username to remove: ");
                    String username = scanner.nextLine();
                    removeCustomerByUsername(username);
                    break;
                case 9:
                    System.out.print("Enter product ID to remove: ");
                    int productId = scanner.nextInt();
                    removeProductById(productId);
                    break;
                case 10:
                    System.out.print("Enter order ID to remove: ");
                    int orderId = scanner.nextInt();
                    removeOrderById(orderId);
                case 11:
                    System.out.println("Exiting Admin Menu.");
                    Main.MainMenu();
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void viewAllEntities() {
        CustomerDAO .displayAllCustomers();
        ProductDAO.displayAllProducts();
        OrderDAO.displayAllOrders();
    }
    public static void viewAllCustomers() {
        CustomerDAO.displayAllCustomers();
    }
    public static void viewAllProducts() {
        ProductDAO.displayAllProducts();
    }
    public static void viewAllOrders() {
        OrderDAO.displayAllOrders();
    }

    public static void removeCustomerByUsername(String username) {
        boolean removed = CustomerDAO.deleteCustomer(username);
        if (removed) {
            System.out.println("Customer with username '" + username + "' removed successfully.");
        } else {
            System.out.println("Customer with username '" + username + "' not found.");
        }
    }
    public static void removeProductById(int productId) {
        ProductDAO.deleteProduct(productId);
    }
    public static void removeOrderById(int orderId) {
        Order order = OrderDAO.findOrderById(orderId);
        if (order != null) {
            OrderDAO.deleteOrder(order);
        } else {
            System.out.println("Order with ID '" + orderId + "' not found.");
        }
    }

    public static void viewProductsByCategory(String categoryName) {
        System.out.println("Displaying Products in Category: " + categoryName);
        ProductDAO.findProductsByCategory(categoryName);
    }

    public static void createNewProduct() {
        System.out.println("Enter the details of the New Product to be added: ");
        Product product = new Product();

        System.out.println("Enter Product ID: ");
        product.setProductId(scanner.nextInt());
        scanner.nextLine(); // Consume newline character

        System.out.println("Enter Product Name: ");
        product.setName(scanner.nextLine());

        System.out.println("Enter Product Price: ");
        product.setPrice(scanner.nextDouble());
        scanner.nextLine(); // Consume newline character

        System.out.println("Enter Product Category: ");
        product.setCategory(scanner.nextLine());

        ProductDAO.addProduct(product);

        System.out.println("Product added successfully.");
    }
    public static void createNewCustomer() {
        System.out.println("Enter the details of the New Customer to be added: ");
        Customer customer = new Customer();

        System.out.println("Enter Customer username: ");
        customer.setUsername(scanner.nextLine());

        System.out.println("Enter Customer password: ");
        customer.setPassword(scanner.nextLine());

        CustomerDAO.addCustomer(customer);

        System.out.println("Customer added successfully.");
    }

}