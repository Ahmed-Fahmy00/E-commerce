package service;

import entity.Order;
import entity.Product;

public class OrderService {
    public void displayOrderDetails(Order order) {
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Customer: " + order.getCustomer().getFirstnameName() + " " + order.getCustomer().getLastnameName());
        System.out.println("Payment Method: " + order.getPaymentMethod());
        System.out.println("Products in Order:");
        for (Product product : order.getProducts()) {
            System.out.println(product.getName() + " - " + product.getPrice());
        }
        System.out.println("Total Amount: " + order.getTotalAmount());
    }

}
