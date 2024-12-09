package dao;

import entity.Product;
import database.Database;
import static database.Database.products;

public class ProductDAO {
    public void addProduct(int productId, String name, double price, String categoryName) {
        if (Database.add(products, new Product(productId, name, price, categoryName))) {
            System.out.println("Product added successfully.");
        } else {
            System.out.println("Failed to add product. Database might be full.");
        }
    }

    public void updateProduct(int id, String newName, double newPrice, String newCategory) {
        for (Product product : products) {
            if (product != null && product.getProductId() == id) {
                product.setName(newName);
                product.setPrice(newPrice);
                product.setCategory(newCategory);
                System.out.println("Product updated successfully.");
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public void deleteProduct(int id) {
        for (Product product : products) {
            if (product != null && product.getProductId() == id) {
                if (Database.remove(products, product)) {
                    System.out.println("Product deleted successfully.");
                } else {
                    System.out.println("Failed to delete product.");
                }
                return;
            }
        }
        System.out.println("Product not found.");
    }
}
