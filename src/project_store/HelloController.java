/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package project_store;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import static project_store.Estore.title;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class HelloController implements Initializable {

    @FXML
    private Label txtGust;
    @FXML
    private Button bt_why;
    @FXML
    private Button bt_admin;
    @FXML
    private Button bt_user;
    @FXML
    private TableView<Item> tblItem;
    @FXML
    private TableColumn<Item, Integer> colNo;
    @FXML
    private TableColumn<Item, String> colName;
    @FXML
    private TableColumn<Item, Integer> colPrice;
    @FXML
    private TableColumn<Item, Integer> colQuntity;
    @FXML
    private TableColumn<Item, Currancy> colCurrancy;
    @FXML
    private TableColumn<Item, Integer> colTotal;
    @FXML
    private TableColumn<Item, String> colURL;
    @FXML
    private TextField txtNo;
    @FXML
    private TextField txtQuntity;
    @FXML
    private TextField txtPrice;
    @FXML
    private TextField txtName;
    @FXML
    private ComboBox<Currancy> comboCurrancy;
    @FXML
    private TextField txtURL;
    @FXML
    private Button btnSer;
    @FXML
    private Label lblTotal;
    @FXML
    private Label txtTotal;
    @FXML
    private ImageView img;
    @FXML
    private Button btnimg;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnNew;

    String imagePath;
    DataBase DB;

    private void message(String header, String content) {
        Dialog d = new Dialog();
        d.setHeaderText(header);
        d.setTitle(title);
        d.setContentText(content);
        ButtonType btnOk = new ButtonType("موافق", ButtonBar.ButtonData.OK_DONE);
        d.getDialogPane().getButtonTypes().add(btnOk);
        d.showAndWait();
    }

    public static void exit() {
        Dialog d = new Dialog();
        d.setHeaderText("خروج من التطبيق...");
        d.setTitle(title);
        d.setContentText("هل تريد بالتأكيد الخروج من التطبيق؟");
        ButtonType btnYes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType btnNo = new ButtonType("No", ButtonBar.ButtonData.NO);
        d.getDialogPane().getButtonTypes().addAll(btnYes, btnNo);
        if (d.showAndWait().get() == btnYes) {
            Platform.exit();
        }
    }

    private void fillCurrancy() {
        ObservableList<Currancy> items = FXCollections.observableArrayList(
                new Currancy(1, "شيكل"), new Currancy(2, "دولار"), new Currancy(3, "دينار"));
        this.comboCurrancy.setItems(items);
    }

    private void fillTable() {
        colNo.setCellValueFactory(new PropertyValueFactory("txtNo"));
        colName.setCellValueFactory(new PropertyValueFactory("txtName"));
        colPrice.setCellValueFactory(new PropertyValueFactory("txtPrice"));
        colQuntity.setCellValueFactory(new PropertyValueFactory("txtQuntity"));
        colCurrancy.setCellValueFactory(new PropertyValueFactory("comboCurrancy"));
        colTotal.setCellValueFactory(new PropertyValueFactory("txtTotal"));
        colURL.setCellValueFactory(new PropertyValueFactory("txtURL"));
        DataBase DB = new DataBase();
        DB.getItem("", this.tblItem);
//WHERE Name LIKE %
    }

    private void newRecord() {
        this.txtNo.requestFocus();
        this.btnSave.setText("حفظ");
        this.btnDelete.setDisable(true);
        this.txtNo.setText(null);
        this.txtName.setText(null);
        this.txtPrice.setText(null);
        this.txtQuntity.setText(null);
        this.comboCurrancy.setValue(null);
        this.lblTotal.setText("0");
        this.txtURL.setText(null);
        this.img.setImage(null);

    }

    private boolean isValidation() {
        boolean temp = true;
        if (this.txtNo.getText().trim().length() == 0) {
            temp = false;
        }
        if (this.txtName.getText().trim().length() == 0) {
            temp = false;
        }
        if (this.txtPrice.getText().trim().length() == 0) {
            temp = false;
        }
        if (this.txtQuntity.getText().trim().length() == 0) {
            temp = false;
        }
        if (this.comboCurrancy.getValue() == null) {
            temp = false;
        }
        if (this.lblTotal.getText().trim().length() == 0) {
            temp = false;
        }
        if (this.txtURL.getText().trim().length() == 0) {
            temp = false;
        }
        return temp;
    }

    private int addRecord(Item item) {
        DB = new DataBase();//Create Connection
        return DB.addItem(item);
    }

    private int updateRecord(Item item) {
        DB = new DataBase();//Create Connection
        return DB.updateItem(item);
    }

    private void deleteRecord(int txtNo) {
        Dialog d = new Dialog();
        d.setHeaderText("حذف سجل...");
        d.setTitle(title);
        d.setContentText("هل تريد بالتأكيد حذف السجل؟");
        ButtonType btnYes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType btnNo = new ButtonType("No", ButtonBar.ButtonData.NO);
        d.getDialogPane().getButtonTypes().addAll(btnYes, btnNo);
        if (d.showAndWait().get() == btnYes) {
            DataBase DB = new DataBase();//Create Connection
            if (DataBase.deleteItem(txtNo) == 1) {
                message("حذف السجل", "تمت عملية الحذف بنجاح");
            }
        }
    }
//    
//       protected void getmassage(String massage){
//    this.txtGust.setText(massage);
//    
//    }
     

    public void handleMouseAction(MouseEvent event) {
        newRecord();
        Item st = this.tblItem.getSelectionModel().getSelectedItem();
        this.txtNo.setText(st.getTxtNo().toString());
        this.txtName.setText(st.getTxtName());
        this.btnSave.setText("تعديل");
        this.btnDelete.setDisable(false);
        fillTable();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fillCurrancy();
        fillTable();
        btnDelete.setDisable(true);
        btnSave.setOnAction((e) -> {
            if (isValidation()) {
                Item item = new Item();
                item.setTxtNo(Integer.valueOf(this.txtNo.getText().trim()));
                item.setTxtPrice(Integer.valueOf(this.txtPrice.getText().trim()));
                item.setTxtName(this.txtName.getText().trim());
                item.setTxtQuntity(Integer.valueOf(this.txtQuntity.getText().trim()));
                item.setTxtTotal(Integer.valueOf(this.txtQuntity.getText().trim()) * Integer.valueOf(this.txtPrice.getText().trim()));
                this.lblTotal.setText(item.getTxtTotal() + "");
                // item.setcomboCurrancy(this.comboCurrancy.getSelectionModel().getSelectedIndex() + 1); //Why not?
                item.setComboCurrancy(Integer.valueOf(this.comboCurrancy.getValue().toString().substring(0, 2)));
                item.setTxtURL(this.txtURL.getText());
                // item.set(imagePath);
                if (btnSave.getText().equals("حفظ")) {
                    if (addRecord(item) == 1) {
                        fillTable();
                        message("حفظ السجل", "تمت عملية الحفظ بنجاح");
                        this.btnSave.setText("تعديل");
                        this.btnDelete.setDisable(false);
                    }
                } else {
                    if (updateRecord(item) == 1) {
                        fillTable();
                        message("حفظ السجل", "تمت عملية التعديل بنجاح");
                        this.btnDelete.setDisable(false);
                    }
                }
            } else {
                message("خطأ في عملية الحفظ", "يوجد خانات فارغة يتطلب إدخال البيانات فيها لأكمال الحفظ");
            }
        });

        btnNew.setOnAction(e -> {
            newRecord();
        });

        btnimg.setOnAction((e) -> {

            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle(title);
            fileChooser.getExtensionFilters().add(new ExtensionFilter("Image Files", "*.png", "*.jpg"));
            File selectedFile = fileChooser.showOpenDialog(null);
            if (selectedFile != null) {
                imagePath = selectedFile.toURI().toString();
                img.setImage(new Image(imagePath));
            }
        });

        btnDelete.setOnAction((e) -> {
            if (this.txtNo.getText().trim().length() > 0) {
                int txtNo = Integer.valueOf(this.txtNo.getText().trim());
                if (txtNo > 0) {
                    deleteRecord(txtNo);
                    fillTable();
                    newRecord();
                }
            }
        });
        bt_why.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Stage stage = new Stage();
                try {
                    FXMLLoader loader = new FXMLLoader(HelloController.this.getClass().getResource("about.fxml"));
                    Parent root = loader.load();

                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });

        bt_user.setOnAction(e -> {

            Stage stage = new Stage();
            try {
                FXMLLoader loader = new FXMLLoader(HelloController.this.getClass().getResource("user.fxml"));
                Parent root = loader.load();

                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });

        bt_admin.setOnAction(e -> {

            Stage stage = new Stage();
            try {
                FXMLLoader loader = new FXMLLoader(HelloController.this.getClass().getResource("admin.fxml"));
                Parent root = loader.load();

                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException ex) {
                 ex.printStackTrace();
            }

        });

        btnSer.setOnAction((e) -> {
            TextInputDialog td = new TextInputDialog();
            td.setHeaderText("بحث عن منتج ");
            td.setTitle(title);
            td.setContentText("ادخل رقم المنتج");
            td.showAndWait();
            String stNo1 = td.getEditor().getText().toString();
            if (stNo1.length() > 0) {
                int txtNo = Integer.valueOf(td.getEditor().getText());
                Item item = new Item();
                item = DataBase.getItemByNo(txtNo);

                this.txtName.setText(item.getTxtName());
                this.txtNo.setText(item.getTxtNo().toString());
                this.txtPrice.setText(item.getTxtPrice().toString());
                this.txtQuntity.setText(item.getTxtQuntity().toString());
                this.lblTotal.setText(item.getTxtTotal().toString());
                this.txtURL.setText(item.getTxtURL().toString());
                this.btnDelete.setDisable(false);
                this.btnSave.setText("تعديل");
            }
        });
    

    }
}
