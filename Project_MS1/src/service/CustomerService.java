package service;

import dao.CartDAO;
import dao.CustomerDAO;
import dao.ProductDAO;
import entity.Cart;
import entity.Customer;
import entity.Gender;
import java.util.Scanner;
import service.ProductService;

import static dao.ProductDAO.addProduct;
import static dao.ProductDAO.findProductById;

public class CustomerService {
    static Scanner scanner = new Scanner(System.in);

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
                if (CustomerDAO.findCustomerByUsername(username) != null) {
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

        if (CustomerDAO.addCustomer(customer)) {
            System.out.println("Signup successful! You can now login.");
        } else {
            System.out.println("Signup failed. Database might be full.");
        }
    }

    public static void customerMenu(Customer customer) {
        while (true) {
            System.out.println("\n--- Customer Menu ---");
            System.out.println("1. View Personal Information");
            System.out.println("2. Add Balance");
            System.out.println("3. Update Profile");
            System.out.println("4. View Products");
            System.out.println("5. Add Product to Cart");
            System.out.println("6. View Cart");
            System.out.println("7. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println(customer);
                    break;
                case 2:
                    addBalance(customer);
                    break;
                case 3:
                    updateProfile(customer);
                    break;
                case 4:
                    viewAllProducts();
                    break;
                case 5:
                    System.out.print("Enter product ID to add: ");
                    int productId = scanner.nextInt();
                    Cart cart = new Cart(customer);
                    CartDAO.addProduct(cart, findProductById(productId));
                    break;
                case 6:
                    CartDAO.displayCart(cart);
                    break;
                case 7:
                    System.out.println("You have successfully logged out.");
                    return;
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
                scanner.nextLine(); // Consume newline
                customer.addBalance(amount);
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
    public static void viewAllProducts() {
        ProductDAO.displayAllProducts();
    }


}