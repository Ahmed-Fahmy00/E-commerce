package Frontend.controllers.product;

import Backend.entity.Cart;
import Backend.entity.Customer;
import Backend.service.CartService;
import Backend.service.ProductService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.InputStream;

public class CardController {
    @FXML
    private VBox cardbox;

    @FXML
    private ImageView cardimage;

    @FXML
    private Label cardinfo;

    @FXML
    private Label cardname;

    @FXML
    private Label cardprice;

    @FXML
    private Label cardrate;


    private int id;
    private static Customer customer;
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void addtocart() {
        CartService cartService = new CartService();
        cartService.addToCart(id,customer);

    }

    public void setdata(PcardC card,Customer c) {
        InputStream stream = getClass().getResourceAsStream(card.getImage());
        if (stream == null) {
            throw new IllegalArgumentException("Resource not found: " + card.getImage());
        }
        Image image = new Image(stream);
        customer = c;
        id = card.getId();
        cardimage.setImage(image);
        cardname.setText(card.getName());
        cardprice.setText(String.format("%.2f", card.getPrice()));
        cardrate.setText(String.format("%.2f", card.getRate()));
        cardinfo.setText(card.getInfo());
    }

}
