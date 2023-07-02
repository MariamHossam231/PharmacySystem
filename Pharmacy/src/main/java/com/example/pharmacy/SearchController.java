package com.example.pharmacy;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class SearchController {
    public static ObservableList<Medicine> searchUsers(String searchQuery, String searchType) throws SQLException {
            ObservableList<Medicine> searchResult = FXCollections.observableArrayList();
        if(searchType!= "name" && searchType!="price")
            return searchResult;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/abasierydb", "root", "Abasiery@123");
            Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM medicine WHERE "+searchType+" REGEXP '"+searchQuery+"'");
            while(resultSet.next()){
                Medicine med = new Medicine();
                med.setName(resultSet.getString("name"));
                med.setPrice(resultSet.getFloat("price"));
                med.setQuantity(resultSet.getInt("quantity"));
                med.setDescription(resultSet.getString("description"));
                med.setExpiryDate(resultSet.getDate("expiry_date"));
                searchResult.add(med);
            }

        } catch (ClassNotFoundException e) {
                e.printStackTrace();
        }
             return searchResult;
    }
    public static boolean verifyadmin(String name,String password) throws SQLException {
        try{
            String pass = "";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/abasierydb","root","Abasiery@123");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from customers");
            PreparedStatement statement = con.prepareStatement("select * from customers where username = ?");
            statement.setString(1,name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                pass = resultSet.getString("paasword");
            }
            return password.equals(pass);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static ObservableList<Workers> searchWorkers(String searchQuery, String searchType) throws SQLException {
        ObservableList<Workers> searchResult = FXCollections.observableArrayList();
        if(searchType!= "name" && searchType!="id")
            return searchResult;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/abasierydb", "root", "Abasiery@123");
            Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM workers WHERE "+searchType+" REGEXP '"+searchQuery+"'");
            while(resultSet.next()){
                Workers workers = new Workers();
                workers.setId(resultSet.getInt("id"));
                workers.setName(resultSet.getString("name"));
                workers.setSalary(resultSet.getInt("salary"));
                workers.setWorkinghours(resultSet.getInt("workinghours"));
                searchResult.add(workers);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return searchResult;
    }

}