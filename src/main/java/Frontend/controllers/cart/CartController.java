package Frontend.controllers.cart;

import Backend.dao.CartDAO;
import Backend.entity.Cart;
import Backend.entity.Customer;
import Backend.entity.Enum.Gender;
import Backend.entity.Product;
import Backend.service.CartService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import run.project_ms2.SceneController;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class CartController implements Initializable {

    @FXML
    private GridPane Cbody;

    @FXML
    private Button Ccheckout;
    @FXML
    private Button Ccllear;

    @FXML
    private Label amount;
    @FXML
    private Label Cname;

    private static Customer customer;
    private static Cart cart;
    private List<CcardC> wantedcards;

    public static void setCustomer(Customer cust) {
        customer = cust;
        CartService cartService = new CartService();
        cart = cartService.getCartByCustomer(customer);
    }
    public void setname() {
        if (Cname != null) {
            if (customer == null) {
                customer = new Customer("Guest", "", "guest", "guest@example.com", Gender.OTHER, "", "", "", "", new Date());
                System.err.println("No customer set. Using default guest customer.");
            }
            Cname.setText("Welcome, " + customer.getUsername() + "!");
            System.out.println("Label set to: " + Cname.getText());
        } else {
            System.err.println("Pname label is not initialized yet.");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setupListeners();
        setname();
        setAmount();
        makeGrid();
    }

    // Set up event listeners for checkout and clearing the cart
    public void setupListeners() {
        if (Ccllear != null) {
            Ccllear.setOnAction(event -> {
                try {
                    clearCart(event);
                    makeGrid();
                    setAmount();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "Cart is already empty");

        }
        if (Ccheckout != null) {
            Ccheckout.setOnAction(event -> {
                try {
                    checkoutCart(event);
                    makeGrid();
                    setAmount();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } else{
            showAlert(Alert.AlertType.ERROR, "Error", "There is nothing to checkout");

        }

    }

    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public void makeGrid() {
        Cbody.getChildren().clear();
        wantedcards = Mackcards();
        int column = 1;
        int row = 1;

        try {
            for (CcardC card : wantedcards) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/run/project_ms2/Frontend/pages/cart/Ccard.fxml"));
                HBox cardbox = fxmlLoader.load();
                CardController2 cardController = fxmlLoader.getController();
                cardController.setData(card, cart);
                cardController.Quantity();
                cardController.setCartController(this);
                Cbody.add(cardbox, column, row++);
                GridPane.setMargin(cardbox, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading Ccard.fxml: " + e.getMessage());
        }

    }
    // Create a list of product cards based on the products in the customer's cart
    public List<CcardC> Mackcards() {
        List<CcardC> cards = new ArrayList<>();
        CartService cartService = new CartService();
        List<Product> products = cartService.getCartByCustomer(customer).getProducts();

        for (Product product : products) {
            CcardC card = new CcardC();
            card.setId(product.getId());
            card.setName(product.getName());
            card.setPrice(product.getPrice());
            card.setInfo("Category: " + product.getCategory().getName() + " | Brand: " + product.getBrand());
            card.setImage("/run/project_ms2/Frontend/images/pimages/" + product.getId() + ".jpg");
            cards.add(card);
        }
        return cards;
    }

    // Clear the cart by removing all products
    @FXML
    private void clearCart(ActionEvent event) throws IOException {
        CartService cartService = new CartService();
        cartService.clearCart(cart); // Clear cart in the backend
        setAmount();                 // Update total amount
        makeGrid();                  // Rebuild the grid
        System.out.println("Cart cleared.");
    }

    @FXML
    private void checkoutCart(ActionEvent event) throws IOException {
        CartService cartService = new CartService();
        if (((Button) event.getSource()).getId().equals("Ccheckout")) {
            cartService.checkoutCart(cart);
            System.out.println("Proceeding to checkout.");

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Checkout Complete");
            alert.setHeaderText(null);
            alert.setContentText("Your checkout has been successfully completed!");
            alert.showAndWait();
            setAmount();
            makeGrid();

            switchToAnotherScene4(event);
        }
    }


    public void setAmount() {
        double totalAmount = cart.getTotalAmount();
        amount.setText("$" + String.format("%.2f", totalAmount));
        System.out.println("Updated total amount: $" + totalAmount);
    }

    // Switch to another scene (Scene4)
    public void switchToAnotherScene4(ActionEvent event) throws IOException {
        SceneController sceneController = new SceneController();
        sceneController.SwitchToScene4(event);
    }

    // Switch to another scene (Scene6)
    public void switchToAnotherScene6(ActionEvent event) throws IOException {
        SceneController sceneController = new SceneController();
        sceneController.SwitchToScene6(event);
    }

    // Switch to another scene (Scene7)
    public void switchToAnotherScene7(ActionEvent event) throws IOException {
        SceneController sceneController = new SceneController();
        sceneController.SwitchToScene7(event);
    }
}
