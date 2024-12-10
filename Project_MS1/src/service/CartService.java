package service;

import dao.CartDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import entity.Cart;
import entity.Product;
import java.util.Scanner;

public class CartService {
    static Scanner scanner = new Scanner(System.in);
    public static void cartMenu(Cart cart) {

        while (true) {
            displayCart(cart);
            System.out.println("\n--- Total amount --- " + CartDAO.calculateTotalAmount(cart));
            System.out.println("\n--- Cart Menu ---");
            System.out.println("1. Remove One of Product");
            System.out.println("2. Remove All of Product");
            System.out.println("3. Clear Cart");
            System.out.println("4. make order");
            System.out.println("5. Exit to Main Menu");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter product ID to remove one: ");
                    int productIdToRemoveOne = scanner.nextInt();
                    scanner.nextLine();
                    Product productToRemoveOne = ProductDAO.findProductById(productIdToRemoveOne);
                    if (productToRemoveOne != null) {
                        CartDAO.removeOneOfProduct(cart, productToRemoveOne);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 2:
                    System.out.print("Enter product ID to remove all: ");
                    int productIdToRemoveAll = scanner.nextInt();
                    scanner.nextLine();
                    Product productToRemoveAll = ProductDAO.findProductById(productIdToRemoveAll);
                    if (productToRemoveAll != null) {
                        CartDAO.removeAllProduct(cart, productToRemoveAll);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 3:
                    CartDAO.clearCart(cart);
                    break;
                case 4:
                    OrderDAO.createOrder(cart);
                    break;
                case 5:
                    System.out.println("Exiting to main menu.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    public static void displayCart(Cart cart) {
        System.out.println("Cart ID: " + cart.getCartId());
        System.out.println("Customer: " + cart.getCustomer().getFirstnameName() + " " + cart.getCustomer().getLastnameName());
        System.out.println("Products in cart:");
        for (int i = 0; i < cart.getProducts().size(); i++) {
            System.out.println(cart.getProducts().get(i).getName() + " - " + cart.getCount()[i]);
        }
        System.out.println("Total: " + calculateTotal(cart));
    }

    public static double calculateTotal(Cart cart) {
        double total = 0;
        for (int i = 0; i < cart.getProducts().size(); i++) {
            total += cart.getProducts().get(i).getPrice() * cart.getCount()[i];
        }
        return total;
    }

}
