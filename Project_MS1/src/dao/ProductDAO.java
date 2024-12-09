package dao;

import entity.Product;
import database.Database;

public class ProductDAO {

    public static void addProduct(Product product) {
        if (findProductById(product.getProductId()) == null) {
            Database.products.add(product);
            System.out.println("Product added successfully: " + product);
        } else {
            System.out.println("Product with ID " + product.getProductId() + " already exists.");
        }
    }

    public void updateProduct(int id, String newName, double newPrice, String newCategory) {
        for (Product product : Database.products) {
            if (product != null && product.getProductId() == id) {
                product.setName(newName);
                product.setPrice(newPrice);
                product.setCategory(newCategory);
                System.out.println("Product updated successfully: " + product);
                return;
            }
        }
        System.out.println("Product not found with ID: " + id);
    }

    public static void deleteProduct(int id) {
        for (int i = 0; i < Database.products.size(); i++) {
            Product product = Database.products.get(i);
            if (product != null && product.getProductId() == id) {
                Database.products.remove(i);
                System.out.println("Product deleted successfully with ID: " + id);
                return;
            }
        }
        System.out.println("Product not found with ID: " + id);
    }

    public static Product findProductById(int id) {
        for (Product product : Database.products) {
            if (product.getProductId() == id) {
                return product; // Product found
            }
        }
        return null; // Product not found
    }

    public static void findProductsByCategory(String categoryName) {
        boolean found = false;
        System.out.println("Products in category: " + categoryName);
        for (Product product : Database.products) {
            if (product != null && product.getCategory().equalsIgnoreCase(categoryName)) {
                System.out.println(product);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No products found in this category.");
        }
    }

    public static void displayAllProducts() {
        if (Database.products.isEmpty()) {
            System.out.println("No products found in the database.");
            return;
        }
        System.out.println("All Products:");
        for (Product product : Database.products) {
            System.out.println(product);
        }
    }
}
