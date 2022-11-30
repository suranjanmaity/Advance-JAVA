package com.ibm.jdbc_crud_operation_statements.dto;
public class Laptop {
    
    private int id;
    private String name;
    private double price;
    private String color;

    //get
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public String getColor() {
        return color;
    }
    //set
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setColor(String color) {
        this.color = color;
    }

}
