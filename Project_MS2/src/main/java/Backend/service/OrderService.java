package Backend.service;

import Backend.dao.OrderDAO;
import Backend.entity.Customer;
import Backend.entity.Order;
import Backend.entity.Product;

import java.util.List;
import java.util.Scanner;

public class OrderService {
    static Scanner scanner = new Scanner(System.in);

    static OrderDAO orderDAO = new OrderDAO();

    public static void orderMenu(Customer customer) {
        while (true) {
            displayCustomerOrders(customer.getId());
            System.out.println("\n--- Order Menu ---");
            System.out.println("1. Clear Orders");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    orderDAO.deleteOrdersByCustomerId(customer.getId());
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

    }

    public static void displayOrderDetails(Order order) {
        if (order == null) {
            System.out.println("Order not found.");
            return;
        }

        System.out.println("\n--- Order Details ---");
        System.out.printf("Order ID: %d%n", order.getOrderId());
        System.out.printf("Customer: %s %s%n",
                order.getCustomer().getFirstnameName(),
                order.getCustomer().getLastnameName());
        System.out.printf("Payment Method: %s%n", order.getPaymentMethod());
        System.out.println("Products in Order:");

        if (order.getProducts().isEmpty()) {
            System.out.println("  No products in this order.");
        } else {
            for (Product product : order.getProducts()) {
                System.out.printf("  - %s%n", product.getName());  // Removed the quantity part
            }
        }
        System.out.printf("Total: $%.2f%n", order.getTotalAmount());
        System.out.println();
    }

    public static void displayCustomerOrders(int customerId) {
        System.out.println("--- Orders for Customer ID: " + customerId + " ---");
        List<Order> customerOrders = orderDAO.getOrdersByCustomerId(customerId);
        if (customerOrders == null || customerOrders.isEmpty()) {
            System.out.println("No orders found for this customer.");
            return;
        }
        for (Order order : customerOrders) {
            displayOrderDetails(order);
        }
    }

    public void cancelOrder(int orderId) {
        Order order = orderDAO.getOrderById(orderId);
        if (order != null) {
            orderDAO.deleteOrder(order);
            System.out.println("Order with ID " + orderId + " has been canceled.");
        } else {
            System.out.println("Order not found. Cancellation failed.");
        }
    }

    public static void displayAllOrders() {
        List<Order> orders = orderDAO.getAllOrders();
        if (orders.isEmpty()) {
            System.out.println("No orders found.");
            return;
        }
        System.out.println("All Orders:");
        for (Order order : orders) {
            System.out.println(order);
        }
    }

}
