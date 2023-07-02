package com.example.pharmacy;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class WorksController {

    @FXML
    private Button search;
    @FXML
    private TextField textfield;
    @FXML
    private TableView<Workers> Tablelist;
    @FXML
    private TableColumn<Workers,Integer> id;
    @FXML
    private TableColumn <Workers,String>name;
    @FXML
    private TableColumn <Workers,Integer>salary;
    @FXML
    private TableColumn <Workers,Integer>workinghours;

    private int flag =1;
    private int flag1 =1;
    ObservableList<Workers> ViewList = FXCollections.observableArrayList() ;
    ObservableList<Workers> ViewList1 = FXCollections.observableArrayList() ;


    private Parent root;
    private Scene scene;
    private Stage stage;

    public void onbutton(ActionEvent event) {
        search.setVisible(true);
        id.setCellValueFactory(new PropertyValueFactory<Workers,Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<Workers,String>("name"));
        salary.setCellValueFactory(new PropertyValueFactory<Workers,Integer>("salary"));
        workinghours.setCellValueFactory(new PropertyValueFactory<Workers,Integer>("workinghours"));


        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/abasierydb", "root", "Abasiery@123");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from workers");
            if (flag == 1 && flag1 ==1) {
                while (rs.next()) {
                    int Id = rs.getInt("id");
                    String Name= rs.getString("name");
                    int Salary = rs.getInt("salary");
                    int Workinghours = rs.getInt("workinghours");
                    ViewList.add(new Workers(Id,Name,Salary,Workinghours));
                }

            }
            Tablelist.setItems(ViewList);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        flag = 0;
    }

    public void onBack(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader= new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource("AdminFunction.fxml"));
        stage = (Stage) ((Node)event.getSource ()) .getScene () . getWindow();
        scene = new Scene(root);
        stage.setScene (scene) ;
        stage.show();
    }

    public void onSearch(ActionEvent event) throws SQLException {
        id.setCellValueFactory(new PropertyValueFactory<Workers,Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<Workers,String>("name"));
        salary.setCellValueFactory(new PropertyValueFactory<Workers,Integer>("salary"));
        workinghours.setCellValueFactory(new PropertyValueFactory<Workers,Integer>("workinghours"));
        ViewList1=SearchController.searchWorkers(textfield.getText().toString(),"name");
        Tablelist.setItems(ViewList1);
        flag1 =0 ;
    }
}
