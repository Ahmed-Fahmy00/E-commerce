package codes.oldCODES.service;

import dao.CartDAO;
import dao.ProductDAO;
import entity.Cart;
import entity.Product;
import java.util.Scanner;

public class ProductService {
    private static final Scanner scanner = new Scanner(System.in);

    public static void productmenu(Cart cart) {
        while (true) {
            ProductDAO.displayAllProducts();
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
                    Product product = ProductDAO.findProductByindex(index);
                    if (product != null) {
                        CartDAO.addProduct(cart, product);
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

}