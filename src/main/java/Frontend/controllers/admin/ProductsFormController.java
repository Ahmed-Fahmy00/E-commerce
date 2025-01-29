package Frontend.controllers.admin;

import Backend.dao.CategoryDAO;
import Backend.dao.ProductDAO;
import Backend.entity.Admin;
import Backend.entity.Category;
import Backend.entity.Customer;
import Backend.entity.Enum.AdminRole;
import Backend.entity.Enum.Brand;
import Backend.entity.Enum.Gender;
import Backend.entity.Product;
import Backend.service.ProductService;
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
import tests.ProductsTest;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class ProductsFormController implements Initializable {
    @FXML
    public TableView<Product> ProductTable;
    @FXML
    public TableColumn ColProdID;
    @FXML
    public TableColumn ColProdName;
    @FXML
    public TableColumn ColProdPrice;
    @FXML
    public TableColumn ColProdCategory;
    @FXML
    public TableColumn ColProdBrand;
    @FXML
    public TableColumn ColProdRate;
    @FXML
    public TextField txtProductName;
    @FXML
    public Spinner<Double> txtProductPrice;
    @FXML
    public TextField txtProductCategory;
    @FXML
    public TextField txtProductBrand;
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
        ProductDAO productDAO = new ProductDAO();
        Category category = new Category(txtProductCategory.getText());
        Product product = new Product(txtProductName.getText(), txtProductPrice.getValue(), category, Brand.Apple, 5);
        productDAO.add(product);
        productList.add(product);
        refreshFilteredList();
        ProductTable.setItems(productList);
        txtProductName.clear();
        txtProductPrice.getValueFactory().setValue(0.0);
        txtProductCategory.clear();
        txtProductBrand.clear();
        refreshFilteredList();
    }

    @FXML
    public void delete(ActionEvent event) {
        Product selectedProduct = ProductTable.getSelectionModel().getSelectedItem();

        if (selectedProduct != null) {
            try {
                ProductDAO productDAO = new ProductDAO();
                productDAO.delete(selectedProduct);

                productList.remove(selectedProduct);
                ProductTable.setItems(productList);

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


    static ObservableList<Product> productList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (admin == null) {
            System.err.println("Admin is not set. Ensure it's passed during login.");
            admin = new Admin("Guest", "", "guest", "guest@example.com", Gender.OTHER, "", AdminRole.Administrator, "", new Date(90, 6, 20), "", "");
        }
        setProduct();
        ColProdID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        ColProdName.setCellValueFactory(new PropertyValueFactory<>("name"));
        ColProdPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        ColProdCategory.setCellValueFactory(new PropertyValueFactory<>("name"));
        ColProdBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        ColProdRate.setCellValueFactory(new PropertyValueFactory<>("rate"));

        ProductTable.setItems(productList);

        ColProdID.setResizable(false);
        ColProdName.setResizable(false);
        ColProdPrice.setResizable(false);
        ColProdCategory.setResizable(false);
        ColProdBrand.setResizable(false);
        ColProdRate.setResizable(false);

        ProductTable.getColumns().forEach(column -> column.setReorderable(false));

        SpinnerValueFactory<Double> valueFactory = new SpinnerValueFactory.DoubleSpinnerValueFactory(0.0, 10000.0, 0.0, 0.1);
        txtProductPrice.setValueFactory(valueFactory);

        setname();
        SearchFilter();
        refreshFilteredList();
    }

    public static void setProduct() {
        if (!productList.isEmpty()) {
            return;
        }
        ProductsTest.makeproducts();
        ProductDAO productDAO = new ProductDAO();
        List<Product> products = productDAO.getAll();
        for (Product product : products) {
            productList.addAll(product);
        }
    }

    public TextField txtSearchbar;

    public void SearchFilter() {
        FilteredList<Product> filterData = new FilteredList<>(productList, p -> true);
        txtSearchbar.textProperty().addListener((observable, oldValue, newValue) -> {
            filterData.setPredicate(product -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (product.getName().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (product.getCategory().toString().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (product.getBrand().toString().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });

        SortedList<Product> sortedData = new SortedList<>(filterData);
        sortedData.comparatorProperty().bind(ProductTable.comparatorProperty());
        ProductTable.setItems(sortedData);
    }

    public void refreshFilteredList() {
        FilteredList<Product> filterData = new FilteredList<>(productList, p -> true);
        txtSearchbar.textProperty().addListener((observable, oldValue, newValue) -> {
            filterData.setPredicate(product -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (product.getName().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (product.getCategory().toString().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (product.getBrand().toString().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });

        SortedList<Product> sortedData = new SortedList<>(filterData);
        sortedData.comparatorProperty().bind(ProductTable.comparatorProperty());
        ProductTable.setItems(sortedData);
    }

    public void switchToAnotherScene2(ActionEvent event) throws IOException {
        SceneController sceneController = new SceneController();
        sceneController.SwitchToScene2(event);
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