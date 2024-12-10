package dao;

import database.Database;
import entity.Cart;
import entity.Customer;
import entity.Product;

public class CartDAO {

    public static Cart createCart(Customer customer) {
        Cart cart = new Cart(customer);
        Database.carts.add(cart);
        return cart;
    }

    public static void displayCart(Cart cart) {
        if (cart.getProducts() == null || cart.getProducts().isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        if (cart.getCount() == null || cart.getProducts().size() != cart.getCount().length) {
            System.out.println("Cart data is inconsistent. Please check the cart structure.");
            return;
        }

        System.out.println("Products in Cart:");
        double total = 0;

        for (int i = 0; i < cart.getProducts().size(); i++) {
            Product product = cart.getProducts().get(i);
            int quantity = cart.getCount()[i];

            System.out.printf("%s - $%.2f x %d = $%.2f%n",
                    product.getName(), product.getPrice(), quantity, product.getPrice() * quantity);

            total += product.getPrice() * quantity;
        }

        System.out.printf("Total: $%.2f%n", total);
    }

    public static Cart findCartByCustomer(Customer customer) {
        for (Cart cart : Database.carts) {
            if (cart != null && (cart.getCustomer()).equals(customer) ) {
                return cart;
            }
        }
        return null;
    }

    public boolean isEmpty(Cart cart) {
        return cart.getProducts().isEmpty();
    }

    public static void clearCart(Cart cart) {
        cart.getProducts().clear();
        cart.setCount(new int[Database.products.size()]);
        System.out.println("Cart cleared successfully.");
    }

    public boolean searchProduct(Cart cart, Product product) {
        return cart.getProducts().contains(product);
    }

    public static void addProduct(Cart cart, Product product) {
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

    public static void removeOneOfProduct(Cart cart, Product product) {
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

    public static void removeAllProduct(Cart cart, Product product) {
        int index = cart.getProducts().indexOf(product);
        if (index != -1) {
            cart.getProducts().remove(index);
            System.out.println("All instances of the product removed from the cart.");
        } else {
            System.out.println("Product not found in the cart.");
        }
    }

      public static double calculateTotalAmount(Cart cart) {
        double total = 0;
        for (int i = 0; i < cart.getProducts().size(); i++) {
            total += cart.getProducts().get(i).getPrice() * cart.getCount()[i];
        }
        return total;
    }

}
