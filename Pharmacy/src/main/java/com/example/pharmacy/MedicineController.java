package com.example.pharmacy;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class MedicineController {
    @FXML
    private TableView<Medicine> Table;
    @FXML
    private TableColumn<Medicine,String> name;
    @FXML
    private TableColumn<Medicine,Float> price;
    @FXML
    private TableColumn<Medicine,Integer> quantaty;
    @FXML
    private TableColumn<Medicine,String> description;
    @FXML
    private TableColumn<Medicine, Date> date;
    @FXML
    private Button searchtxt;
    @FXML
    private TextField textfield;
    private int flag = 1;
    private int flag1 = 1;

    ObservableList<Medicine> list = FXCollections.observableArrayList() ;
    ObservableList<Medicine> list1 = FXCollections.observableArrayList() ;
    private Parent root;
    private Scene scene;
    private Stage stage;

    public void onNext(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader= new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource("Medicinedetails.fxml"));
        stage = (Stage) ((Node)event.getSource ()) .getScene () . getWindow();
        scene = new Scene(root);
        stage.setScene (scene) ;
        stage.show();
    }

    public void onBack(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader= new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource("AdminFunction.fxml"));
        stage = (Stage) ((Node)event.getSource ()) .getScene () . getWindow();
        scene = new Scene(root);
        stage.setScene (scene) ;
        stage.show();
    }

    public void onShowInfo(ActionEvent event) {
        searchtxt.setVisible(true);
        name.setCellValueFactory(new PropertyValueFactory<Medicine,String>("name"));
        price.setCellValueFactory(new PropertyValueFactory<Medicine,Float>("price"));
        quantaty.setCellValueFactory(new PropertyValueFactory<Medicine,Integer>("quantity"));
        description.setCellValueFactory(new PropertyValueFactory<Medicine,String>("Description"));
        date.setCellValueFactory(new PropertyValueFactory<Medicine,Date>("ExpiryDate"));

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/abasierydb", "root", "Abasiery@123");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from medicine");
            if (flag == 1 && flag1 ==1) {

                while (rs.next()) {

                    list.add(new Medicine(rs.getString("name"), rs.getFloat("price"), rs.getString("description"), rs.getDate("expiry_date"), "Lebos", rs.getInt("quantity"), rs.getInt("id")));

                }

            }
            Table.setItems(list);
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        flag = 0;
    }

    public void onSearch(ActionEvent event) throws SQLException {
        name.setCellValueFactory(new PropertyValueFactory<Medicine,String>("name"));
        price.setCellValueFactory(new PropertyValueFactory<Medicine,Float>("price"));
        quantaty.setCellValueFactory(new PropertyValueFactory<Medicine,Integer>("quantity"));
        description.setCellValueFactory(new PropertyValueFactory<Medicine,String>("Description"));
        date.setCellValueFactory(new PropertyValueFactory<Medicine,Date>("ExpiryDate"));
        list1=SearchController.searchUsers(textfield.getText().toString(),"name");
        Table.setItems(list1);
        flag1 =0 ;
    }
}

