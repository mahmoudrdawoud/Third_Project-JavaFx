package project_store;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Estore extends Application {

    public static String title = "E-Store";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Login.fxml"))));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        stage.setResizable(false);
        stage.setTitle(title);
        stage.setMaximized(false);
        stage.show();
    }

}
