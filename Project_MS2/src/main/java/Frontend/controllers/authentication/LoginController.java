package Frontend.controllers.authentication;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController {
    @FXML
    private Circle myCircle;

    private Stage stage;
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void initialize(URL url, ResourceBundle rb) {

        URL imageUrl = getClass().getResource("/com/example/login/LOGO.jfif");
        System.out.println(imageUrl); // Should not be null

        // Load the image
        Image img = new Image(getClass().getResource("/com/example/login/LOGO.jfif").toExternalForm());
        myCircle.setFill(new ImagePattern(img));
    }

}