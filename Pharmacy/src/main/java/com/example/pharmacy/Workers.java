package com.example.pharmacy;

public class Workers {
    private int id;
    private String name;
    private int salary;

    public Workers() {
    }

    private int workinghours;

    public Workers(int id, String name, int salary, int workinghours) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.workinghours = workinghours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getWorkinghours() {
        return workinghours;
    }

    public void setWorkinghours(int workinghours) {
        this.workinghours = workinghours;
    }
}
