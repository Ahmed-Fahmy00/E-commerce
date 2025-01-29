package tests;

import Backend.dao.*;
import Backend.entity.*;
import Backend.service.*;
import Backend.entity.Enum.Gender;
import java.util.Date;

public class Customertestdata {
    static CustomerService customerService = new CustomerService();

    public static void makeCustomers() { 

        Customer customer5 = new Customer("John", "Doe", "douban12", "john@example.com", Gender.MALE, "securepass1", "123 Main St", "555-1234", "123 Main St", new Date());
        customerService.createCustomer(customer5);
        customer5.setBalance(300.50);
        Customer customer6 = new Customer("Jane", "Smith", "janesmith", "jane@example.com", Gender.FEMALE, "password456", "456 Elm St", "555-5678", "456 Elm St", new Date());
        customerService.createCustomer(customer6);
        customer6.setBalance(300.50);
        Customer customer7 = new Customer("Alice", "Johnson", "alicejohnson", "alice@example.com", Gender.FEMALE, "password789", "789 Oak St", "555-7890", "789 Oak St", new Date());
        customerService.createCustomer(customer7);
        customer7.setBalance(300.50);
        Customer customer8 = new Customer("Bob", "Brown", "bobbrown", "bob@example.com", Gender.MALE, "password101", "101 Pine St", "555-1011", "101 Pine St", new Date());
        customerService.createCustomer(customer8);
        customer8.setBalance(300.50);
        Customer customer9 = new Customer("Charlie", "Davis", "charliedavis", "charlie@example.com", Gender.MALE, "password102", "102 Maple St", "555-1022", "102 Maple St", new Date());
        customerService.createCustomer(customer9);
        customer9.setBalance(300.50);
        Customer customer10 = new Customer("Diana", "Evans", "dianaevans", "diana@example.com", Gender.FEMALE, "password103", "103 Cedar St", "555-1033", "103 Cedar St", new Date());
        customerService.createCustomer(customer10);
        customer10.setBalance(300.50);
        Customer customer11 = new Customer("Eve", "Foster", "evefoster", "eve@example.com", Gender.FEMALE, "password104", "104 Birch St", "555-1044", "104 Birch St", new Date());
        customerService.createCustomer(customer11);
        customer11.setBalance(300.50);
        Customer customer12 = new Customer("Frank", "Green", "frankgreen", "frank@example.com", Gender.MALE, "password105", "105 Spruce St", "555-1055", "105 Spruce St", new Date());
        customerService.createCustomer(customer12);
        customer12.setBalance(300.50);
        Customer customer13 = new Customer("Grace", "Harris", "graceharris", "grace@example.com", Gender.FEMALE, "password106", "106 Willow St", "555-1066", "106 Willow St", new Date());
        customerService.createCustomer(customer13);
        customer13.setBalance(300.50);
        Customer customer14 = new Customer("Hank", "Ivy", "hankivy", "hank@example.com", Gender.MALE, "password107", "107 Ash St", "555-1077", "107 Ash St", new Date());
        customerService.createCustomer(customer14);
        customer14.setBalance(300.50);
    }
}
