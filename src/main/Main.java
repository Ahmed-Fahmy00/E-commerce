package main;

import Backend.service.*;
import test.TestCases;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        TestCases.te();
        MainMenu();
    }
    public static void MainMenu() {
        while (true) {
            System.out.println("E-commerce shopping Menu:");
            System.out.println("1. Login");
            System.out.println("2. Signup");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    UserService.login();
                    break;
                case 2:
                    CustomerService.signupCustomer();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
