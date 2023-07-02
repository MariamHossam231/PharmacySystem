package com.example.pharmacy;

public class CreditCard implements PaymentStrategy{
    private String CardNum;

    public CreditCard(String cardNum) {
        CardNum = cardNum;
    }

    @Override
    public void pay(double amount) {
        System.out.println("An amount of "+ amount+"$ is paid by CreditCard");
    }
}
