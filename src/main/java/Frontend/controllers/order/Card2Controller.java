package Frontend.controllers.order;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class Card2Controller implements Initializable {
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cardname.setPrefWidth(370);
        cardinfo.setPrefWidth(370);
        cardinfo.setWrapText(true);
    }
    public void setdata(Card2 card) {
        final String color = "#f5f5f5";
        InputStream stream = getClass().getResourceAsStream(card.getImage());
        if (stream == null) {
            throw new IllegalArgumentException("Resource not found: " + card.getImage());
        }
        Image image = new Image(stream);
        cardimage.setImage(image);
        cardname.setText(card.getName());
        cardprice.setText(card.getPrice());
        cardrate.setText(card.getRate());
        cardinfo.setText(card.getInfo());
        cardbox.setStyle("-fx-background-color: " + color + ";" +
                "-fx-background-radius: 15px;" +
                "-fx-effect: dropShadow(three-pass-box,rgba(0,0,0,0),10,0,0,10);");
    }
}