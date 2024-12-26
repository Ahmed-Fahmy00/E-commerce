package Frontend.controllers.authentication;

import Backend.entity.Admin;
import Backend.entity.Customer;
import Backend.service.UserService;
import Frontend.controllers.admin.CustomersFormController;
import Frontend.controllers.admin.OrdersFormController;
import Frontend.controllers.admin.ProductsFormController;
import Frontend.controllers.cart.CartController;
import Frontend.controllers.order.OrderHistoryController;
import Frontend.controllers.product.ProductmenuController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import run.project_ms2.SceneController;
import tests.AdminTest;
import tests.Customertestdata;
import tests.ProductsTest;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private TextField userField;

    @FXML
    private Button close;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField visiblePasswordField;

    @FXML
    private Button togglePasswordVisibilityButton;

    @FXML
    private Button loginButton;

    @FXML
    private Hyperlink forgotPasswordLink;

    @FXML
    private Hyperlink signUpLink;

    private boolean passwordVisible = false;
    private Customer customer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialize fields

        visiblePasswordField.setVisible(false);
        visiblePasswordField.managedProperty().bind(visiblePasswordField.visibleProperty());
        passwordField.managedProperty().bind(passwordField.visibleProperty());
        visiblePasswordField.textProperty().bindBidirectional(passwordField.textProperty());
    }

    @FXML
    void handleClose(ActionEvent event) throws IOException {
        customer = null;
        switchToAnotherScene4(event);
    }

    @FXML
    void togglePasswordVisibility(MouseEvent event) {
        passwordVisible = !passwordVisible;
        if (passwordVisible) {
            visiblePasswordField.setVisible(true);
            passwordField.setVisible(false);
        } else {
            visiblePasswordField.setVisible(false);
            passwordField.setVisible(true);
        }
    }

    @FXML
    void handleLogin(ActionEvent event) throws IOException {
        String username = userField.getText().trim();
        String password = passwordVisible ? visiblePasswordField.getText().trim() : passwordField.getText().trim();

        // Validate Input
        if (username.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error", "Username cannot be empty!");
            return;
        }

        if (!username.matches("^[a-zA-Z0-9](?!.*[_.]{2})[a-zA-Z0-9._]{1,18}[a-zA-Z0-9]$")) {
            showAlert(Alert.AlertType.ERROR, "Invalid Username", "Please enter a valid username.");
            return;
        }

        if (password.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error", "Password cannot be empty!");
            return;
        }

        if (password.length() < 8) {
            showAlert(Alert.AlertType.ERROR, "Invalid Password", "Password must be at least 8 characters long.");
            return;
        }

        UserService userService = UserService.getInstance();
        Customer customer = userService.loginGUICustomer(username, password);
        Admin admin = userService.loginGUIAdmin(username, password);

        if (customer != null) {
            System.out.println("Customer Login successful");
            ProductmenuController.setCustomer(customer);
            OrderHistoryController.setCustomer(customer);
            CartController.setCustomer(customer);
            switchToAnotherScene4(event);
        } else if (admin != null) {
            System.out.println("Admin Login successful");
            ProductsFormController.setAdmin(admin);
            CustomersFormController.setAdmin(admin);
            OrdersFormController.setAdmin(admin);
            switchToAnotherScene3(event);
        } else {
            showAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid username or password.");
        }
    }


    // Utility method to show alert messages
    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    void goToForgotPassword(ActionEvent event) throws IOException {
        switchToAnotherScene11(event);
    }

    @FXML
    void goToSignUp(ActionEvent event) throws IOException {
        switchToAnotherScene8(event);
    }

    public void switchToAnotherScene4(ActionEvent event) throws IOException {
        SceneController sceneController = new SceneController();
        sceneController.SwitchToScene4(event);
    }
    public void switchToAnotherScene3(ActionEvent event) throws IOException {
        SceneController sceneController = new SceneController();
        sceneController.SwitchToScene3(event);
    }
    public void switchToAnotherScene8(ActionEvent event) throws IOException {
        SceneController sceneController = new SceneController();
        sceneController.SwitchToScene8(event);
    }
    public void switchToAnotherScene10(ActionEvent event) throws IOException {
        SceneController sceneController = new SceneController();
        sceneController.SwitchToScene10(event);
    }
    public void switchToAnotherScene7(ActionEvent event) throws IOException {
        SceneController sceneController = new SceneController();
        sceneController.SwitchToScene7(event);
    }

    public void switchToAnotherScene11(ActionEvent event) throws IOException {
        SceneController sceneController = new SceneController();
        sceneController.SwitchToScene11(event);
    }

}
