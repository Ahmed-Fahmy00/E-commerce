package service;

import dao.*;
import entity.Order;

import java.util.Scanner;

import static main.Main.MainMenu;

public class AdminService {

    public static void adminMenu() {
        final Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. View All Entities (Customers, Products, Orders)");
            System.out.println("2. View All Customers");
            System.out.println("3. View All Products");
            System.out.println("4. View All Orders");
            System.out.println("5. Remove Customer by Username");
            System.out.println("6. Remove Product by ID");
            System.out.println("7. Remove Order by ID");
            System.out.println("8. View Products by Category");
            System.out.println("9. Exit");

            System.out.print("\nChoose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character left by nextInt()

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
                    System.out.print("Enter username to remove: ");
                    String username = scanner.nextLine();
                    removeCustomerByUsername(username);
                    break;
                case 6:
                    System.out.print("Enter product ID to remove: ");
                    int productId = scanner.nextInt();
                    removeProductById(productId);
                    break;
                case 7:
                    System.out.print("Enter order ID to remove: ");
                    int orderId = scanner.nextInt();
                    removeOrderById(orderId);
                    break;
                case 8:
                    System.out.print("Enter category name to view products: ");
                    String categoryName = scanner.nextLine();
                    viewProductsByCategory(categoryName);
                    break;
                case 9:
                    System.out.println("Exiting Admin Menu.");
                    MainMenu();
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

}
