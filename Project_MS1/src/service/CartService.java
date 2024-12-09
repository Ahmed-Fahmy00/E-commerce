package service;

import entity.Cart;

public class CartService {
    public void displayCart(Cart cart) {
        System.out.println("Cart ID: " + cart.getCartId());
        System.out.println("Customer: " + cart.getCustomer().getFirstnameName() + " " + cart.getCustomer().getLastnameName());
        System.out.println("Products in cart:");
        for (int i = 0; i < cart.getProducts().size(); i++) {
            System.out.println(cart.getProducts().get(i).getName() + " - " + cart.getCount()[i]);
        }
        System.out.println("Total: " + calculateTotal(cart));
    }
    public double calculateTotal(Cart cart) {
        double total = 0;
        for (int i = 0; i < cart.getProducts().size(); i++) {
            total += cart.getProducts().get(i).getPrice() * cart.getCount()[i];
        }
        return total;
    }
}
