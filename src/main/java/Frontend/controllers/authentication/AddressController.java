// Updated AddressController.java
package Frontend.controllers.authentication;

import Backend.entity.Customer;
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
import java.util.Arrays;

public class AddressController {

    @FXML
    private ComboBox<String> Country;

    @FXML
    private TextField cityField;

    @FXML
    private TextField streetField;

    @FXML
    private TextField buildingField;

    @FXML
    private TextField areaDistrictField;

    @FXML
    private Button backButton;

    @FXML
    private Button nextButton;

    @FXML
    private Hyperlink signInLink;

    @FXML
    private Button close;

    private static Customer customer = new Customer();



    private static final String[] CountryList = { "Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua and Barbuda", "Argentina",
            "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados",
            "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana",
            "Brazil", "Brunei", "Bulgaria", "Burkina Faso", "Burundi", "Cabo Verde", "Cambodia", "Cameroon",
            "Canada", "Central African Republic", "Chad", "Chile", "China", "Colombia", "Comoros", "Congo",
            "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica",
            "Dominican Republic", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia",
            "Eswatini", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "Gambia", "Georgia", "Germany",
            "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras",
            "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy",
            "Ivory Coast", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea (North)",
            "Korea (South)", "Kosovo", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho",
            "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Madagascar", "Malawi",
            "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius",
            "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique",
            "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger",
            "Nigeria", "North Macedonia", "Norway", "Oman", "Pakistan", "Palau", "Palestine", "Panama",
            "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania",
            "Russia", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines",
            "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles",
            "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa",
            "South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname", "Sweden", "Switzerland", "Syria",
            "Tajikistan", "Tanzania", "Thailand", "Timor-Leste", "Togo", "Tonga", "Trinidad and Tobago",
            "Tunisia", "Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates",
            "United Kingdom", "United States", "Uruguay", "Uzbekistan", "Vanuatu", "Vatican City", "Venezuela",
            "Vietnam", "Yemen", "Zambia", "Zimbabwe"};

    public void initialize() {
        Country.getItems().addAll(Arrays.asList(CountryList));
    }

    private boolean validateFields() {
        if (cityField.getText().isEmpty()) {
            showAlert("Validation Error", "City field must not be empty.");
            return false;
        }
        if (streetField.getText().isEmpty()) {
            showAlert("Validation Error", "Street name field must not be empty.");
            return false;
        }
        if (buildingField.getText().isEmpty()) {
            showAlert("Validation Error", "Building name/number field must not be empty.");
            return false;
        }
        if (areaDistrictField.getText().isEmpty()) {
            showAlert("Validation Error", "Area/district field must not be empty.");
            return false;
        }
        if (Country.getValue() == null) {
            showAlert("Validation Error", "Please select a country.");
            return false;
        }
        return true;
    }

    @FXML
    void handleClose(ActionEvent event) throws IOException {
        switchToAnotherScene4(event);
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    private void handleBack(ActionEvent event) throws IOException {
        if (validateFields()) {
            switchToAnotherScene9(event);
        }    }

    @FXML
    private void handleNext(ActionEvent event) throws IOException {
        if (validateFields()) {
            customer.setAddress(Country.getValue());
            customer.setShippingAddress(cityField.getText());
            switchToAnotherScene7(event);
        }
    }


    @FXML
    void handleSignIn(ActionEvent event) throws IOException {
        switchToAnotherScene7(event);
    }

    public void switchToAnotherScene7(ActionEvent event) throws IOException {
        SceneController sceneController = new SceneController();
        sceneController.SwitchToScene7(event);
    }
    public void switchToAnotherScene4(ActionEvent event) throws IOException {
        SceneController sceneController = new SceneController();
        sceneController.SwitchToScene7(event);
    }
    public void switchToAnotherScene9(ActionEvent event) throws IOException {
        SceneController sceneController = new SceneController();
        sceneController.SwitchToScene7(event);
    }

}
