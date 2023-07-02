package com.example.pharmacy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloController {
    @FXML
    private Button admin;

    private Parent root;
    private Scene scene;
    private Stage stage;




    @FXML
    protected void onHelloButtonClick(ActionEvent event) throws IOException {


        FXMLLoader fxmlLoader= new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource("Adminform.fxml"));
        stage = (Stage) ((Node)event.getSource ()) .getScene () . getWindow();
        scene = new Scene(root);
        stage.setScene (scene) ;
        stage.show();
        //close the another form

    }

    public void onCreate(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader= new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource("Creatnew.fxml"));
        stage = (Stage) ((Node)event.getSource ()) .getScene () . getWindow();
        scene = new Scene(root);
        stage.setScene (scene) ;
        stage.show();
    }

    public void onLogin(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader= new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage) ((Node)event.getSource ()) .getScene () . getWindow();
        scene = new Scene(root);
        stage.setScene (scene) ;
        stage.show();
    }
}