package Frontend.controllers.order;

import Backend.dao.CategoryDAO;
import Backend.dao.OrderDAO;
import Backend.entity.Category;
import Backend.entity.Customer;
import Backend.entity.Enum.Brand;
import Backend.entity.Enum.Gender;
import Backend.entity.Order;
import Backend.entity.Product;
import Backend.service.OrderService;
import Frontend.controllers.cart.CartController;
import Frontend.controllers.product.PcardC;
import Frontend.controllers.product.ProductmenuController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import run.project_ms2.SceneController;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class OrderHistoryController implements Initializable {

    @FXML
    private GridPane PContainer;
    @FXML
    private Label OrderNumber;
    @FXML
    private ScrollPane Container;
    @FXML
    private VBox List;
    @FXML
    private Label total;

    @FXML
    private Label Pname;

    private static Customer customer;

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

    private List<Order> Orders;

    @Override
    public void initialize(URL location, ResourceBundle resources)  {
        OrderNumber.setWrapText(true);
        total.setWrapText(true);
        System.out.println("The Order History Page");
        OrderNumber.setPrefWidth(200);
        List.getChildren().add(new Separator());
        setname();

        OrderService orderService = new OrderService();
        Orders = orderService.getOrdersByCustomerId(customer.getId());


        for (Order order : Orders) {
            System.out.println( order.getProducts().size());
            Button button = new Button("Order "+order.getOrderId());
            button.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");
            button.setOnMouseEntered(e -> {
                button.setStyle("-fx-background-color: rgba(0, 0, 0, 0.1);"); // Light gray when hovering
            });
            button.setOnMouseExited(e -> {
                button.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");
            });
            button.setPrefWidth(190);
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    OrderNumber.setText("Viewing Order "+order.getOrderId());
                    total.setText("The total is "+ String.format("%.2f", order.getTotalAmount()));
                    initiate(order);
                }
            });

            if(List!=null) {
                System.out.println("VBox found!");
                List.getChildren().add(button);
                List.getChildren().add(new Separator());
                button.paddingProperty().set(new Insets(10,10,10,10));

            }
        }
    }
    public void initiate(Order O){
        PContainer.getChildren().clear();
        List<Card2> recentlyAdded= new ArrayList<>(GetCards(O));
        int column = 0;
        int row = 1;
        try{
            for (Card2 card : recentlyAdded){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/run/project_ms2/Frontend/pages/order/Ocard.fxml"));
                VBox cardbox = fxmlLoader.load();
                Card2Controller cardController = fxmlLoader.getController();
                cardController.setdata(card);
                if(column==1){
                    column=0;
                    ++row;
                }
                PContainer.add(cardbox,column++,row);
                GridPane.setMargin(cardbox,new Insets(10));
            }
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Failed to load Card2fx.fxml!");
        }
    }
    private List<Card2> GetCards(Order O){
        List<Card2> cards = new ArrayList<>();
        for(Product product: O.getProducts()){
            Card2 card = new Card2(product.getName(),
                                Double.toString(product.getPrice()),
                                Double.toString(product.getRate()),
                                product.getBrand().toString(),
                         "/run/project_ms2/Frontend/images/pimages/" + product.getId() + ".jpg");
            cards.add(card);
        }

        return cards;
    }
    private List<Order> recentlyAddedOrders(){
        ArrayList<Order> Orders = new ArrayList<>();
        Category category1 = new Category("Apple");
        Category category2 = new Category("Tablets");
        Category category3 = new Category("Laptops");
        Category category4 = new Category("PC");
        Category category5 = new Category("Accessories");

        CategoryDAO categoryDAO = new CategoryDAO();
        categoryDAO.add(category1);
        categoryDAO.add(category2);
        categoryDAO.add(category3);
        categoryDAO.add(category4);
        categoryDAO.add(category5);

        // Create the first ArrayList of products
        ArrayList<Product> apple = new ArrayList<>();
        apple.add(new Product("IPhone 12", 799.99, category1, Brand.Apple, 4.5));
        apple.add(new Product("IPhone 13", 799.99, category1, Brand.Apple, 4.5));
        apple.add(new Product("IPhone 14", 799.99, category1, Brand.Apple, 4.5));
        apple.add(new Product("IPhone 16", 999.99, category1, Brand.Apple, 4.5));
        Order order1=new Order();
        order1.setProducts(apple);

        // Create the second ArrayList of products
        ArrayList<Product> samsung = new ArrayList<>();
        samsung.add(new Product("Galaxy S24 Ultra", 1999.99, category1, Brand.Samsung, 4.4));
        samsung.add(new Product("Galaxy Fold 6", 699.99, category2, Brand.Samsung, 4.4));
        samsung.add(new Product("Galaxy Z Flip 6", 699.99, category2, Brand.Samsung, 4.4));
        samsung.add(new Product("Galaxy Tab S9 FE+", 699.99, category2, Brand.Samsung, 4.5));
        samsung.add(new Product("Samsung Buds 2", 99.99, category5, Brand.Samsung, 4.5));
        Order order2 =new Order();
        order2.setProducts(samsung);

        // Create the third ArrayList of products
        ArrayList<Product> HP = new ArrayList<>();
        HP.add(new Product("HP Pavilion", 1199.99, category3, Brand.HP, 4.5));
        HP.add(new Product("HP Victus", 499.99, category3, Brand.HP, 4.3));
        Order order3=new Order();
        order3.setProducts(HP);

        // Create the fourth ArrayList of products
        ArrayList<Product> Microsoft = new ArrayList<>();
        Microsoft.add(new Product("Microsoft Surface Pro 6", 1299.99, category3, Brand.Microsoft, 4.7));
        Microsoft.add(new Product("Microsoft Surface Pro 7", 199.99, category3, Brand.Microsoft, 4.4));
        Order order4 = new Order();
        order4.setProducts(Microsoft);

        // Create the fifth ArrayList of products
        ArrayList<Product> combo = new ArrayList<>();
        combo.add(new Product("Iphone 12", 799.99, category1, Brand.Apple, 4.5));
        combo.add(new Product("Iphone 13", 799.99, category1, Brand.Apple, 4.5));
        combo.add(new Product("Galaxy Tab S9 FE+", 699.99, category2, Brand.Samsung, 4.5));
        combo.add(new Product("Microsoft Surface Pro 7", 199.99, category3, Brand.Microsoft, 4.4));
        Order order5 =new Order();
        order5.setProducts(combo);

        Orders.add(order1);
        Orders.add(order2);
        Orders.add(order3);
        Orders.add(order4);
        Orders.add(order5);

        return Orders;
    }

    public void switchToAnotherScene4(ActionEvent event) throws IOException {
        SceneController sceneController = new SceneController();
        ProductmenuController.setCustomer(customer);
        sceneController.SwitchToScene4(event);
    }
    public void switchToAnotherScene7(ActionEvent event) throws IOException {
        SceneController sceneController = new SceneController();
        sceneController.SwitchToScene7(event);
    }
    public void switchToAnotherScene5(ActionEvent event) throws IOException {
        SceneController sceneController = new SceneController();
        CartController.setCustomer(customer);
        sceneController.SwitchToScene5(event);
    }

}
