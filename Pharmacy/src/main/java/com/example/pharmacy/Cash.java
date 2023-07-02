package com.example.pharmacy;

public class Cash implements PaymentStrategy {
    public Cash() {
    }

    @Override
    public void pay(double  amount) {
        System.out.println("An amount of "+ amount+"$ will be payed Cash");
    }
}
