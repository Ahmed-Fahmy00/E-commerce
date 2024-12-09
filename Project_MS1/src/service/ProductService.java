package service;

import dao.ProductDAO;

public class ProductService {

    public static void productmenu(){
        while (true) {
            System.out.println("Product Menu");
            System.out.println("1. Add Product to cart");
            System.out.println("2. Exit Product Menu");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addNewProduct();
                    break;
                case 4:

                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }




}
