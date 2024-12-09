package dao;

import database.Database;
import entity.Customer;
import static database.Database.customers;

public class CustomerDAO {
    public boolean addCustomer(Customer customer) {
        if (findCustomerByUsername(customer.getUsername()) != null) {
            if (Database.add(Database.customers, customer)) {
                return true;
            }
        }
        return false;
    }
    private static Customer findCustomerByUsername(String username) {
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] != null && customers[i].getUsername().equals(username)) {
                return customers[i];
            }
        }
        return null;
    }
}
