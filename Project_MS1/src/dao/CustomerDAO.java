package dao;

import database.Database;
import entity.Customer;


public class CustomerDAO {

    public boolean addCustomer(Customer customer) {
        if (findCustomerByUsername(customer.getUsername()) != null) {
            Database.customers.add(customer);
            System.out.println("Customer added successfully.");
            return true;
        }
        System.out.println("Customer with the given username already exists.");
        return false;
    }

    public Customer findCustomerByUsername(String username) {
        for (int i = 0; i < Database.customers.size(); i++) {
            Customer customer = Database.customers.get(i);
            if (customer != null && customer.getUsername().equals(username)) {
                return customer;
            }
        }
        return null;
    }

    public boolean updateCustomer(String username, Customer updatedCustomer) {
        for (int i = 0; i < Database.customers.size(); i++) {
            Customer existingCustomer = Database.customers.get(i);
            if (existingCustomer != null && existingCustomer.getUsername().equals(username)) {
                Database.customers.set(i, updatedCustomer);
                System.out.println("Customer updated successfully.");
                return true;
            }
        }
        System.out.println("Customer not found.");
        return false;
    }

    public boolean deleteCustomer(String username) {
        for (Customer customer : Database.customers) {
            if (customer != null && customer.getUsername().equals(username)) {
                Database.customers.remove(customer);
                System.out.println("Customer deleted successfully.");
                return true;
            }
        }
        System.out.println("Customer not found.");
        return false;
    }

    public static void displayAllCustomers() {
        if (Database.customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }
        System.out.println("Customers:");
        for (Customer customer : Database.customers) {
            System.out.println(customer);
        }
    }

}