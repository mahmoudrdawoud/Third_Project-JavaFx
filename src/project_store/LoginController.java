package project_store;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class LoginController implements Initializable {

    @FXML
    private TextField passLog;
    @FXML
    private TextField nameLog;
    @FXML
    private Button btnLog;
    @FXML
    private Button btnCancle;

    public static Connection con;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void login(ActionEvent event) throws IOException {

        if (nameLog.getText().isEmpty()) {
            System.out.println("Please Enter Username");
        }
        if (passLog.getText().isEmpty()) {
             System.out.println("Please Enter Password");
        }

        if ((nameLog.getText().equalsIgnoreCase("admin") && passLog.getText().equalsIgnoreCase("0000")) || (nameLog.getText().equalsIgnoreCase("user") && passLog.getText().equalsIgnoreCase("2222"))) {

            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("hello.fxml"));
            Parent root = loader.load();
            stage.setScene(new Scene(root));
            stage.show();

        } else {
            JOptionPane.showMessageDialog(null, " The user name or password is wrong", "ERROR MESSAGE ", JOptionPane.PLAIN_MESSAGE);
        }
    }

    @FXML
    private void cancle(ActionEvent event) {
        Dialog d = new Dialog();
        d.setHeaderText("خروج من التطبيق...");
        d.setTitle(Estore.title);
        d.setContentText("هل تريد بالتأكيد الخروج من التطبيق؟");
        ButtonType btnYes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType btnNo = new ButtonType("No", ButtonBar.ButtonData.NO);
        d.getDialogPane().getButtonTypes().addAll(btnYes, btnNo);
        if (d.showAndWait().get() == btnYes) {
            Platform.exit();
        }
    }

}






