package dao;

import database.Database;
import entity.Order;
import entity.Product;
import java.util.List;
import static database.Database.orders;

public class OrderDAO {

    public void createOrder(Order order) {
        if (Database.add(orders, order)) {
            System.out.println("Order created successfully with ID: " + order.getOrderId());
        } else {
            System.out.println("Failed to create order. Database might be full.");
        }
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
        List<Product> products = order.getProducts();
        products.add(product);
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

    public void deleteOrder(Order order) {
        if (Database.remove(orders, order)) {
            System.out.println("Order deleted successfully with ID: " + order.getOrderId());
        } else {
            System.out.println("Failed to delete order. Order not found.");
        }
    }

    public Order findOrderById(int orderId) {
        for (Order order : orders) {
            if (order != null && order.getOrderId() == orderId) {
                return order;
            }
        }
        System.out.println("Order not found with ID: " + orderId);
        return null;
    }
}
