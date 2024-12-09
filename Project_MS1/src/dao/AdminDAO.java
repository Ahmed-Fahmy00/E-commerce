package dao;

import database.Database;
import entity.Admin;
import entity.Customer;
import static database.Database.customers;

public class AdminDAO {

    public static Admin findAdminByUsername(String username) {
        for (int i = 0; i < Database.admins.size(); i++) {
            Admin admin = Database.admins.get(i);
            if (admin != null && admin.getUsername().equals(username)) {
                return admin;
            }
        }
        return null;
    }

    public boolean createUser(Customer customer) {
        if (getCustomerByUsername(customer.getUsername()) == null) {
            database.Database.add(customers, customer);
            return true;
        }
        return false;
    }

    public boolean deleteUser(String username) {
        Customer customer = getCustomerByUsername(username);
        if (customer != null) {
            database.Database.remove(customers, customer);
            return true;
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

