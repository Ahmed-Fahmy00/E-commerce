package Backend.service;

import Backend.dao.CustomerDAO;
import Backend.dao.OrderDAO;
import Backend.dao.ProductDAO;
import Backend.entity.Customer;
import Backend.entity.Order;
import Backend.entity.Product;
import Backend.service.Main;

import java.util.Scanner;


public class AdminService {
    static Scanner scanner = new Scanner(System.in);

    static CustomerDAO customerDAO = new CustomerDAO();
    static ProductDAO productDAO = new ProductDAO();
    static OrderDAO orderDAO = new OrderDAO();

    static CustomerService customerService = new CustomerService();
    static ProductService productService = new ProductService();
    static OrderService orderService = new OrderService();


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
                    customerService.displayAllCustomers();
                    break;
                case 3:
                    productService.displayAllProducts();
                    break;
                case 4:
                    orderService.displayAllOrders();
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
        customerService.displayAllCustomers();
        productService.displayAllProducts();
        orderService.displayAllOrders();
    }

    public static void removeCustomerByUsername(String username) {
        boolean removed = customerDAO.deleteCustomer(username);
        if (removed) {
            System.out.println("Customer with username '" + username + "' removed successfully.");
        } else {
            System.out.println("Customer with username '" + username + "' not found.");
        }
    }
    public static void removeProductById(int productId) {
        productDAO.deleteProduct(productId);
    }
    public static void removeOrderById(int orderId) {
        Order order = orderDAO.getOrderById(orderId);
        if (order != null) {
            orderDAO.deleteOrder(order);
        } else {
            System.out.println("Order with ID '" + orderId + "' not found.");
        }
    }

    public static void viewProductsByCategory(String categoryName) {
        System.out.println("Displaying Products in Category: " + categoryName);
        productDAO.getProductsByCategory(categoryName);
    }

    public static void createNewProduct() {
        System.out.println("Enter the details of the New Product to be added: ");
        Product product = new Product();

        System.out.println("Enter Product Name: ");
        product.setName(scanner.nextLine());

        System.out.println("Enter Product Price: ");
        product.setPrice(scanner.nextDouble());
        scanner.nextLine();

        System.out.println("Enter Product Category: ");
        product.setCategory(scanner.nextLine());

        productDAO.addProduct(product);

        System.out.println("Product added successfully.");
    }
    public static void createNewCustomer() {
        System.out.println("Enter the details of the New Customer to be added: ");
        Customer customer = new Customer();

        System.out.println("Enter Customer username: ");
        customer.setUsername(scanner.nextLine());

        System.out.println("Enter Customer password: ");
        customer.setPassword(scanner.nextLine());

        customerDAO.createCustomer(customer);

        System.out.println("Customer added successfully.");
    }
}