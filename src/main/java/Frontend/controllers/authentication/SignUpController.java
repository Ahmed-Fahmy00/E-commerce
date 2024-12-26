package Frontend.controllers.authentication;

import Backend.entity.*;
import Backend.service.*;
import Backend.dao.*;
import Backend.entity.Enum.AdminRole;
import Backend.service.CustomerService;
import Backend.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import run.project_ms2.SceneController;

import java.io.IOException;
import java.util.regex.Pattern;

public class SignUpController {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private Button togglePasswordButton;

    @FXML
    private Button toggleConfirmPasswordButton;

    @FXML
    private Button nextButton;

    @FXML
    private Hyperlink signInLink;

    @FXML
    private TextField visiblePasswordField;

    @FXML
    private Button close;

    @FXML
    private TextField visibleConfirmPasswordField;

    private boolean isPasswordVisible = false;
    private boolean isConfirmPasswordVisible = false;

    private static Customer customer = new Customer();

    @FXML
    public void togglePasswordVisibility(ActionEvent event) {
        isPasswordVisible = !isPasswordVisible;
        if (isPasswordVisible) {
            visiblePasswordField.setText(passwordField.getText());
            visiblePasswordField.setVisible(true);
            passwordField.setVisible(false);
        } else {
            passwordField.setText(visiblePasswordField.getText());
            visiblePasswordField.setVisible(false);
            passwordField.setVisible(true);
        }
    }

    @FXML
    public void toggleConfirmPasswordVisibility(ActionEvent event) {
        isConfirmPasswordVisible = !isConfirmPasswordVisible;
        if (isConfirmPasswordVisible) {
            visibleConfirmPasswordField.setText(confirmPasswordField.getText());
            visibleConfirmPasswordField.setVisible(true);
            confirmPasswordField.setVisible(false);
        } else {
            confirmPasswordField.setText(visibleConfirmPasswordField.getText());
            visibleConfirmPasswordField.setVisible(false);
            confirmPasswordField.setVisible(true);
        }
    }

    @FXML
    void handleClose(ActionEvent event) throws IOException {
        switchToAnotherScene4(event);
    }

    @FXML
    public void goToNextPage(ActionEvent event) throws IOException {
        if (validateInput()) {
            try {
                customer.setUsername(usernameField.getText().trim());
                customer.setEmail(emailField.getText().trim());
                customer.setPassword(isPasswordVisible ? visiblePasswordField.getText().trim() : passwordField.getText().trim());
                // Add customer to the database
                CustomerService customerService = new CustomerService();
                if (customerService.createCustomer(customer)) {
                    System.out.println("Customer successfully added to the database.");
                    switchToAnotherScene9(event);
                } else {
                    showAlert(Alert.AlertType.ERROR, "Sign-Up Failed", "Username already exists or an error occurred.");
                }
            } catch (IllegalArgumentException e) {
                showAlert(Alert.AlertType.ERROR, "Error", e.getMessage());
            }
        }
    }


    @FXML
    public void goToLoginPage(ActionEvent event) throws IOException {
       switchToAnotherScene7(event);
    }

    private boolean validateInput() {
        String username = usernameField.getText().trim();
        String email = emailField.getText().trim();
        String password = isPasswordVisible ? visiblePasswordField.getText().trim() : passwordField.getText().trim();
        String confirmPassword = isConfirmPasswordVisible ? visibleConfirmPasswordField.getText().trim() : confirmPasswordField.getText().trim();

        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "All fields must be filled.");
            return false;
        }

        if (!Pattern.matches("^[a-zA-Z0-9_]{3,15}$", username)) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "Invalid username. Use 3-15 alphanumeric characters.");
            return false;
        }

        if (!Pattern.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+\\.com$", email)) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "Invalid email format.");
            return false;
        }

        if (!isPasswordValid(password)) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "Password must contain at least one digit, one lowercase letter, one uppercase letter, one special character, and be at least 8 characters long.");
            return false;
        }

        if (!password.equals(confirmPassword)) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "Passwords do not match.");
            return false;
        }

        return true;
    }

    private boolean isPasswordValid(String password) {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
        return password.matches(regex);
    }


    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static Customer getCustomer() {
        return customer;
    }

    public void switchToAnotherScene9(ActionEvent event) throws IOException {
        SceneController sceneController = new SceneController();
        sceneController.SwitchToScene9(event);
    }

    public void switchToAnotherScene7(ActionEvent event) throws IOException {
        SceneController sceneController = new SceneController();
        sceneController.SwitchToScene7(event);
    }
    public void switchToAnotherScene4(ActionEvent event) throws IOException {
        SceneController sceneController = new SceneController();
        sceneController.SwitchToScene4(event);
    }

}
