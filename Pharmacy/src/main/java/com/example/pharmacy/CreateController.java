package com.example.pharmacy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class CreateController {
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TextField phone;
    @FXML
    private TextField address;
    @FXML
    private TextField age;
    @FXML
    private Button createnew;
    @FXML
    private Button toshopping;
    @FXML
    private Label warning;


    private Parent root;
    private Scene scene;
    private Stage stage;

    public void onbutton(ActionEvent event)  {
        if(username.getText()=="" || password.getText()=="" || phone.getText()=="" || address.getText()=="" || age.getText()==""){
            warning.setText("Fill the missing requirments");
        }
        else {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/abasierydb", "root", "Abasiery@123");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from customers");
                String sql = " insert into customers (username, paasword, phone, address, age)"
                        + " values (?, ?, ?, ?, ?)";

                PreparedStatement preparedStmt = con.prepareStatement(sql);
                preparedStmt.setString(1, username.getText()); //username
                preparedStmt.setString(2, password.getText()); //password
                preparedStmt.setString(3, phone.getText()); //phone
                preparedStmt.setString(4, address.getText()); //address
                preparedStmt.setInt(5, Integer.parseInt(age.getText().toString())); //age

                preparedStmt.execute();

                con.close();

            } catch (Exception e) {
                System.out.println(e);
            }
            toshopping.setVisible(true);
        }

    }

    public void ToShoppingCart(ActionEvent event)throws IOException {
        FXMLLoader fxmlLoader= new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource("ShoppingCart.fxml"));
        stage = (Stage) ((Node)event.getSource ()) .getScene () . getWindow();
        scene = new Scene(root);
        stage.setScene (scene) ;
        stage.show();

    }

    public void onBack(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader= new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node)event.getSource ()) .getScene () . getWindow();
        scene = new Scene(root);
        stage.setScene (scene) ;
        stage.show();
    }
}
