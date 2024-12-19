package Backend.dao;

import Backend.entity.Cart;
import Backend.entity.Enum.PaymentMethod;
import Backend.entity.Order;
import Database.Database;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderDAO {
    static Scanner scanner = new Scanner(System.in);

    public void createOrder(Cart cart) {
        Order order=new Order(cart.getCustomer(), cart.getProducts(),askForPaymentMethod(),cart.getTotalAmount());
        Database.orders.add(order);
        System.out.println("Order created successfully with ID: " + order.getOrderId());
    }

    public Order getOrderById(int orderId) {
        for (Order order : Database.orders) {
            if (order != null && order.getOrderId() == orderId) {
                return order;
            }
        }
        System.out.println("Order not found with ID: " + orderId);
        return null;
    }
    public List<Order> getOrdersByCustomerId(int customerId) {
        List<Order> customerOrders = new ArrayList<>();
        for (Order order : Database.orders) {
            if (order != null && order.getCustomer().getId() == customerId) {
                customerOrders.add(order);
            }
        }
        if (customerOrders.isEmpty()) {
            System.out.println("No orders found for customer ID: " + customerId);
        }
        return customerOrders;
    }
    public List<Order> getAllOrders() {
        return new ArrayList<>(Database.orders);
    }

    public void deleteOrder(Order order) {
        if (Database.orders.remove(order)) {
            System.out.println("Order deleted successfully with ID: " + order.getOrderId());
        } else {
            System.out.println("Failed to delete order. Order not found.");
        }
    }
    public void deleteOrdersByCustomerId(int customerId) {
        List<Order> customerOrders = getOrdersByCustomerId(customerId);
        for (Order order : customerOrders) {
            deleteOrder(order);
        }
        System.out.println("All orders for customer ID " + customerId + " have been deleted.");
    }

     public PaymentMethod askForPaymentMethod() {
         System.out.println();
         PaymentMethod paymentMethod = null;
        while (paymentMethod == null) {
            System.out.println("Choose a payment method: ");
            for (PaymentMethod method : PaymentMethod.values()) {
                System.out.println(method.ordinal() + 1 + ". " + method);
            }
            int choice = scanner.nextInt();
            if (choice > 0 && choice <= PaymentMethod.values().length) {
                paymentMethod = PaymentMethod.values()[choice - 1];
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        return paymentMethod;
    }


}
