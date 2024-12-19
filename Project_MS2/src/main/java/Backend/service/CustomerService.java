package Backend.service;

import Backend.dao.CartDAO;
import Backend.dao.CustomerDAO;
import Backend.entity.Cart;
import Backend.entity.Customer;
import Backend.entity.Enum.Gender;
import Backend.service.Main;

import java.util.List;
import java.util.Scanner;

public class CustomerService {
    static Scanner scanner = new Scanner(System.in);

    static CustomerDAO customerDAO = new CustomerDAO();
    static CartDAO cartDAO = new CartDAO();

    public static void signupCustomer() {
        Customer customer = new Customer();
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
                String username = scanner.nextLine();
                if (customerDAO.getCustomerByUsername(username) != null) {
                    System.out.println("Username already exists. Please choose a different username.");
                    continue;
                }
                customer.setUsername(username);
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

        if (customerDAO.createCustomer(customer)) {
            System.out.println("Signup successful! You can now login.");
        } else {
            System.out.println("Signup failed. Database might be full.");
        }
    }

    public static void customerMenu(Customer customer) {
        Cart cart = cartDAO.getCartByCustomer(customer);
        while (true) {
            System.out.println("\n--- Customer Menu ---");
            System.out.println("1. View Personal Information");
            System.out.println("2. Add Balance");
            System.out.println("3. Update Profile");
            System.out.println("4. View Products Menu");
            System.out.println("5. View Cart Menu");
            System.out.println("6. View Orders Menu");
            System.out.println("7. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println(customer.toString());
                    break;
                case 2:
                    addBalance(customer);
                    break;
                case 3:
                    updateProfile(customer);
                    break;
                case 4:
                    ProductService.productmenu(cart);
                    break;
                case 5:
                    CartService.cartMenu(cart);
                    break;
                case 6:
                    OrderService.orderMenu(customer);
                    break;
                case 7:
                    System.out.println("You have successfully logged out.");
                    Main.MainMenu();
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addBalance(Customer customer) {
        while (true) {
            try {
                System.out.print("Enter amount to add: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                double total = customer.getBalance() + amount;
                customer.SetBalance(total);
                System.out.println("Balance updated successfully!");
                return;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void updateProfile(Customer customer) {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter shipping address: ");
        String shippingAddress = scanner.nextLine();

        customer.updateProfile(firstName, lastName, address, phone, shippingAddress);
        System.out.println("Profile updated successfully!");
    }

    public static void displayAllCustomers() {
        List<Customer> customers = customerDAO.getAllCustomers();
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }
        System.out.println("Customers:");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

}