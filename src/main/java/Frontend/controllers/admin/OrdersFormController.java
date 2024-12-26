package Frontend.controllers.admin;

import Backend.dao.CartDAO;
import Backend.dao.CategoryDAO;
import Backend.dao.OrderDAO;
import Backend.dao.ProductDAO;
import Backend.entity.*;
import Backend.entity.Enum.AdminRole;
import Backend.entity.Enum.Brand;
import Backend.entity.Enum.Gender;
import Backend.entity.Enum.PaymentMethod;
import Backend.service.OrderService;
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

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class OrdersFormController implements Initializable {
    @FXML
    public TableView<Order> OrdersTable;
    @FXML
    public TableColumn ColOrderID;
    @FXML
    public TableColumn ColOrderCustomerName;
    @FXML
    public TableColumn ColOrderProducts;
    @FXML
    public TableColumn ColOrderTotalPrice;
    @FXML
    public TableColumn ColOrderPayment;
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
                admin = new Admin("", "", "Guest", "", Gender.MALE, "", AdminRole.Moderator, "", new Date(90, 6, 20), "", "");
                System.err.println("No customer set. Using default guest customer.");
            }
            Pname.setText("Welcome, " + admin.getUsername() + "!");
            System.out.println("Label set to: " + Pname.getText());
        } else {
            System.err.println("Pname label is not initialized yet.");
        }
    }

    @FXML
    public void delete(ActionEvent event) {
        Order selectedOrder = OrdersTable.getSelectionModel().getSelectedItem();

        if (selectedOrder != null) {
            try {
                OrderDAO orderDAO = new OrderDAO();
                orderDAO.delete(selectedOrder);

                orderList.remove(selectedOrder);
                OrdersTable.setItems(orderList);

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


    ObservableList<Order> orderList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (admin == null) {
            System.err.println("Admin is not set. Ensure it's passed during login.");
            admin = new Admin("Guest", "", "guest", "guest@example.com", Gender.OTHER, "", AdminRole.Administrator, "", new Date(90, 6, 20), "", "");
        }
        setOrder();
        ColOrderID.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        ColOrderCustomerName.setCellValueFactory(new PropertyValueFactory<>("customer"));
        ColOrderProducts.setCellValueFactory(new PropertyValueFactory<>("products"));
        ColOrderTotalPrice.setCellValueFactory(new PropertyValueFactory<>("totalAmount"));
        ColOrderPayment.setCellValueFactory(new PropertyValueFactory<>("paymentMethod"));

        OrdersTable.setItems(orderList);

        ColOrderID.setResizable(false);
        ColOrderCustomerName.setResizable(false);
        ColOrderProducts.setResizable(false);
        ColOrderTotalPrice.setResizable(false);
        ColOrderPayment.setResizable(false);

        OrdersTable.getColumns().forEach(column -> column.setReorderable(false));

        setname();
        SearchFilter();
        refreshFilteredList();
    }

    public void setOrder() {
        if (!orderList.isEmpty()) {
            return;
        }
        OrderDAO orderDAO = new OrderDAO();
        List<Order> orders = orderDAO.getAll();
        for (Order order : orders) {
            orderList.addAll(order);
        }
    }

    public TextField txtSearchbar;

    public void SearchFilter() {
        FilteredList<Order> filterData = new FilteredList<>(orderList, p -> true);
        txtSearchbar.textProperty().addListener((observable, oldValue, newValue) -> {
            filterData.setPredicate(order -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (order.getCustomer().toString().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });

        SortedList<Order> sortedData = new SortedList<>(filterData);
        sortedData.comparatorProperty().bind(OrdersTable.comparatorProperty());
        OrdersTable.setItems(sortedData);
    }

    public void refreshFilteredList() {
        FilteredList<Order> filterData = new FilteredList<>(orderList, p -> true);
        txtSearchbar.textProperty().addListener((observable, oldValue, newValue) -> {
            filterData.setPredicate(order -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (order.getCustomer().toString().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });

        SortedList<Order> sortedData = new SortedList<>(filterData);
        sortedData.comparatorProperty().bind(OrdersTable.comparatorProperty());
        OrdersTable.setItems(sortedData);
    }

    public void switchToAnotherScene1(ActionEvent event) throws IOException {
        SceneController sceneController = new SceneController();
        sceneController.SwitchToScene1(event);
    }

    public void switchToAnotherScene3(ActionEvent event) throws IOException {
        SceneController sceneController = new SceneController();
        sceneController.SwitchToScene3(event);
    }

    public void switchToAnotherScene7(ActionEvent event) throws IOException {
        SceneController sceneController = new SceneController();
        sceneController.SwitchToScene7(event);
    }
}