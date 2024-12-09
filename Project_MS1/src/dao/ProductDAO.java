package dao;

import entity.Product;
import database.Database;

public class ProductDAO {
    public void addProduct(int productId, String name, double price, String categoryName) {
        Product newProduct = new Product(productId, name, price, categoryName);
        Database.products.add(newProduct);
        System.out.println("Product added successfully: " + newProduct);
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

    public void deleteProduct(int id) {
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
    public Product findProductById(int id) {
        for (Product product : Database.products) {
            if (product != null && product.getProductId() == id) {
                return product;
            }
        }
        System.out.println("Product not found with ID: " + id);
        return null;
    }

    public void findProductsByCategory(String categoryName) {
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