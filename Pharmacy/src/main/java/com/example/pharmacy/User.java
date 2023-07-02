package com.example.pharmacy;

public class User extends Person {
    private int Phonenumber ;
    private String Address;
    private String HealthStatus;
    private int Age;
    public User(){

    }
    public User(String name, String gender,int phonenumber,String adddress,String healthStatus,int age){
        Phonenumber= phonenumber;
        Address = adddress;
        HealthStatus=healthStatus;
        Age=age;
    }
}
