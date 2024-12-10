package service;

import dao.CartDAO;
import dao.ProductDAO;
import entity.Cart;
import entity.Product;

import java.util.Scanner;

public class CartService {

public void cartMenu(Cart cart) {
        Scanner scanner = new Scanner(System.in);
        CartDAO cartDAO = new CartDAO();

        while (true) {
            displayCart(cart);
            System.out.println("\n--- Total amount  ---" + CartDAO.calculateTotalAmount(cart));
            System.out.println("\n--- Cart Menu ---");
            System.out.println("1. Add Product");
            System.out.println("2. Remove One of Product");
            System.out.println("3. Remove All of Product");
            System.out.println("4. Clear Cart");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter product ID to add: ");
                    int productIdToAdd = scanner.nextInt();
                    scanner.nextLine();
                    Product productToAdd = ProductDAO.findProductById(productIdToAdd);
                    if (productToAdd != null) {
                        cartDAO.addProduct(cart, productToAdd);
                    } else {
                        System.out.println("Product not found.");
                    }
                    continue;
                case 2:
                    System.out.print("Enter product ID to remove one: ");
                    int productIdToRemoveOne = scanner.nextInt();
                    scanner.nextLine();
                    Product productToRemoveOne = ProductDAO.findProductById(productIdToRemoveOne);
                    if (productToRemoveOne != null) {
                        cartDAO.removeOneOfProduct(cart, productToRemoveOne);
                    } else {
                        System.out.println("Product not found.");
                    }
                    continue;
                case 3:
                    System.out.print("Enter product ID to remove all: ");
                    int productIdToRemoveAll = scanner.nextInt();
                    scanner.nextLine();
                    Product productToRemoveAll = ProductDAO.findProductById(productIdToRemoveAll);
                    if (productToRemoveAll != null) {
                        cartDAO.removeAllProduct(cart, productToRemoveAll);
                    } else {
                        System.out.println("Product not found.");
                    }
                    continue;
                case 4:
                    cartDAO.clearCart(cart);
                    continue;
                case 5:
                    System.out.println("Exiting cart menu.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        }
    }

    public void displayCart(Cart cart) {
        System.out.println("Cart ID: " + cart.getCartId());
        System.out.println("Customer: " + cart.getCustomer().getFirstnameName() + " " + cart.getCustomer().getLastnameName());
        System.out.println("Products in cart:");
        for (int i = 0; i < cart.getProducts().size(); i++) {
            System.out.println(cart.getProducts().get(i).getName() + " - " + cart.getCount()[i]);
        }
        System.out.println("Total: " + calculateTotal(cart));
    }

    public double calculateTotal(Cart cart) {
        double total = 0;
        for (int i = 0; i < cart.getProducts().size(); i++) {
            total += cart.getProducts().get(i).getPrice() * cart.getCount()[i];
        }
        return total;
    }

}
