package com.example.pharmacy;
import java.sql.*;
import java.util.Scanner;

public class DBconnector {
        public static void main(String args[]){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/abasierydb","root","Abasiery@123");
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("select * from customers");
                while(rs.next())
                    System.out.println(rs.getInt("id")+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));
                //--------------------
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter name please :");
                String string =scanner.nextLine();



                String sql = " insert into customers (username, paasword, phone, address, age)"
                        + " values (?, ?, ?, ?, ?)";

                PreparedStatement preparedStmt = con.prepareStatement(sql);
                preparedStmt.setString (1, "mido"); //username
                preparedStmt.setString (2, "mido123"); //password
                preparedStmt.setString (3, "01234567891"); //phone
                preparedStmt.setString (4, "Works at madraset el 7ob"); //address
                preparedStmt.setInt    (5, 30); //age

                preparedStmt.execute();

                con.close();

            }catch(Exception e){ System.out.println(e);}
        }
}
