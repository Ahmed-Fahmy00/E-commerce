package run.project_ms2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tests.AdminTest;
import tests.Customertestdata;
import tests.ProductsTest;

import java.io.IOException;

public class Ecommerce extends Application {
        @Override
        public void start(Stage stage) throws IOException {
            ProductsTest.makeproducts();
            Customertestdata.makeCustomers();
            AdminTest.makeAdmins();

            FXMLLoader fxmlLoader = new FXMLLoader(Ecommerce.class.getResource("Frontend/pages/authentication/LoginPage.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();
        }

        public static void main(String[] args) {
            launch();
        }
}