package service;

import dao.*;

public class AdminService {

    public void viewAllEntities() {
        CustomerDAO .displayAllCustomers();
        ProductDAO.displayAllProducts();
        OrderDAO.displayAllOrders();
    }

    public void viewAllCustomers() {
        CustomerDAO.displayAllCustomers();
    }

    public void viewAllProducts() {
        ProductDAO.displayAllProducts();
    }

    public void viewAllOrders() {
        OrderDAO.displayAllOrders();
    }
}
