package Backend.service;

import Backend.dao.CartDAO;
import Backend.dao.OrderDAO;
import Backend.dao.ProductDAO;
import Backend.entity.Cart;
import Backend.entity.Product;

import java.util.Scanner;

public class CartService {
    static Scanner scanner = new Scanner(System.in);

    static CartDAO cartDAO = new CartDAO();
    static ProductDAO productDAO = new ProductDAO();
    static OrderDAO orderDAO = new OrderDAO();

    public static void cartMenu(Cart cart) {

        while (true) {
            displayCart(cart);
            System.out.println("\n--- Cart Menu ---");
            System.out.println("1. Remove One of Products");
            System.out.println("2. Remove All Products");
            System.out.println("3. Clear Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit to Main Menu");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter product ID to remove one: ");
                    int productIdToRemoveOne = scanner.nextInt();
                    scanner.nextLine();
                    Product productToRemoveOne = productDAO.getProductById(productIdToRemoveOne);
                    if (productToRemoveOne != null) {
                        cartDAO.removeOneOfProduct(cart, productToRemoveOne);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 2:
                    System.out.print("Enter product ID to remove all: ");
                    int productIdToRemoveAll = scanner.nextInt();
                    scanner.nextLine();
                    Product productToRemoveAll = productDAO.getProductById(productIdToRemoveAll);
                    if (productToRemoveAll != null) {
                        cartDAO.removeAllProduct(cart, productToRemoveAll);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 3:
                    cartDAO.clearCart(cart);
                    break;
                case 4:
                    orderDAO.createOrder(cart);
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
        System.out.println("\n--- Cart ---");
        System.out.printf("Cart ID: %d%n", cart.getCartId());
        System.out.printf("Customer: %s %s%n",
                cart.getCustomer().getFirstnameName(),
                cart.getCustomer().getLastnameName());
        System.out.println("Products in Cart:");

        if (cart.getProducts().isEmpty()) {
            System.out.println("  No products in the cart.");
        } else {
            for (int i = 0; i < cart.getProducts().size(); i++) {
                System.out.printf("  - %s (Quantity: %d)%n",
                        cart.getProducts().get(i).getName(),
                        cart.getCount()[i]);
            }
        }
        System.out.printf("Total: $%.2f%n", cartDAO.calculateTotalAmount(cart));
        System.out.println();
    }


}
