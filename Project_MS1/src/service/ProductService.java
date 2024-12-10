package service;

import dao.ProductDAO;
import entity.Customer;

import java.util.Scanner;

public class ProductService {
    private static final Scanner scanner = new Scanner(System.in);
    public static void productmenu(Customer customer){
        while (true) {
            System.out.println("Product Menu");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();


        }
    }

}
