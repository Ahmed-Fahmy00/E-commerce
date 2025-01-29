package Backend.service;

import Backend.entity.Customer;
import Backend.dao.*;
import java.util.List;

public class CustomerService {

    static CustomerDAO customerDAO = new CustomerDAO();
    static CartService cartService = new CartService();

    public boolean createCustomer(Customer customer) {
        if(customer == null || customer.getUsername() == null) {
            System.out.println("Error: Customer or username cannot be null.");
            return false;
        }
        if (customerDAO.getAll().contains(customer)) {
            System.out.println("Customer already exists.");
            return false;
        }
        cartService.createCart(customer);
        customerDAO.add(customer);
        System.out.println("Customer added successfully with ID: " + customer.getId());
        return true;
    }
    public boolean updateCustomer(Customer customer , Customer updatedCustomer) {
        if(customer == null || customer.getUsername() == null) {
            System.out.println("Error: Customer or username cannot be null.");
            return false;
        }
        if (!customerDAO.getAll().contains(customer)) {
            System.out.println("Customer not found.");
            return false;
        }
        customerDAO.update(customer,updatedCustomer);
        System.out.println("Customer updated successfully with ID: " + customer.getId());
        return true;
    }
    public boolean deleteCustomer(Customer customer) {
        if(customer == null || customer.getUsername() == null) {
            System.out.println("Error: Customer or username cannot be null.");
            return false;
        }
        if (!customerDAO.getAll().contains(customer)) {
            System.out.println("Customer not found.");
            return false;
        }
        customerDAO.delete(customer);
        System.out.println("Customer deleted successfully with ID: " + customer.getId());
        return true;
    }

    public Customer getCustomerByUsername(String username) {
        if (username == null) {
            System.out.println("Error: Username cannot be null.");
            return null;
        }
        List<Customer> customers = customerDAO.getAll();
        for (Customer customer : customers) {
            if (customer != null && customer.getUsername().equals(username)) {
                return customer;
            }
        }
        System.out.println("Customer not found with username: " + username);
        return null;
    }
    public Customer getCustomerById(int Id) {
        if (Id == 0) {
            System.out.println("Error: Username cannot be null.");
            return null;
        }
        List<Customer> customers = customerDAO.getAll();
        for (Customer customer : customers) {
            if (customer != null && customer.getId()==Id ) {
                return customer;
            }
        }
        System.out.println("Customer not found with ID: " + Id);
        return null;
    }

    public void addBalance(Customer customer, double amount) {
        if (customer == null) {
            System.out.println("Error: Customer cannot be null.");
            return;
        }
        if (amount <= 0) {
            System.out.println("Error: Amount must be greater than 0.");
            return;
        }
        customer.setBalance((customer.getBalance() + amount));
        System.out.println("Balance added successfully. New balance: " + customer.getBalance());
    }
}