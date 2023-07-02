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
import java.sql.SQLException;


public class LoginController {
@FXML
private TextField usernametxt;
@FXML
private TextField passwordtxt;
@FXML
private Label wrong;
    private Scene scene;
    private Stage stage;
    public void onLogin(ActionEvent event) throws SQLException, IOException {
        String name =usernametxt.getText();
        String password =passwordtxt.getText();
        if(SearchController.verifyadmin(name,password)== true && name!="" && password!=""){
            FXMLLoader fxmlLoader= new FXMLLoader();
            Parent root = fxmlLoader.load(getClass().getResource("ShoppingCart.fxml"));
            stage = (Stage) ((Node)event.getSource ()) .getScene () . getWindow();
            scene = new Scene(root);
            stage.setScene (scene) ;
            stage.show();
        }
        else{
            wrong.setText("Wrong Username or Password!");
        }
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
