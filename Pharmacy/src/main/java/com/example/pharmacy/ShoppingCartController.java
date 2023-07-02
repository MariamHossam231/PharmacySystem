package com.example.pharmacy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class ShoppingCartController {

    Parent root;
    Scene scene;
    Stage stage;


    @FXML
    private Label Price;
    @FXML
    private Label Price1;
    @FXML
    private Label Price2;
    @FXML
    private Label Price3;
    @FXML
    private Label Price4;
    @FXML
    private Label Price5;

    @FXML
    private Label TotalPrice;

    @FXML
    private Label quantity;
    @FXML
    private Label quantity1;
    @FXML
    private Label quantity2;
    @FXML
    private Label quantity3;
    @FXML
    private Label quantity4;
    @FXML
    private Label quantity5;

    //ArrayList<Medicine> meds = new ArrayList<>();
    Medicine voltaren = new Medicine( "voltaren" , 15.0F, 250);
    Medicine panadol = new Medicine( "panadol" , 14.0F , 250);
    Medicine augmentin = new Medicine( "augmentin" , 55.0F , 250);
    Medicine antibiotic = new Medicine( "antibiotic" , 45.0F , 250);
    Medicine claritine = new Medicine( "claritine" , 65.0F , 250);
    Medicine antihistaminic = new Medicine( "antihistaminic" , 10.0F , 250);

    int a=0;
    int b=0;
    int c=0;
    int d=0;
    int e=0;
    int f=0;

    public void OnCalculate(ActionEvent actionEvent) {
        TotalPrice.setText(String.valueOf(a * voltaren.getPrice() + b * panadol.getPrice() + c * augmentin.getPrice() + d* antibiotic.getPrice() + e * claritine.getPrice() + f* antihistaminic.getPrice()));
    }


    public void OnPlus(ActionEvent event) {
            a++;
            Float p = a * voltaren.getPrice();
            Price.setText(String.valueOf(p));
            quantity.setText("X" + String.valueOf(a));

    }

    public void OnSub(ActionEvent event) {
        if(a == 0 ){
            Price.setText(String.valueOf(voltaren.getPrice()));
            quantity.setText("X0");
        }
        else{
            a--;
            Float p = a * voltaren.getPrice();
            if(a==0){Price.setText(String.valueOf(voltaren.getPrice()));}
            else{Price.setText(String.valueOf(p));}
            quantity.setText("X" + String.valueOf(a));
        }

    }

    //------------------------------------------------------------------
    public void Onplus1(ActionEvent actionEvent) {
        b++;
        Float p = b * panadol.getPrice();
        Price1.setText(String.valueOf(p));
        quantity1.setText("X" + String.valueOf(b));
    }

    public void Onsub1(ActionEvent actionEvent) {
        if (b == 0) {
            Price1.setText(String.valueOf(panadol.getPrice()));
            quantity1.setText("X0");
        } else {
            b--;
            Float p = b * panadol.getPrice();
            if(b==0){Price1.setText(String.valueOf(panadol.getPrice()));}
            else{Price1.setText(String.valueOf(p));}
            quantity1.setText("X" + String.valueOf(b));
        }
    }

    //-------------------------------------------------------------
    public void Onplus2(ActionEvent actionEvent) {
        c++;
        Float p = c * augmentin.getPrice();
        Price2.setText(String.valueOf(p));
        quantity2.setText("X" + String.valueOf(c));
    }

    public void Onsub2(ActionEvent actionEvent) {
        if (c == 0) {
            Price2.setText(String.valueOf(augmentin.getPrice()));
            quantity2.setText("X0");
        } else {
            c--;
            Float p = c * augmentin.getPrice();
            if(c==0){Price2.setText(String.valueOf(augmentin.getPrice()));}
            else{Price2.setText(String.valueOf(p));}
            quantity2.setText("X" + String.valueOf(c));
        }
    }
    //-------------------------------------------------
    public void Onplus3(ActionEvent actionEvent) {
        d++;
        Float p = d * antibiotic.getPrice();
        Price3.setText(String.valueOf(p));
        quantity3.setText("X" + String.valueOf(d));
    }

    public void Onsub3(ActionEvent actionEvent) {
        if (d == 0) {
            Price3.setText(String.valueOf(antibiotic.getPrice()));
            quantity3.setText("X0");
        } else {
            d--;
            Float p = d * antibiotic.getPrice();
            if(d==0){Price3.setText(String.valueOf(antibiotic.getPrice()));}
            else{Price3.setText(String.valueOf(p));}
            quantity3.setText("X" + String.valueOf(d));
        }
    }
    //-------------------------------------------------
    public void Onplus4(ActionEvent actionEvent) {
        e++;
        Float p = e * claritine.getPrice();
        Price4.setText(String.valueOf(p));
        quantity4.setText("X" + String.valueOf(e));
    }

    public void Onsub4(ActionEvent actionEvent) {
        if (e == 0) {
            Price4.setText(String.valueOf(claritine.getPrice()));
            quantity4.setText("X0");
        } else {
            e--;
            Float p = e * claritine.getPrice();
            if(e==0){Price4.setText(String.valueOf(claritine.getPrice()));}
            else{Price4.setText(String.valueOf(p));}
            quantity4.setText("X" + String.valueOf(e));
        }
    }
    //----------------------------------------------------------------------
    public void Onplus5(ActionEvent actionEvent) {
        f++;
        Float p = f * antihistaminic.getPrice();
        Price5.setText(String.valueOf(p));
        quantity5.setText("X" + String.valueOf(f));
    }

    public void Onsub5(ActionEvent actionEvent) {
        if (f == 0) {
            Price5.setText(String.valueOf(antihistaminic.getPrice()));
            quantity5.setText("X0");
        } else {
            f--;
            Float p = f * antihistaminic.getPrice();
            if(f==0){Price5.setText(String.valueOf(antihistaminic.getPrice()));}
            else{Price5.setText(String.valueOf(p));}
            quantity5.setText("X" + String.valueOf(f));
        }
    }

//----------------------------------------------------------------------------------------
    public void OnCheckout(ActionEvent event) throws IOException {

        SaveData.saveA=a;
        SaveData.saveB=b;
        SaveData.saveC=c;
        SaveData.saveD=d;
        SaveData.saveE=e;
        SaveData.saveF=f;
        SaveData.saveTotal=SaveData.saveA* voltaren.getPrice() + SaveData.saveB * panadol.getPrice() + SaveData.saveC * augmentin.getPrice() + SaveData.saveD* antibiotic.getPrice() + SaveData.saveE * claritine.getPrice() + SaveData.saveF* antihistaminic.getPrice();
        //
        FXMLLoader fxmlLoader= new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource("Checkout.fxml"));
        stage = (Stage) ((Node)event.getSource ()) .getScene () . getWindow();
        scene = new Scene(root);
        stage.setScene (scene) ;
        stage.show();
    }



}
