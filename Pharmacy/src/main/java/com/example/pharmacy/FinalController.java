package com.example.pharmacy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FinalController {

    @FXML
    Button Star1;
    @FXML
    Button Star2;
    @FXML
    Button Star3;
    @FXML
    Button Star4;
    @FXML
    Button Star5;

    Stage stage;

    public void OnStar1(ActionEvent actionEvent) {
        Star1.setTextFill(Color.YELLOW);
        Star2.setTextFill(Color.WHITE);
        Star3.setTextFill(Color.WHITE);
        Star4.setTextFill(Color.WHITE);
        Star5.setTextFill(Color.WHITE);
    }

    public void OnStar2(ActionEvent actionEvent) {
        Star1.setTextFill(Color.YELLOW);
        Star2.setTextFill(Color.YELLOW);
        Star3.setTextFill(Color.WHITE);
        Star4.setTextFill(Color.WHITE);
        Star5.setTextFill(Color.WHITE);
    }

    public void OnStar3(ActionEvent actionEvent) {
        Star1.setTextFill(Color.YELLOW);
        Star2.setTextFill(Color.YELLOW);
        Star3.setTextFill(Color.YELLOW);
        Star4.setTextFill(Color.WHITE);
        Star5.setTextFill(Color.WHITE);
    }

    public void OnStar4(ActionEvent actionEvent) {
        Star1.setTextFill(Color.YELLOW);
        Star2.setTextFill(Color.YELLOW);
        Star3.setTextFill(Color.YELLOW);
        Star4.setTextFill(Color.YELLOW);
        Star5.setTextFill(Color.WHITE);
    }

    public void OnStar5(ActionEvent actionEvent) {
        Star1.setTextFill(Color.YELLOW);
        Star2.setTextFill(Color.YELLOW);
        Star3.setTextFill(Color.YELLOW);
        Star4.setTextFill(Color.YELLOW);
        Star5.setTextFill(Color.YELLOW);
    }

    public void onExit(ActionEvent event) {
        stage = (Stage) ((Node)event.getSource ()) .getScene () . getWindow();
        stage.close();
    }
}
