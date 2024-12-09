package service;

import static database.Database.customers;
import static database.Database.orders;
import static database.Database.products;

public class AdminService {

    public void viewAllEntities() {
        System.out.println("Customers:");
        for (int i = 0; i < customers.length; i++) {
            System.out.println(customers[i]);
        }

        System.out.println("\nProducts:");
        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i]);
        }

        System.out.println("\nOrders:");
        for (int i = 0; i < orders.length; i++) {
            System.out.println(orders[i]);
        }
    }

    public void viewAllCustomers() {
        System.out.println("Customers:");
        for (int i = 0; i < customers.length; i++) {
            System.out.println(customers[i]);
        }
    }

    public void viewAllProducts() {
        System.out.println("\nProducts:");
        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i]);
        }
    }

    public void viewAllOrders() {
        System.out.println("\nOrders:");
        for (int i = 0; i < orders.length; i++) {
            System.out.println(orders[i]);
        }
    }
}
