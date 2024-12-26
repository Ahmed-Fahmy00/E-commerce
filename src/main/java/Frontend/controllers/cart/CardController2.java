package Frontend.controllers.cart;


import Backend.entity.Product;
import Backend.service.*;
import Backend.entity.Cart;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import Frontend.controllers.cart.CartController;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import run.project_ms2.SceneController;

import java.io.IOException;
import java.io.InputStream;

public class CardController2 {

    @FXML
    private ImageView cardimage;
    @FXML
    private Label cardname;
    @FXML
    private Label cardinfo;
    @FXML
    private Label cardprice;
    @FXML
    private Label quantityLabel;
    @FXML
    private Label amount;

    private CartController cartController;
    public void setCartController(CartController cartController) {
        this.cartController = cartController;
    }



    private int id;
    private Cart cart;

    public void add() {
        ProductService productService = new ProductService();
        CartService cartService = new CartService();

        Product product = productService.getProductById(id);
        if (product != null) {
            cartService.addProductToCart(cart, product);
            cartController.makeGrid();  // Refresh the grid
            cartController.setAmount(); // Update the total amount
        } else {
            System.err.println("Product with ID " + id + " not found.");
        }
    }

    public void remove() {
        ProductService productService = new ProductService();
        CartService cartService = new CartService();

        Product product = productService.getProductById(id);
        if (product != null) {
            cartService.removeOneOfProduct(cart, product);
            cartController.makeGrid();  // Refresh the grid
            cartController.setAmount(); // Update the total amount
        } else {
            System.err.println("Product with ID " + id + " not found.");
        }
    }


    public void removeAll() {
        ProductService productService = new ProductService();
        CartService cartService = new CartService();

        Product product = productService.getProductById(id); // Get the product by ID
        if (product != null) {
            cartService.removeAllProduct(cart, product); // Remove all instances of the product
            cartController.setAmount();
            cartController.makeGrid();
            cartController.setAmount();
            System.out.println("Removed all of product with ID: " + id);
        } else {
            System.err.println("Product with ID " + id + " not found.");
        }
    }

    void Quantity() {
        if (cart != null && cart.getCount() != null) {
            int currentQuantity = cart.getCount()[id];
            quantityLabel.setText(String.valueOf(currentQuantity+1));
            System.out.println("Updated quantity for product ID " + id + ": " + currentQuantity);
        } else {
            System.err.println("Cart or cart count array is null. Unable to update quantity.");
        }
    }

    public void setData(CcardC card, Cart cart) {
        this.cart = cart;
        this.id = card.getId();
        System.out.println("The path is: " + card.getImage());

        // Set the image
        InputStream stream = getClass().getResourceAsStream(card.getImage());
        if (stream != null) {
            Image image = new Image(stream);
            cardimage.setImage(image);
        }

        // Set other card details
        cardname.setText(card.getName());
        cardinfo.setText(card.getInfo());
        cardprice.setText(String.format("$%.2f", card.getPrice()));

        Quantity();

    }
    public void switchToAnotherScene5(ActionEvent event) throws IOException {
        SceneController sceneController = new SceneController();
        sceneController.SwitchToScene5(event);
    }

}
