package Backend.dao;

import Backend.entity.Customer;
import Database.Database;
import java.util.List;


public class CustomerDAO {
    CartDAO cartDAO = new CartDAO();

    public boolean createCustomer (Customer customer) {
        if (customer == null || customer.getUsername() == null) {
            System.out.println("Error: Customer or username cannot be null.");
            return false;
        }
        if (getCustomerByUsername(customer.getUsername()) == null) {
            cartDAO.createCart(customer);
            Database.customers.add(customer);
            return true;
        }
        System.out.println("Customer with the given username already exists.");
        return false;
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

    public Customer getCustomerByUsername(String username) {
        for (int i = 0; i < Database.customers.size(); i++) {
            Customer customer = Database.customers.get(i);
            if (customer != null && customer.getUsername().equals(username)) {
                return customer;
            }
        }
        return null;
    }

    public List<Customer> getAllCustomers() {
        return Database.customers;
    }

}
