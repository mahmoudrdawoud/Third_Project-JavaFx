package project_store;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;

public class UserController implements Initializable {

    @FXML
    private TextField newPassword;
    @FXML
    private TextField currentPassword;
    @FXML
    private Button btnSavePassword;
    @FXML
    private Button btnCancle;
    @FXML
    private TextField confirmPasswordUser;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void save(ActionEvent event) {
    }

    @FXML
    private void cancle(ActionEvent event) {

        Dialog d = new Dialog();
        d.setHeaderText("خروج من الواجهه...");
        d.setTitle(Estore.title);
        d.setContentText("هل تريد بالتأكيد الخروج من الواجهه؟");
        ButtonType btnYes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType btnNo = new ButtonType("No", ButtonBar.ButtonData.NO);
        d.getDialogPane().getButtonTypes().addAll(btnYes, btnNo);
        if (d.showAndWait().get() == btnYes) {
            Platform.exit();
        }
    }
}
