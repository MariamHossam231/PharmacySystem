package com.example.pharmacy;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EmptyController {

    Parent root;
    Scene scene;
    Stage stage;

    public void OnShopping(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader= new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource("ShoppingCart.fxml"));
        stage = (Stage) ((Node)event.getSource ()) .getScene () . getWindow();
        scene = new Scene(root);
        stage.setScene (scene) ;
        stage.show();
    }


    public void OnExit(ActionEvent event) {
        stage = (Stage) ((Node)event.getSource ()) .getScene () . getWindow();
        stage.close();
    }
}
