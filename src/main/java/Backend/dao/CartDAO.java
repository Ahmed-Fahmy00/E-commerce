package Backend.dao;

import Backend.entity.*;
import Database.Database;

import java.util.ArrayList;
import java.util.List;

public class CartDAO implements DAO_interface<Cart> {

    @Override
    public void add(Cart cart) {
        Database.carts.add(cart);
    }

    @Override
    public void delete(Cart cart) {
        for (Cart cart1 : Database.carts) {
            if (cart1.getCartId() == cart.getCartId()) {
                Database.carts.remove(cart1);
            }
        }
    }

    @Override
    public void update(Cart oldCart, Cart updatedCart) {
        for (int i = 0; i < Database.carts.size(); i++) {
            Cart existingCart = Database.carts.get(i);
            if (existingCart.getCartId() == oldCart.getCartId()) {
                Database.carts.set(i, updatedCart);
            }
        }

    }

    @Override
    public List<Cart> getAll() {
        return new ArrayList<>(Database.carts);
    }

}
