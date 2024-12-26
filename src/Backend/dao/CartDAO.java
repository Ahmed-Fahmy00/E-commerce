package Backend.dao;

import Backend.entity.Cart;
import Backend.entity.Customer;
import Backend.entity.Product;
import Database.Database;

public class CartDAO {
    public Cart createCart(Customer customer) {
        Cart cart = new Cart(customer);
        Database.carts.add(cart);
        return cart;
    }

    public Cart getCartByCustomer(Customer customer){
        for(Cart cart:Database.carts){
            if(cart!=null && cart.getCustomer().equals(customer)){
                return cart;
            }
        }
        return null;
    }
    public Cart getCartById(int id){
        for(Cart cart:Database.carts){
            if(cart!=null && cart.getCartId() ==id){
                return cart;
            }
        }
        return null;
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
    public void clearCart(Cart cart){
        cart.getProducts().clear();
        cart.setCount(new int[0]);
        System.out.println("Cart cleared successfully.");
    }

    public boolean isEmpty(Cart cart) {
        return cart.getProducts().isEmpty();
    }
    public boolean searchProduct(Cart cart, Product product) {
        return cart.getProducts().contains(product);
    }

    public double calculateTotalAmount(Cart cart) {
        double Total = 0;
        for (int i = 0; i < cart.getProducts().size(); i++) {
            Total += cart.getProducts().get(i).getPrice() * cart.getCount()[i];
        }
        cart.setTotalAmount(Total);
        return Total;
    }
}
