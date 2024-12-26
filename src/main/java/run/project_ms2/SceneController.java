package run.project_ms2;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;

public class SceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void SwitchToScene1(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/run/project_ms2/Frontend/pages/admin/ProductsForm.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1280, 700);

        stage.setScene(scene);
        stage.show();
    }//ProductsForm
    public void SwitchToScene2(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/run/project_ms2/Frontend/pages/admin/OrdersForm.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1280, 700);

        stage.setScene(scene);
        stage.show();
    }//OrdersForm
    public void SwitchToScene3(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/run/project_ms2/Frontend/pages/admin/CustomersForm.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1280, 700);

        stage.setScene(scene);
        stage.show();
    }//CustomersForm
    public void SwitchToScene4(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/run/project_ms2/Frontend/pages/product/Productmenu.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1280, 700);

        stage.setScene(scene);
        stage.show();
    }//Productmenu
    public void SwitchToScene5(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/run/project_ms2/Frontend/pages/cart/cart.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1280, 700);

        stage.setScene(scene);
        stage.show();
    }//cart
    public void SwitchToScene6(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/run/project_ms2/Frontend/pages/order/OrderHistory.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1280, 700);

        stage.setScene(scene);
        stage.show();
    }//OrderHistory
    public void SwitchToScene7(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/run/project_ms2/Frontend/pages/authentication/LoginPage.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1280, 700);

        stage.setScene(scene);
        stage.show();
    }//LoginPage
    public void SwitchToScene8(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/run/project_ms2/Frontend/pages/authentication/SignUpPage.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1280, 700);

        stage.setScene(scene);
        stage.show();
    }//SignUpPage
    public void SwitchToScene9(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/run/project_ms2/Frontend/pages/authentication/SignUpPage1.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1280, 700);

        stage.setScene(scene);
        stage.show();
    }//SignUpPage1
    public void SwitchToScene10(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/run/project_ms2/Frontend/pages/authentication/SignUpAddress.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1280, 700);

        stage.setScene(scene);
        stage.show();
    }//SignUpAddress
    public void SwitchToScene11(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/run/project_ms2/Frontend/pages/authentication/ForgotPass.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1280, 700);

        stage.setScene(scene);
        stage.show();
    }//ForgotPassword
    public void switchToScene(ActionEvent event, Parent root) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
