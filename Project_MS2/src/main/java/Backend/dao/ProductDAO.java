package Backend.dao;

import Backend.entity.Product;
import Database.Database;

import java.util.List;

public class ProductDAO {
    public void addProduct(Product product) {
        if (getProductById(product.getProductId()) == null) {
            Database.products.add(product);
        } else {
            System.out.println("Product with ID " + product.getProductId() + " already exists.");
        }
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

    public Product getProductByindex(int index) {
        if (index > 0 && index <= Database.products.size()) {
            return Database.products.get(index - 1);
        }
        System.out.println("Product not found at index: " + index);
        return null;
    }
    public Product getProductById(int id) {
        for (Product product : Database.products) {
            if (product.getProductId() == id) {
                return product;
            }
        }
        return null;
    }

    public void getProductsByCategory(String categoryName) {
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
    public List<Product> getAllProducts() {
        return Database.products;
    }

}
