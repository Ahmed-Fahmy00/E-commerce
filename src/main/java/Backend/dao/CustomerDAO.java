package Backend.dao;

import Backend.entity.Customer;
import Database.Database;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomerDAO implements DAO_interface<Customer> {

    @Override
    public void add(Customer customer) {
        Database.customers.add(customer);
    }

    @Override
    public void delete(Customer customer) {
        for (int i = 0; i < Database.customers.size(); i++) {
            if (Database.customers.get(i).getId() == customer.getId()) {
                Database.customers.remove(i);
                break;
            }
        }
    }

    @Override
    public void update(Customer oldCustomer, Customer updatedCustomer) {
        for (int i = 0; i < Database.customers.size(); i++) {
            Customer existingCustomer = Database.customers.get(i);
            if (existingCustomer.getId() == oldCustomer.getId()) {
                Database.customers.set(i, updatedCustomer);
            }
        }
    }

    @Override
    public List<Customer> getAll() {
        return new ArrayList<>(Database.customers);
    }

}
