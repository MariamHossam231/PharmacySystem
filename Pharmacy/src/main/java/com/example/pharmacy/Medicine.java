package com.example.pharmacy;

import java.util.Date;

public class Medicine {
    private String name;
    private Float price;
    private String Description;
    private Date ExpiryDate;
    private String Type;
    private int Quantity;
    private int Id;

    public Medicine() {
    }
    public Medicine (String Name , Float price , int quantity)
    {
        this.name = name;
        this.price = price;
        Quantity = quantity;
    }
    public Medicine(String name, Float price, String description, Date expiryDate, String type, int quantity, int id) {
        this.name = name;
        this.price = price;
        Description = description;
        ExpiryDate = expiryDate;
        Type = type;
        Quantity = quantity;
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setExpiryDate(Date expiryDate) {
        ExpiryDate = expiryDate;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return Description;
    }

    public int getId() {
        return Id;
    }

    public Float getPrice() {
        return price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public Date getExpiryDate() {
        return ExpiryDate;
    }



}
