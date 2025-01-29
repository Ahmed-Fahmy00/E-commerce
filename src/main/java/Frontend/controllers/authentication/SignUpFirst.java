// Updated SignUpFirst.java
package Frontend.controllers.authentication;

import Backend.dao.CustomerDAO;
import Backend.entity.Customer;
import Backend.entity.Enum.Gender;
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
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

public class SignUpFirst {

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private DatePicker birthDatePicker;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private ComboBox<String> Gender;

    @FXML
    private Button nextButton;

    @FXML
    private Button close;

    @FXML
    private Button backButton;

    @FXML
    private Hyperlink signInLink;

    private static final Pattern NAME_PATTERN = Pattern.compile("^[A-Za-z]+$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\d{10}$");

    private static Customer customer = new Customer();

    @FXML
    void initialize() {
        Gender.getItems().addAll("Female", "Male", "Prefer not to say", "Other");
    }

    @FXML
    void handleBack(ActionEvent event) throws IOException {
        switchToAnotherScene9(event);
    }

    @FXML
    void handleNext(ActionEvent event) throws IOException {
        if (validateFields()) {
            Customer customer = SignUpFirst.getCustomer();
            customer.setFirstName(firstNameField.getText().trim());
            customer.setLastname(lastNameField.getText().trim());
            customer.setGender(Backend.entity.Enum.Gender.valueOf(Gender.getValue().toUpperCase()));
            customer.setPhone(phoneNumberField.getText().trim());
            customer.setDateOfBirth(Date.valueOf(birthDatePicker.getValue()));
            switchToAnotherScene10(event);
        }
    }


    @FXML
    void handleClose(ActionEvent event) throws IOException {
        switchToAnotherScene4(event);
    }

    @FXML
    void handleSignIn(ActionEvent event) throws IOException {
        switchToAnotherScene7(event);
    }

    private boolean validateFields() {
        boolean isValid = true;

        // Check if all fields are empty
        if (firstNameField.getText().trim().isEmpty() &&
                lastNameField.getText().trim().isEmpty() &&
                (birthDatePicker.getValue() == null) &&
                phoneNumberField.getText().trim().isEmpty() &&
                Gender.getValue() == null) {

            showAlert("Empty Fields", "All fields must be filled.");
            return false;
        }

        // Validate First Name
        if (firstNameField.getText().trim().isEmpty()) {
            showAlert("Invalid First Name", "First name cannot be empty.");
            isValid = false;
        } else if (!NAME_PATTERN.matcher(firstNameField.getText().trim()).matches()) {
            showAlert("Invalid First Name", "First name should only contain alphabets.");
            isValid = false;
        }

        // Validate Last Name
        if (lastNameField.getText().trim().isEmpty()) {
            showAlert("Invalid Last Name", "Last name cannot be empty.");
            isValid = false;
        } else if (!NAME_PATTERN.matcher(lastNameField.getText().trim()).matches()) {
            showAlert("Invalid Last Name", "Last name should only contain alphabets.");
            isValid = false;
        }

        // Validate Birth Date
        LocalDate birthDate = birthDatePicker.getValue();
        if (birthDate == null) {
            showAlert("Invalid Birth Date", "Birth date cannot be empty.");
            isValid = false;
        } else if (birthDate.isAfter(LocalDate.now())) {
            showAlert("Invalid Birth Date", "Please select a valid birth date.");
            isValid = false;
        } else if (Period.between(birthDate, LocalDate.now()).getYears() < 16) {
            showAlert("Invalid Birth Date", "You must be at least 16 years old.");
            isValid = false;
        }

        // Validate Phone Number
        if (phoneNumberField.getText().trim().isEmpty()) {
            showAlert("Invalid Phone Number", "Phone number cannot be empty.");
            isValid = false;
        } else if (!PHONE_PATTERN.matcher(phoneNumberField.getText().trim()).matches()) {
            showAlert("Invalid Phone Number", "Phone number should contain exactly 10 digits.");
            isValid = false;
        }

        // Validate Gender
        if (Gender.getValue() == null) {
            showAlert("Invalid Gender Selection", "Please select a gender.");
            isValid = false;
        }

        return isValid;
    }


    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static Customer getCustomer() {
        return customer;
    }

    public void switchToAnotherScene4(ActionEvent event) throws IOException {
        SceneController sceneController = new SceneController();
        sceneController.SwitchToScene4(event);
    }
    public void switchToAnotherScene7(ActionEvent event) throws IOException {
        SceneController sceneController = new SceneController();
        sceneController.SwitchToScene7(event);
    }
    public void switchToAnotherScene8(ActionEvent event) throws IOException {
        SceneController sceneController = new SceneController();
        sceneController.SwitchToScene8(event);
    }
    public void switchToAnotherScene9(ActionEvent event) throws IOException {
        SceneController sceneController = new SceneController();
        sceneController.SwitchToScene9(event);
    }
    public void switchToAnotherScene10(ActionEvent event) throws IOException {
        SceneController sceneController = new SceneController();
        sceneController.SwitchToScene10(event);
    }


}