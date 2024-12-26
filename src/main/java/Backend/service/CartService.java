package Backend.service;

import Backend.dao.CartDAO;
import Backend.dao.OrderDAO;
import Backend.dao.ProductDAO;
import Backend.entity.Cart;
import Backend.entity.Customer;
import Backend.entity.Enum.PaymentMethod;
import Backend.entity.Order;
import Backend.entity.Product;
import Database.Database;

import java.util.ArrayList;

public class CartService {

    static ProductService productService= new ProductService();
    static CartDAO cartDAO = new CartDAO();
    static ProductDAO productDAO = new ProductDAO();
    static OrderDAO orderDAO = new OrderDAO();

    public boolean createCart(Customer customer) {
        if(customer == null || customer.getUsername() == null) {
            System.out.println("Error: Customer or username cannot be null.");
            return false;
        }
        Cart cart = new Cart(customer);
        cartDAO.add(cart);
        System.out.println("Cart added successfully with ID: " + customer.getId());
        return true;
    }

    public Cart getCartByCustomer(Customer customer) {
        if (customer == null || customer.getUsername() == null) {
            System.out.println("Error: Customer or username cannot be null.");
            return null;
        }

        if (Database.carts == null) {
            System.out.println("Error: The carts list is not initialized.");
            return null;
        }

        for (Cart cart : Database.carts) {
            if (cart != null && cart.getCustomer() != null && cart.getCustomer().getUsername().equals(customer.getUsername())) {
                System.out.println("Cart found.");
                return cart;
            }
        }

        System.out.println("Cart not found. Returning a new empty cart.");
        Cart newCart = new Cart();
        newCart.setCustomer(customer);
        newCart.setProducts(new ArrayList<>());
        newCart.setCount(new int[50]);
        newCart.setTotalAmount(0);
        return newCart;
    }
    public void addProductToCart(Cart cart, Product product) {
        if (cart.getProducts().contains(product)) {
            int index = cart.getProducts().indexOf(product);
            cart.getCount()[index]++;
            System.out.println(cart.getCount()[index]);
        } else {
            cart.getProducts().add(product);
            int index = cart.getProducts().indexOf(product);
            if (cart.getCount().length < cart.getProducts().size()) {
                int[] newCount = new int[cart.getProducts().size()];
                System.arraycopy(cart.getCount(), 0, newCount, 0, cart.getCount().length);
                cart.setCount(newCount);
            }
            System.out.println("Product count: " + cart.getCount()[index]);

            cart.getCount()[index] = 1;
        }
        calculateTotalAmount(cart);
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
        calculateTotalAmount(cart);
    }
    public void removeAllProduct(Cart cart, Product product) {
        int index = cart.getProducts().indexOf(product);
        if (index != -1) {
            cart.getProducts().remove(index);
            System.out.println("All instances of the product removed from the cart.");
        } else {
            System.out.println("Product not found in the cart.");
        }
        calculateTotalAmount(cart);
    }

    public double calculateTotalAmount(Cart cart) {
        double Total = 0;
        for (int i = 0; i < cart.getProducts().size(); i++) {
            Total += cart.getProducts().get(i).getPrice() * cart.getCount()[i];
        }
        cart.setTotalAmount(Total);
        return Total;
    }
    public void clearCart(Cart cart){
        cart.getProducts().clear();
        cart.setCount(new int[50]);
        System.out.println("Cart cleared successfully.");
        calculateTotalAmount(cart);
    }
    public void checkoutCart(Cart cart) {
        if (cart.getProducts().isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            System.out.println("Total amount: $" + cart.getTotalAmount());
            System.out.println("Checkout successful.");
            OrderService orderService = new OrderService();
            Order order = new Order(cart.getCustomer(), cart.getProducts(), cart.getTotalAmount(), PaymentMethod.CASH);
            orderService.createOrder(order);
        }
    }

    public void addToCart(int id, Customer customer) {
        Product product = productService.getProductById(id);
        if (product != null) {
            Cart cart = getCartByCustomer(customer);
            addProductToCart(cart, product);
            System.out.println("Product added to cart: " + product.getName());
        } else {
            System.out.println("Product not found with ID: " + id);
        }
    }

}
