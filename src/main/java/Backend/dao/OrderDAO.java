package Backend.dao;

import Backend.entity.Cart;
import Backend.entity.Enum.PaymentMethod;
import Backend.entity.Order;
import Database.Database;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderDAO implements DAO_interface<Order> {

    @Override
    public void add(Order order) {
        Database.orders.add(order);
    }

    @Override
    public void delete(Order order) {
        for (int i = 0; i < Database.orders.size(); i++) {
            if (Database.orders.get(i).getOrderId() == order.getOrderId()) {
                Database.orders.remove(i);
                break; // Exit the loop after removing the order
            }
        }
    }

    @Override
    public void update(Order oldOrder, Order updatedOrder) {
        for (int i = 0; i < Database.orders.size(); i++) {
            Order existingOrder = Database.orders.get(i);
            if (existingOrder.getOrderId() == oldOrder.getOrderId()) {
                Database.orders.set(i, updatedOrder);
            }
        }
    }

    @Override
    public List<Order> getAll() {
        return new ArrayList<>(Database.orders);
    }

}
