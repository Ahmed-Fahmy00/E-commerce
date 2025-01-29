package Backend.dao;

import Backend.entity.Category;
import Backend.entity.Product;
import Database.Database;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements DAO_interface<Product> {

    @Override
    public void add(Product product) {
        Database.products.add(product);
    }

    @Override
    public void delete(Product product) {
        for (int i = 0; i < Database.products.size(); i++) {
            if (Database.products.get(i).getId() == product.getId()) {
                Database.products.remove(i);
                break; // Exit the loop after removing the product
            }
        }
    }
    @Override
    public void update(Product oldProduct, Product updatedProduct) {
        for (int i = 0; i < Database.products.size(); i++) {
            Product existingProduct = Database.products.get(i);
            if (existingProduct.getId() == oldProduct.getId()) {
                Database.products.set(i, updatedProduct);
            }
        }
    }

    @Override
    public List<Product> getAll() {
        return new ArrayList<>(Database.products);
    }

}
