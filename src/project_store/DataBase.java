package project_store;

import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class DataBase {

    private static Connection con;
    private static Statement stmt;

    public DataBase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/e-store?user=root&password=");
            stmt = con.createStatement();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    protected static int addItem(Item t) {
        int rowStatus = 0;
        String SQL = "INSERT INTO item(colNo,colName,colPrice,colQuntity,colCurrancy,colTotal,colURL)";
        SQL += " VALUES(" + t.getTxtNo() + ",'" + t.getTxtName() + "'," + t.getTxtPrice() + ","
                + t.getTxtQuntity() + "," + t.getComboCurrancy() + "," + t.getTxtTotal() + ",'" + t.getTxtURL() + "')";
        try {
            if (con != null && !con.isClosed()) {
                rowStatus = stmt.executeUpdate(SQL);
            } else {
                System.out.println("Error in Connection...");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rowStatus;
    }
   

    protected static int updateItem(Item t) {
        int rowStatus = 0;
        String SQL = "UPDATE item SET colName='" + t.getTxtName() + "',colPrice=" + t.getTxtPrice() + ",colQuntity =" + t.getTxtQuntity() + ","
                + "colCurrancy=" + t.getComboCurrancy() + "colTotal=" + t.getTxtTotal() + "colURL='" + t.getTxtURL() + "' WHERE colNo=" + t.getTxtNo() + "";
        try {
            if (con != null && !con.isClosed()) {
                rowStatus = stmt.executeUpdate(SQL);
            } else {
                System.out.println("Error in Connection...");
            }

        } catch (SQLException ex) {
        }
        return rowStatus;
    }

    protected static int deleteItem(int txtNo) {
        int rowStatus = 0;
        try {
            if (con != null && !con.isClosed()) {
                rowStatus = stmt.executeUpdate("DELETE FROM item WHERE colNo=" + txtNo + ";");
            } else {
                System.out.println("Error in Connection...");
            }

        } catch (SQLException ex) {
        }
        return rowStatus;
    }

    protected void getItem(String filter, TableView tb) {
        ObservableList<Item> items = FXCollections.observableArrayList();
        try {
            var r = stmt.executeQuery("SELECT * FROM item " + filter);
            while (r.next()) {

                Item item = new Item(
                        Integer.valueOf(r.getString("colNo")), r.getString("colName"), Integer.valueOf(r.getString("colPrice")),
                        Integer.valueOf(r.getString("colQuntity")), Integer.valueOf(r.getString("colCurrancy")),
                        Integer.valueOf(r.getString("colTotal")), r.getString("colURL"));
                items.add(item);
            }
        } catch (NumberFormatException | SQLException ex) {
            System.out.println(ex.getMessage());
        }

        tb.setItems(items);
    }
    
   protected static user getLogin(String name, String password) {
       
        user users = new user(0,null, null, null);
        try {
            if (con != null && !con.isClosed()) {
            ResultSet r = stmt.executeQuery("SELECT * FROM user WHERE username='" + name+"'AND password ='"+password);
            while (r.next()) {
                users.setPassword(r.getString("password"));
                users.setRole(r.getString("role"));
                users.setUsername(r.getString("username"));
            }
            }
            
           
        } catch (NumberFormatException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return users;
    }
    
    protected static Item getItemByNo(int txtNo) {
        Item st = new Item();
        try {
            var r = stmt.executeQuery("SELECT * FROM item WHERE colNo=" + txtNo);
            while (r.next()) {
                st.setTxtNo(Integer.valueOf(r.getString("colNo")));
                st.setTxtName(r.getString("colName"));
                st.setTxtPrice(Integer.valueOf(r.getString("colPrice")));
                st.setTxtQuntity(Integer.valueOf(r.getString("colQuntity")));
                st.setTxtTotal(Integer.valueOf(r.getString("colTotal")));
                st.setTxtURL(r.getString("colURL"));
            }
        } catch (NumberFormatException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return st;
    }

    private void closeConnection() {
        try {
            con.close();
        } catch (SQLException ex) {
        }
    }

}
