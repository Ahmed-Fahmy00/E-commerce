package Backend.service;

import Backend.dao.*;
import Backend.entity.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    static ProductDAO productDAO = new ProductDAO();

    public boolean createProduct(Product product) {
        if (product == null || product.getName() == null) {
        System.out.println("Error: Product or name cannot be null.");
        return false;
        }
        if (productDAO.getAll().contains(product)) {
        System.out.println("Product already exists.");
        return false;
        }
        productDAO.add(product);
        System.out.println("Product added successfully with ID: " + product.getId());
        return true;
    }

    public Product getProductById(int id) {
        if (id < 0) {
            System.out.println("Error: ID cannot be negative.");
            return null;
        }
        List<Product> products = productDAO.getAll();
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        System.out.println("Product not found.");
        return null;
    }

    public List<Product> getwantedproducts(String search, List<String> category, List<String> brand, double[] prices) {
        List<Product> products = productDAO.getAll();
        List<Product> result = new ArrayList<>();

        for (Product product : products) {
            if (search != null && !search.trim().isEmpty() &&
                    !product.getName().toLowerCase().contains(search.trim().toLowerCase())) {
                continue;
            }
            boolean matchesCategory = (category == null || category.isEmpty());
            if (!matchesCategory && category != null) {
                for (String cat : category) {
                    if (product.getCategory().getName().equals(cat)) {
                        matchesCategory = true;
                        break;
                    }
                }
            }
            boolean matchesBrand = (brand == null || brand.isEmpty());
            if (!matchesBrand && brand != null) {
                for (String br : brand) {
                    if (product.getBrand().toString().equalsIgnoreCase(br)) {
                        matchesBrand = true;
                        break;
                    }
                }
            }
            boolean matchesPrice = (prices != null && prices.length == 2 && product.getPrice() >= prices[0] && product.getPrice() <= prices[1]);
            if (matchesCategory && matchesBrand && matchesPrice) {
                result.add(product);
            }
        }
        return (result.isEmpty() && search== null) ? products : result;
    }

}