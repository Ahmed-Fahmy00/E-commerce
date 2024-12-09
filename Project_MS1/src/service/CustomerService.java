package service;

import entity.Customer;
import entity.Gender;
import java.util.Date;
import java.util.Scanner;
import static database.Database.customers;

public class CustomerService {
    private static Scanner scanner = new Scanner(System.in);
    public static void login() {
        while (true) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();

            Customer customer = findCustomerByUsername(username);
            if (customer == null) {
                System.out.println("Error: Username does not exist. Please try again.");
                continue;
            }

            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            if (!customer.getPassword().equals(password)) {
                System.out.println("Error: Invalid password. Please try again.");
                continue;
            }

            customer.login();
            customerMenu(customer);
            return;
        }
    }
    public static void signupCustomer() {
        Customer customer = new Customer("Temp", "Temp", "Temp", "temp@example.com", Gender.MALE, "Temp123@", "Customer", "Temp", "1234567890", "Temp", new Date());

        while (true) {
            try {
                System.out.print("Enter first name: ");
                customer.setFirstName(scanner.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Enter last name: ");
                customer.setLastname(scanner.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Enter username: ");
                customer.setUsername(scanner.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Enter email: ");
                customer.setEmail(scanner.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Enter password: ");
                customer.setPassword(scanner.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Enter gender (MALE/FEMALE): ");
                customer.setGender(Gender.valueOf(scanner.nextLine().toUpperCase()));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: Please enter a valid gender (MALE or FEMALE).");
            }
        }

        while (true) {
            try {
                System.out.print("Enter address: ");
                customer.setAddress(scanner.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Enter phone number: ");
                customer.setPhone(scanner.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.print("Enter shipping address: ");
        customer.setShippingAddress(scanner.nextLine());

        while (true) {
            try {
                System.out.print("Enter date of birth (yyyy-mm-dd): ");
                customer.setDateOfBirth(java.sql.Date.valueOf(scanner.nextLine()));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: Please enter a valid date in the format yyyy-mm-dd.");
            }
        }

        for (int i = 0; i < customers.length; i++) {
            if (customers[i] == null) {
                customers[i] = customer;
                System.out.println("Signup successful! You can now login.");
                return;
            }
        }

        System.out.println("Customer list is full. Signup failed.");
    }
    public static void customerMenu(Customer customer) {
        while (true) {
            System.out.println("Customer Options:");
            System.out.println("1. View Personal Information");
            System.out.println("2. Add Balance");
            System.out.println("3. Update Profile");
            System.out.println("4. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.println(customer);
                    break;
                case 2:
                    while (true) {
                        try {
                            System.out.print("Enter amount to add: ");
                            double amount = scanner.nextDouble();
                            scanner.nextLine(); // Consume the newline character
                            customer.addBalance(amount);
                            System.out.println("Balance updated!");
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter first name: ");
                    String firstname = scanner.nextLine();
                    System.out.print("Enter last name: ");
                    String lastname = scanner.nextLine();
                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter phone: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter shipping address: ");
                    String shippingAddress = scanner.nextLine();
                    customer.updateProfile(firstname, lastname, address, phone, shippingAddress);
                    System.out.println("Profile updated!");
                    break;
                case 4:
                    customer.logout();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

}