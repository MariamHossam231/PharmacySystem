package com.example.pharmacy;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class MedicinedetailsContoller {

    @FXML
    private TableView<Expiry> Tablelist;
    @FXML
    private TableColumn<Expiry,String> expired;

    private int flag1 =1;
    private int c1 =0;
    private int flag2 =1;

    private Parent root;
    private Scene scene;
    private Stage stage;


    ObservableList<Expiry> ViewList = FXCollections.observableArrayList() ;
    public void OnExpired(ActionEvent event) {
        expired.setText("Expired");
        expired.setCellValueFactory(new PropertyValueFactory<Expiry,String>("expired"));


        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/abasierydb", "root", "Abasiery@123");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from medicine");
            if (flag1 == 1 && c1 == 0) {
                while (rs.next()) {
                    String name ="";

                    if(rs.getDate("expiry_date").before(new Date())){
                        name= rs.getString("name");
                        ViewList.add(new Expiry(name));
                    }
                    c1=1;
                }
                Tablelist.setItems(ViewList);
            }else if(c1==1 ){
                Tablelist.setItems(ViewList);
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        flag1=0;
    }
    ObservableList<Expiry> ViewList2 = FXCollections.observableArrayList() ;
    public void onRanout(ActionEvent event) {
        expired.setCellValueFactory(new PropertyValueFactory<Expiry,String>("expired"));
        expired.setText("Ran out");
        Tablelist.setItems(ViewList2 );



        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/abasierydb", "root", "Abasiery@123");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from medicine");
            if (flag2 == 1) {
                while (rs.next()) {
                    String name ="";

                    if (rs.getInt("quantity")==0){
                        name= rs.getString("name");
                        ViewList2.add(new Expiry(name));
                    }
                    // ViewList.add(new Expiry(name1,name2));

                }
                Tablelist.setItems(ViewList2);
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        flag2=0;
    }

    public void onBack(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader= new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource("Medicines.fxml"));
        stage = (Stage) ((Node)event.getSource ()) .getScene () . getWindow();
        scene = new Scene(root);
        stage.setScene (scene) ;
        stage.show();
    }
}

