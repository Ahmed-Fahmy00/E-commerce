package dao;

import database.Database;
import entity.Order;
import entity.Product;

import java.util.ArrayList;
import java.util.List;
import static database.Database.orders;

public class OrderDAO {

    public void createOrder(Order order) {
        Database.orders.add(order);
        System.out.println("Order created successfully with ID: " + order.getOrderId());
    }

    public double calculateTotalAmount(Order order) {
        double total = 0;
        for (Product product : order.getProducts()) {
            total += product.getPrice();
        }
        order.setTotalAmount(total);
        return total;
    }

    public void addProductToOrder(Order order, Product product) {
        order.getProducts().add(product);
        calculateTotalAmount(order);
        System.out.println("Product added to order. Updated total: " + order.getTotalAmount());
    }

    public void removeProductFromOrder(Order order, Product product) {
        List<Product> products = order.getProducts();
        if (products.contains(product)) {
            products.remove(product);
            calculateTotalAmount(order);
            System.out.println("Product removed from order. Updated total: " + order.getTotalAmount());
        } else {
            System.out.println("Product not found in the order.");
        }
    }

    public static void deleteOrder(Order order) {
        if (Database.orders.remove(order)) {
            System.out.println("Order deleted successfully with ID: " + order.getOrderId());
        } else {
            System.out.println("Failed to delete order. Order not found.");
        }
    }

    public static Order findOrderById(int orderId) {
        for (Order order : Database.orders) {
            if (order != null && order.getOrderId() == orderId) {
                return order;
            }
        }
        System.out.println("Order not found with ID: " + orderId);
        return null;
    }

    public static void displayAllOrders() {
        if (Database.orders.isEmpty()) {
            System.out.println("No orders found.");
            return;
        }
        System.out.println("All Orders:");
        for (Order order : Database.orders) {
            System.out.println(order);
        }
    }

    public static List<Order> findOrdersByCustomerId(int customerId) {
        List<Order> customerOrders = new ArrayList<>();
        for (Order order : Database.orders) {
            if (order != null && order.getCustomerId() == customerId) {
                customerOrders.add(order);
            }
        }
        if (customerOrders.isEmpty()) {
            System.out.println("No orders found for customer ID: " + customerId);
        }
        return customerOrders;
    }

}
