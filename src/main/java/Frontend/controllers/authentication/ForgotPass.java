package Frontend.controllers.authentication;

import Backend.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import run.project_ms2.SceneController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class ForgotPass implements Initializable {

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private TextField visiblePasswordField;

    @FXML
    private TextField visibleConfirmPasswordField;

    @FXML
    private Button revealPasswordButton;

    @FXML
    private Button revealConfirmPasswordButton;

    @FXML
    private Button resetPasswordButton;

    @FXML
    private Button backButton;

    @FXML
    private Button close;

    @FXML
    private Hyperlink signInLink;

    private boolean isPasswordVisible = false;
    private boolean isConfirmPasswordVisible = false;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialize fields
        visiblePasswordField.setVisible(false);
        visiblePasswordField.managedProperty().bind(visiblePasswordField.visibleProperty());
        passwordField.managedProperty().bind(passwordField.visibleProperty());
        visiblePasswordField.textProperty().bindBidirectional(passwordField.textProperty());

        visibleConfirmPasswordField.setVisible(false);
        visibleConfirmPasswordField.managedProperty().bind(visibleConfirmPasswordField.visibleProperty());
        confirmPasswordField.managedProperty().bind(confirmPasswordField.visibleProperty());
        visibleConfirmPasswordField.textProperty().bindBidirectional(confirmPasswordField.textProperty());
    }

    // Toggles visibility of password field content
    @FXML
    void togglePasswordVisibility(ActionEvent event) {
        isPasswordVisible = !isPasswordVisible;
        if (isPasswordVisible) {
            visiblePasswordField.setVisible(true);
            passwordField.setVisible(false);
        } else {
            visiblePasswordField.setVisible(false);
            passwordField.setVisible(true);
        }
    }

    @FXML
    void toggleConfirmPasswordVisibility(ActionEvent event) {
        isConfirmPasswordVisible = !isConfirmPasswordVisible;
        if (isConfirmPasswordVisible) {
            visibleConfirmPasswordField.setVisible(true);
            confirmPasswordField.setVisible(false);
        } else {
            visibleConfirmPasswordField.setVisible(false);
            confirmPasswordField.setVisible(true);
        }
    }

    // Validates password format
    private boolean validatePassword(String password) {
        String passwordRegex =  "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()-+=<>?]).{8,}$";
        return Pattern.matches(passwordRegex, password);
    }

    @FXML
    void handleClose(ActionEvent event) throws IOException {
        switchToAnotherScene4(event);
    }

    @FXML
    private void resetPassword(ActionEvent event) {
        // Determine which password fields are currently visible and get their values
        String password = isPasswordVisible ? visiblePasswordField.getText() : passwordField.getText();
        String confirmPassword = isConfirmPasswordVisible ? visibleConfirmPasswordField.getText() : confirmPasswordField.getText();

        if (password.isEmpty() || confirmPassword.isEmpty()) {
            showAlert(AlertType.ERROR, "Error", "Fields cannot be empty!");
            return;
        }

        if (!validatePassword(password)) {
            showAlert(AlertType.ERROR, "Invalid Password", "Password must be at least 8 characters, include uppercase, lowercase, a number, and a special character.");
            return;
        }

        if (!password.equals(confirmPassword)) {
            showAlert(AlertType.ERROR, "Error", "Passwords do not match.");
            return;
        }

        UserService userService = UserService.getInstance();
        if (userService.changePassword(password)) {
            showAlert(AlertType.INFORMATION, "Success", "Password has been reset successfully.");
            userService.logout(); // Optionally log out the user after password reset
            switchToLogin(event);
        } else {
            showAlert(AlertType.ERROR, "Error", "No user is currently logged in.");
        }
    }



    @FXML
    private void switchToLogin(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/run/project_ms2/Frontend/pages/authentication/LoginPage.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Login Page");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert(AlertType.ERROR, "Navigation Error", "Unable to load the Login page.");
        }
    }

    @FXML
    void goToSignUp(ActionEvent event) throws IOException {
        switchToAnotherScene8(event);
    }

    private void showAlert(AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }


    public void switchToAnotherScene4(ActionEvent event) throws IOException {
        SceneController sceneController = new SceneController();
        sceneController.SwitchToScene4(event);
    }
    public void switchToAnotherScene8(ActionEvent event) throws IOException {
        SceneController sceneController = new SceneController();
        sceneController.SwitchToScene8(event);
    }
}
