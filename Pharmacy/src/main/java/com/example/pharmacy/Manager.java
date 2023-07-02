package com.example.pharmacy;

import java.util.ArrayList;
import java.util.Date;

public class Manager extends Person {
     private int Id;
     private double Salary;
     private double Wage;
     private String Password;
     private int Workinghours;
     private static Manager Unique ;

    private Manager() {
    }


    private Manager(String name, char gender, int id, double salary, double wage, String password, int workinghours) {
        super(name, gender);
        Id = id;
        Salary = salary;
        Wage = wage;
        Password = password;
        if (workinghours>=18)
        {Workinghours = workinghours;}else{throw new RuntimeException("working hours must be greater than 18");}
    }


    public static synchronized Manager getInstance(String name, char gender, int id, double salary, double wage, String password, int workinghours){
        if (Unique == null){
            Unique = new Manager(name,gender, id, salary, wage, password,  workinghours);
        }
        return Unique;
    }



    public static void Availablity(ArrayList<Medicine> med) {
        System.out.println("Medicines Available : ");
        for (int i = 0; i < med.size(); i++) {
            if (med.get(i).getQuantity() == 0) {
                 System.out.println(med.get(i).getName());
            }
        }

    }
    public static void isExpired(ArrayList<Medicine> medicineArrayList){
        Date date = new Date();
        System.out.println("Medicines Expired : ");
        for (int i = 0; i < medicineArrayList.size(); i++) {
            if ( date.after(medicineArrayList.get(i).getExpiryDate()) ) {
                System.out.println(medicineArrayList.get(i).getName());
            }
        }
    }
    // mmkn n print ay 7aga kaman description aw quantaty aw ay 7aga
        public static void Medicineinfo(ArrayList<Medicine> medicineArrayList){
        System.out.println("Medicines Information : ");
        for (int i = 0;i< medicineArrayList.size();i++) {
            System.out.println(" "+medicineArrayList.get(i).getName());
            System.out.println("Expiry date is " + medicineArrayList.get(i).getExpiryDate());
            System.out.println("Quantaty is " + medicineArrayList.get(i).getQuantity());
        }
        }

      // Add medicine in data base

    public static double Calcsalary(double salary,double wage , int workinghours){
        double x = wage * (workinghours-18);       //18 hours is the minimum hours for any worker & wage is for the bonus hours exceeding  18
        return (salary + x);
    }
}
