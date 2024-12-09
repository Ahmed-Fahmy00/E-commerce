package dao;

import entity.Customer;

import static database.Database.customers;

public class AdminDAO {
    public boolean createUser(Customer customer) {
        if (getCustomerByUsername(customer.getUsername()) == null) {
            return database.Database.add(customers, customer);
        }
        return false;
    }
    public boolean deleteUser(String username) {
        Customer customer = getCustomerByUsername(username);
        if (customer != null) {
            return database.Database.remove(customers, customer); // Use remove utility
        }
        return false;
    }
    public Customer getCustomerByUsername(String username) {
        for (Customer customer : customers) {
            if (customer != null && customer.getUsername().equals(username)) {
                return customer;
            }
        }
        return null;
    }
}

