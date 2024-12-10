package service;

import dao.OrderDAO;
import entity.Customer;
import entity.Order;
import entity.Product;
import java.util.List;
import java.util.Scanner;

public class OrderService {
    static Scanner scanner = new Scanner(System.in);

    public static void orderMenu(Customer customer) {
        while (true) {
            displayCustomerOrders(customer.getId());
            System.out.println("\n--- Order Menu ---");
            System.out.println("1. clear Orders");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    OrderDAO.deleteOrdersByCustomerId(customer.getId());
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
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Customer: " + order.getCustomer().getFirstnameName() + " " + order.getCustomer().getLastnameName());
        System.out.println("Payment Method: " + order.getPaymentMethod());
        System.out.println("Products in Order:");
        for (Product product : order.getProducts()) {
            System.out.println(product.getName() + " - " + product.getPrice());
        }
        System.out.println("Total Amount: " + order.getTotalAmount());
    }

    public static void displayAllOrders() {
        OrderDAO.displayAllOrders();
    }

    public static void displayCustomerOrders(int customerId) {
        System.out.println("--- Orders for Customer ID: " + customerId + " ---");
        List<Order> customerOrders = OrderDAO.findOrdersByCustomerId(customerId);
        if (customerOrders == null || customerOrders.isEmpty()) {
            System.out.println("No orders found for this customer.");
            return ;
        }
        for (Order order : customerOrders) {
            displayOrderDetails(order);
            System.out.println("----------------------------");
        }
    }

    public void cancelOrder(int orderId) {
        Order order = OrderDAO.findOrderById(orderId);
        if (order != null) {
            OrderDAO.deleteOrder(order);
            System.out.println("Order with ID " + orderId + " has been canceled.");
        } else {
            System.out.println("Order not found. Cancellation failed.");
        }
    }

}
