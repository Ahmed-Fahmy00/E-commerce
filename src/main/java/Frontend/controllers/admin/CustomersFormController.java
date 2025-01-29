package Frontend.controllers.admin;

import Backend.dao.CustomerDAO;
import Backend.entity.Admin;
import Backend.entity.Customer;
import Backend.entity.Enum.AdminRole;
import Backend.entity.Enum.Gender;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import run.project_ms2.SceneController;
import tests.Customertestdata;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class CustomersFormController implements Initializable {
    @FXML
    public TableView<Customer> CustomerTable;
    @FXML
    public TableColumn ColCustID;
    @FXML
    public TableColumn ColCustFirstName;
    @FXML
    public TableColumn ColCustLastName;
    @FXML
    public TableColumn ColCustUsername;
    @FXML
    public TableColumn ColCustEmail;
    @FXML
    public TableColumn ColCustGender;
    @FXML
    public TableColumn ColCustAddress;
    @FXML
    public TableColumn ColCustShippingAdd;
    @FXML
    public TableColumn ColCustDateOfBirth;
    @FXML
    public TableColumn ColCustPhone;
    @FXML
    public TableColumn ColCustPassword;
    @FXML
    public TextField txtFirstname;
    @FXML
    public TextField txtLastname;
    @FXML
    public TextField txtUsername;
    @FXML
    public TextField txtEmail;
    @FXML
    public PasswordField txtPassword;
    @FXML
    public TextField txtPhone;
    @FXML
    private Label Pname;

    private static Admin admin;

    public static void setAdmin(Admin adm) {
        admin = adm;
        System.out.println("Customer set to: " + (adm != null ? adm.getUsername() : "null"));
    }

    public void setname() {
        if (Pname != null) {
            if (admin == null) {
                admin = new Admin("", "", "Guest", "", Gender.MALE, "", AdminRole.Moderator,"", new Date(90, 6, 20),"", "");
                System.err.println("No customer set. Using default guest customer.");
            }
            Pname.setText("Welcome, " + admin.getUsername() + "!");
            System.out.println("Label set to: " + Pname.getText());
        } else {
            System.err.println("Pname label is not initialized yet.");
        }
    }

    @FXML
    public void add(ActionEvent event) {
        CustomerDAO customerDAO = new CustomerDAO();
        Customer customer = new Customer(txtFirstname.getText(), txtLastname.getText(), txtUsername.getText(), txtEmail.getText(), Gender.MALE, txtPassword.getText(), "null", txtPhone.getText(), "null", new Date());
        customerDAO.add(customer);
        custList.add(customer);
        refreshFilteredList();
        CustomerTable.setItems(custList);
        txtFirstname.clear();
        txtLastname.clear();
        txtUsername.clear();
        txtEmail.clear();
        txtPassword.clear();
        txtPhone.clear();
        refreshFilteredList();
    }

    @FXML
    public void delete(ActionEvent event) {
        Customer selectedCustomer = CustomerTable.getSelectionModel().getSelectedItem();

        if (selectedCustomer != null) {
            try {
                CustomerDAO customerDAO = new CustomerDAO();
                customerDAO.delete(selectedCustomer);

                custList.remove(selectedCustomer);
                CustomerTable.setItems(custList);

                refreshFilteredList();

            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Could not delete customer");
                alert.setContentText("An error occurred while trying to delete the customer: " + e.getMessage());
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText(null);
            alert.setContentText("Please select a customer to delete.");
            alert.showAndWait();
        }
    }


    static ObservableList<Customer> custList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (admin == null) {
            System.err.println("Admin is not set. Ensure it's passed during login.");
            admin = new Admin("Guest", "", "guest", "guest@example.com", Gender.OTHER, "", AdminRole.Administrator, "", new Date(90, 6, 20), "", "");
        }
        setCustomer();
        ColCustID.setCellValueFactory(new PropertyValueFactory<>("id"));
        ColCustFirstName.setCellValueFactory(new PropertyValueFactory<>("firstnameName"));
        ColCustLastName.setCellValueFactory(new PropertyValueFactory<>("lastnameName"));
        ColCustUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
        ColCustEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        ColCustGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        ColCustAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        ColCustShippingAdd.setCellValueFactory(new PropertyValueFactory<>("shippingAddress"));
        ColCustDateOfBirth.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        ColCustPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        ColCustPassword.setCellValueFactory(new PropertyValueFactory<>("password"));

        CustomerTable.setItems(custList);

        ColCustID.setResizable(false);
        ColCustFirstName.setResizable(false);
        ColCustLastName.setResizable(false);
        ColCustUsername.setResizable(false);
        ColCustEmail.setResizable(false);
        ColCustGender.setResizable(false);
        ColCustAddress.setResizable(false);
        ColCustShippingAdd.setResizable(false);
        ColCustDateOfBirth.setResizable(false);
        ColCustPhone.setResizable(false);

        CustomerTable.getColumns().forEach(column -> column.setReorderable(false));
        setname();
        SearchFilter();
        refreshFilteredList();
    }

    public static void setCustomer() {
        if (!custList.isEmpty()) {
            return;
        }
        Customertestdata.makeCustomers();
        CustomerDAO customerDAO = new CustomerDAO();
        List<Customer> customers = customerDAO.getAll();
        custList.addAll(customers);
    }


    public TextField txtSearchbar;

    public void SearchFilter() {
        FilteredList<Customer> filterData = new FilteredList<>(custList, p -> true);
        txtSearchbar.textProperty().addListener((observable, oldValue, newValue) -> {
            filterData.setPredicate(customer -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (customer.getFirstnameName().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (customer.getLastnameName().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (customer.getUsername().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (customer.getEmail().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (customer.getGender().toString().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (customer.getAddress().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (customer.getShippingAddress().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (customer.getPhone().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (customer.getDateOfBirth().toString().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });

        SortedList<Customer> sortedData = new SortedList<>(filterData);
        sortedData.comparatorProperty().bind(CustomerTable.comparatorProperty());
        CustomerTable.setItems(sortedData);
    }

    public void refreshFilteredList() {
        FilteredList<Customer> filterData = new FilteredList<>(custList, p -> true);
        txtSearchbar.textProperty().addListener((observable, oldValue, newValue) -> {
            filterData.setPredicate(customer -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (customer.getFirstnameName().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (customer.getLastnameName().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (customer.getUsername().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (customer.getEmail().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (customer.getGender().toString().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (customer.getAddress().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (customer.getShippingAddress().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (customer.getPhone().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (customer.getDateOfBirth().toString().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });

        SortedList<Customer> sortedData = new SortedList<>(filterData);
        sortedData.comparatorProperty().bind(CustomerTable.comparatorProperty());
        CustomerTable.setItems(sortedData);
    }

    public void switchToAnotherScene1(ActionEvent event) throws IOException {
        SceneController sceneController = new SceneController();
        sceneController.SwitchToScene1(event);
    }
    public void switchToAnotherScene2(ActionEvent event) throws IOException {
        SceneController sceneController = new SceneController();
        sceneController.SwitchToScene2(event);
    }
    public void switchToAnotherScene7(ActionEvent event) throws IOException {
        SceneController sceneController = new SceneController();
        sceneController.SwitchToScene7(event);
    }

}