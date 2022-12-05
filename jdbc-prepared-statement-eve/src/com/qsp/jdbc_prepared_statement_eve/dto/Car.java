package com.qsp.jdbc_prepared_statement_eve.dto;

public class Car {
    private int id;
    private String brand;
    private String model;
    private double price;
    // getter
    public String getBrand() {
        return brand;
    }
    public int getId() {
        return id;
    }
    public String getModel() {
        return model;
    }
    public double getPrice() {
        return price;
    }
    // setter
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    
}
