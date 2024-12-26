package Backend.service;

import Backend.dao.*;
import Backend.entity.*;

import java.util.List;
import java.util.Scanner;

public class ProductService {
    private static final Scanner scanner = new Scanner(System.in);

    static ProductDAO productDAO = new ProductDAO();
    static CartDAO cartDAO = new CartDAO();

    public static void productmenu(Cart cart) {
        while (true) {
            displayAllProducts();
            System.out.println("-------- Product Menu --------");
            System.out.println("1. Add product to the cart");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter product ID to be added: ");
                    int index = scanner.nextInt();
                    scanner.nextLine();
                    Product product = productDAO.findProductByindex(index);
                    if (product != null) {
                        cartDAO.addProduct(cart, product);
                        System.out.println("Product added to cart: " + product.getName());
                    }
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public static void displayAllProducts() {
        List<Product> products = productDAO.getAllProducts();
        if (products.isEmpty()) {
            System.out.println("No products found in the database.");
            return;
        }
        System.out.println();
        System.out.println("All Products:");
        for (Product product : products) {
            if (product != null) {
                System.out.printf("ID: %d, Name: %s, Price: $%.2f, Category: %s, Brand: %s, Rate: %.1f%n",
                        product.getProductId(),
                        product.getName(),
                        product.getPrice(),
                        product.getCategory(),
                        product.getBrand() != null ? product.getBrand().toString() : "N/A", // Assuming `Brand` has a meaningful `toString` method
                        product.getRate());
            }
        }
        System.out.println();
    }
}