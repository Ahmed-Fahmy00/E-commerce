package Frontend.controllers.product;

import Backend.dao.CustomerDAO;
import Backend.entity.Customer;
import Backend.entity.Enum.Gender;
import Backend.entity.Product;
import Backend.service.CustomerService;
import Backend.service.ProductService;
import Frontend.controllers.cart.CartController;
import Frontend.controllers.order.OrderHistoryController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import run.project_ms2.SceneController;
import tests.Customertestdata;
import tests.ProductsTest;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class ProductmenuController implements Initializable {

    @FXML
    private GridPane PContainer;

    @FXML
    private TextField Searchbar;

    @FXML
    private CheckBox Clabtop;
    @FXML
    private CheckBox Cpc;
    @FXML
    private CheckBox Cphones;
    @FXML
    private CheckBox Ctablet;
    @FXML
    private CheckBox Cacc;

    @FXML
    private CheckBox Bapple;
    @FXML
    private CheckBox Bhp;
    @FXML
    private CheckBox Bmicrosoft;
    @FXML
    private CheckBox Bsamsung;

    @FXML
    private TextField maxprice;
    @FXML
    private TextField minprice;

    @FXML
    private Label Pname;

    private static Customer customer;
    private List<PcardC> wantedcards;

    public static void setCustomer(Customer cust) {
        customer = cust;
        System.out.println("Customer set to: " + (cust != null ? cust.getUsername() : "null"));
    }

    public void setname() {
        if (Pname != null) {
            if (customer == null) {
                customer = new Customer("Guest", "", "guest", "guest@example.com", Gender.OTHER, "", "", "", "", new Date());
                System.err.println("No customer set. Using default guest customer.");
            }
            Pname.setText("Welcome, " + customer.getUsername() + "!");
            System.out.println("Label set to: " + Pname.getText());
        } else {
            System.err.println("Pname label is not initialized yet.");
        }
    }

    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if (customer == null) {
            System.err.println("Customer is not set. Ensure it's passed during login.");
            customer = new Customer("Guest", "", "guest", "guest@example.com", Gender.OTHER, "", "", "", "", new Date());
        }
        setname();
        setupListeners();
        makeGrid();
    }

    public void makeGrid() {
        PContainer.getChildren().clear();
        wantedcards = new ArrayList<>(Mackcards());
        int column = 0;
        int row = 1;

        try {
            for (PcardC card : wantedcards) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/run/project_ms2/Frontend/pages/product/Pcard.fxml"));
                VBox cardbox = fxmlLoader.load();
                CardController cardController = fxmlLoader.getController();
                cardController.setdata(card,customer);
                if (column == 4) {
                    column = 0;
                    ++row;
                }
                PContainer.add(cardbox, column++, row);
                GridPane.setMargin(cardbox, new Insets(10)); // Add spacing
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading Pcard.fxml: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Unexpected error in makeGrid: " + e.getMessage());
        }
    }

    public List<PcardC> Mackcards() {
        List<PcardC> cards = new ArrayList<>();
        ProductService productService = new ProductService();
        List<Product> products = productService.getwantedproducts(getsearch(), getcategories(), getbrands(), getprice());
        for (Product product : products) {
            PcardC card = new PcardC();
            card.setId(product.getId());
            card.setName(product.getName());
            card.setPrice(product.getPrice());
            card.setRate(product.getRate());
            card.setInfo("Category:"+product.getCategory().getName() +"Brand:"+product.getBrand());
            card.setImage("/run/project_ms2/Frontend/images/pimages/"+ Integer.toString(product.getId())+".jpg");
            cards.add(card);
        }

        return cards;
    }

    public void setupListeners() {
        // Add listeners for dynamic updates
        Searchbar.setOnKeyReleased(event -> makeGrid());
        Clabtop.setOnAction(event -> makeGrid());
        Cpc.setOnAction(event -> makeGrid());
        Cphones.setOnAction(event -> makeGrid());
        Ctablet.setOnAction(event -> makeGrid());
        Cacc.setOnAction(event -> makeGrid());
        Bapple.setOnAction(event -> makeGrid());
        Bhp.setOnAction(event -> makeGrid());
        Bmicrosoft.setOnAction(event -> makeGrid());
        Bsamsung.setOnAction(event -> makeGrid());
        maxprice.setOnKeyReleased(event -> makeGrid());
        minprice.setOnKeyReleased(event -> makeGrid());
    }

    private String getsearch() {
        return Searchbar.getText();
    }
    private List<String> getcategories() {
        List<String> categories = new ArrayList<>();
        if (Clabtop.isSelected()) categories.add("Laptops");
        if (Cpc.isSelected()) categories.add("PC");
        if (Cphones.isSelected()) categories.add("Phones");
        if (Ctablet.isSelected()) categories.add("Tablets");
        if (Cacc.isSelected()) categories.add("Accessories");
        return categories;
    }
    private List<String> getbrands() {
        List<String> brands = new ArrayList<>();
        if (Bapple.isSelected()) brands.add("Apple");
        if (Bhp.isSelected()) brands.add("HP");
        if (Bmicrosoft.isSelected()) brands.add("Microsoft");
        if (Bsamsung.isSelected()) brands.add("Samsung");
        return brands;
    }
    private double[] getprice() {
        double[] prices = {0.0, 10000.0};
        try {
            double min = Double.parseDouble(minprice.getText().trim());
            if (min >= 0 && min <= 10000) {
                prices[0] = min;
            }
        } catch (NumberFormatException ignored) {
            minprice.setText("0");
        }
        try {
            double max = Double.parseDouble(maxprice.getText().trim());
            if (max >= 0 && max <= 10000) {
                prices[1] = max;
            }
        } catch (NumberFormatException ignored) {
            maxprice.setText("10000");
        }
        return prices;
    }

    public void switchToAnotherScene5(ActionEvent event) throws IOException {
        SceneController sceneController = new SceneController();
        CartController.setCustomer(customer);
        sceneController.SwitchToScene5(event);
    }
    public void switchToAnotherScene6(ActionEvent event) throws IOException {
        SceneController sceneController = new SceneController();
        OrderHistoryController.setCustomer(customer);
        sceneController.SwitchToScene6(event);
    }

    public void switchToAnotherScene7(ActionEvent event) throws IOException {
        SceneController sceneController = new SceneController();
        sceneController.SwitchToScene7(event);
    }

}







