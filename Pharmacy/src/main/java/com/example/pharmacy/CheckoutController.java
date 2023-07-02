package com.example.pharmacy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class CheckoutController extends ShoppingCartController implements Initializable {

    @FXML
    Label Order;

    @FXML
    Label text;

    @FXML
    Label Warning;

    @FXML
    Label TotalPrice;

    @FXML
    ChoiceBox<String> Payment;

    private String[] choices = {"Cash", "Credit Card"};
   // ObservableList<String> List = FXCollections.observableArrayList("Cash","Credit Card");
   // Payment.setItems(List);


    String s ="";
    Parent root;
    Scene scene;
    Stage stage;

    public void OnShowDetails(ActionEvent actionEvent) {
        if(SaveData.saveA!=0){s = "X" + SaveData.saveA + " Voltaren\n";}
        if(SaveData.saveB!=0){s = s + "X" + SaveData.saveB + " panadol\n";}
        if(SaveData.saveC!=0){s = s + "X" + SaveData.saveC + " augmentin\n";}
        if(SaveData.saveD!=0){s = s +"X" + SaveData.saveD + " antibiotic\n";}
        if(SaveData.saveE!=0){s = s +"X" + SaveData.saveE + " claritine\n";}
        if(SaveData.saveF!=0){s = s +"X" + SaveData.saveF + " antihistaminic\n";}

        Order.setText(s);
        TotalPrice.setText(String.valueOf(SaveData.saveTotal) + " L.E.");
    }

    public void OnBack(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader= new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource("ShoppingCart.fxml"));
        stage = (Stage) ((Node)event.getSource ()) .getScene () . getWindow();
        scene = new Scene(root);
        stage.setScene (scene) ;
        stage.show();
    }


    public void OnConfirm(ActionEvent event) throws IOException {
        if(Payment.getValue()==null)
        { Warning.setText("SORRY, You Must Choose a Payment Method!");}
        else {
            if (SaveData.saveA == 0 && SaveData.saveB == 0 && SaveData.saveC == 0 && SaveData.saveD == 0 && SaveData.saveE == 0 && SaveData.saveF == 0) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                Parent root = fxmlLoader.load(getClass().getResource("Empty.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                FXMLLoader fxmlLoader = new FXMLLoader();
                Parent root = fxmlLoader.load(getClass().getResource("Final.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }
    }

    public void OnPay(ActionEvent actionEvent) {
        String s = Payment.getSelectionModel().getSelectedItem().toString();
        text.setText(s);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Payment.getItems().addAll(choices);
        Payment.setOnAction(this::getChoice);
    }

    public void getChoice(ActionEvent event){
        String s = Payment.getValue();
        text.setText(s);
    }
}
