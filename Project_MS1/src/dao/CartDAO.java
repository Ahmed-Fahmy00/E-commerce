package dao;

import database.Database;
import entity.Cart;
import entity.Product;

public class CartDAO {

    public void clearCart(Cart cart) {
        cart.getProducts().clear();
        cart.setCount(new int[Database.products.size()]);
        System.out.println("Cart cleared successfully.");
    }

    public boolean isEmpty(Cart cart) {
        return cart.getProducts().isEmpty();
    }

    public boolean searchProduct(Cart cart, Product product) {
        return cart.getProducts().contains(product);
    }

    public void addProduct(Cart cart, Product product) {
        if (cart.getProducts().contains(product)) {
            int index = cart.getProducts().indexOf(product);
            cart.getCount()[index]++;
        } else {
            cart.getProducts().add(product);
            int index = cart.getProducts().indexOf(product);
            if (cart.getCount().length < cart.getProducts().size()) {
                // Resize count array if needed
                int[] newCount = new int[cart.getProducts().size()];
                System.arraycopy(cart.getCount(), 0, newCount, 0, cart.getCount().length);
                cart.setCount(newCount);
            }
            cart.getCount()[index] = 1;
        }
        System.out.println("Product added to the cart.");
    }

    public void removeOneOfProduct(Cart cart, Product product) {
        int index = cart.getProducts().indexOf(product);
        if (index != -1 && cart.getCount()[index] > 1) {
            cart.getCount()[index]--;
            System.out.println("Reduced quantity of product in the cart.");
        } else if (index != -1) {
            cart.getProducts().remove(index);
            System.out.println("Product removed from the cart.");
        } else {
            System.out.println("Product not found in the cart.");
        }
    }

    public void removeAllProduct(Cart cart, Product product) {
        int index = cart.getProducts().indexOf(product);
        if (index != -1) {
            cart.getProducts().remove(index);
            System.out.println("All instances of the product removed from the cart.");
        } else {
            System.out.println("Product not found in the cart.");
        }
    }
}
