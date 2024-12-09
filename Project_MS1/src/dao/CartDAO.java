package dao;

import entity.Cart;
import entity.Product;

public class CartDAO {

    public void clearCart(Cart cart) {
        cart.getProducts().clear();
        cart.setCount(new int[20]);
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
            if (cart.getProducts().size() < 20) {
                cart.getProducts().add(product);
                cart.getCount()[cart.getProducts().indexOf(product)] = 1;
            } else {
                System.out.println("Cart is full, Please remove some items to add more.");
            }
        }
    }

    public void removeOneOfProduct(Cart cart, Product product) {
        int index = cart.getProducts().indexOf(product);
        if (index != -1 && cart.getCount()[index] > 1) {
            cart.getCount()[index]--;
        } else {
            cart.getProducts().remove(product);
        }
    }

    public void removeAllProduct(Cart cart, Product product) {
        int index = cart.getProducts().indexOf(product);
        if (index != -1) {
            cart.getCount()[index] = 0;
            cart.getProducts().remove(product);
        }
    }
}
