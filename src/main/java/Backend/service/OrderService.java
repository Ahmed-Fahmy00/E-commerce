package Backend.service;

import Backend.entity.Order;
import Backend.dao.*;
import java.util.ArrayList;
import java.util.List;


public class OrderService {

    static OrderDAO orderDAO = new OrderDAO();

    public boolean createOrder(Order order) {
        if (order == null || order.getOrderId() == 0) {
        System.out.println("Error: Order or order ID cannot be null.");
        return false;
        }
        if (orderDAO.getAll().contains(order)) {
        System.out.println("Order already exists.");
        return false;
        }
        orderDAO.add(order);
        System.out.println("Order added successfully with ID: " + order.getOrderId());
        return true;
    }
    public List<Order> getOrdersByCustomerId(int customerId) {
        if(customerId < 0){
            System.out.println("Error: ID cannot be negative.");
            return null;
        }
        List<Order> orders = orderDAO.getAll();
        List<Order> customerOrders = new ArrayList<>();
        for (Order order : orders) {
            if (order.getCustomer().getId() == customerId) {
                customerOrders.add(order);
            }
        }
        if (customerOrders.isEmpty()) {
            System.out.println("No orders found for customer ID " + customerId);
            return null;
        }
        return customerOrders;
    }

}
