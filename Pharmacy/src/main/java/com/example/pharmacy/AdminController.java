package com.example.pharmacy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class AdminController {

    @FXML
    private Button button;

    @FXML
    private Stage stage2;
    @FXML
    private PasswordField passwordHidden;

    @FXML
    private TextField passwordtext;

    @FXML
    private Label label ;
    @FXML
    private CheckBox check;

    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML
    protected void onButton(ActionEvent event) throws IOException {

         if (passwordHidden.getText().equals("1234") && !check.isSelected()  ){
             FXMLLoader fxmlLoader= new FXMLLoader();
             Parent root = fxmlLoader.load(getClass().getResource("AdminFunction.fxml"));
             stage = (Stage) ((Node)event.getSource ()) .getScene () . getWindow();
             scene = new Scene(root);
             stage.setScene (scene) ;
             stage.show();
       }
         else if(passwordtext.getText().equals("1234") ){
             FXMLLoader fxmlLoader= new FXMLLoader();
             Parent root = fxmlLoader.load(getClass().getResource("AdminFunction.fxml"));
             stage = (Stage) ((Node)event.getSource ()) .getScene () . getWindow();
             scene = new Scene(root);
             stage.setScene (scene) ;
             stage.show();
         }
         else
         {
             passwordHidden.setText("");
             passwordtext.setText("");
             //passwordtext.getText(passwordHidden.setText());
             label.setText("Wrong Paasword !");
         }
    }
    @FXML
    protected void onCheckbox(ActionEvent event) throws IOException {
            if(check.isSelected()){
                passwordtext.setText(passwordHidden.getText());
                passwordtext.setVisible(true);
                passwordHidden.setVisible(false);
                return;
            }else{
                passwordHidden.setText(passwordtext.getText());
                passwordHidden.setVisible(true);
                passwordtext.setVisible(false);
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
