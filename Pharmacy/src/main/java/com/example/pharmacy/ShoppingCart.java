package com.example.pharmacy;

import java.util.ArrayList;

public class ShoppingCart {
   private ArrayList<Medicine> list ;

    public ShoppingCart() {
        this.list = new ArrayList<Medicine>();
    }

    public void addItem (Medicine med){
        this.list.add(med);
    }
    public void removeItem (Medicine med){
        this.list.remove(med);
    }
    public double calculateTtotal(){
        double sum = 0;
      for ( Medicine med : list) {
            sum=sum+ med.getPrice();
        }
        return sum;
    }

    public void Pay(PaymentStrategy payment){
        double amount = calculateTtotal();
        payment.pay(amount);
    }
}
