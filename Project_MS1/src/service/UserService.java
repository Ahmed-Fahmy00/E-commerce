package service;

import dao.AdminDAO;
import dao.CustomerDAO;
import entity.Admin;
import entity.Customer;
import main.Main;
import java.util.Scanner;

public class UserService {

    private static final Scanner scanner = new Scanner(System.in);

    public static void login() {
        while (true) {
            System.out.println("--- Login ---");
            System.out.print("Enter username: ");
            String username = scanner.nextLine();

            Admin admin = AdminDAO.findAdminByUsername(username);
            if (admin != null) {
                System.out.print("Enter password: ");
                String password = scanner.nextLine();

                if (admin.getPassword().equals(password)) {
                    System.out.println("Login successful. Welcome, Admin " + admin.getUsername() + "!");
                    AdminService.adminMenu();
                }else {
                    System.out.println("Error: Invalid password. Please try again.");
                    continue;
                }
            }

            Customer customer = CustomerDAO.findCustomerByUsername(username);
            if (customer != null) {
                System.out.print("Enter password: ");
                String password = scanner.nextLine();

                if (customer.getPassword().equals(password)) {
                    System.out.println("Login successful. Welcome, " + customer.getUsername() + "!");
                    CustomerService.customerMenu(customer);
                } else {
                    System.out.println("Error: Invalid password. Please try again.");
                    continue;
                }
            }
            System.out.println("Error: Username does not exist. Please try again.");
        }
    }

    public void logout() {
        System.out.println("You have been logged out successfully.");
        Main.MainMenu();
    }
}


