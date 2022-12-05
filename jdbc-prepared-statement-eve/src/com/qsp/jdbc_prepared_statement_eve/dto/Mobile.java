package com.qsp.jdbc_prepared_statement_eve.dto;
public class Mobile {
    private int id;
    private String brand;
    private double price;
    private String color;
    private String camera;
    // getter
    public int getId() {
        return id;
    }
    public String getBrand() {
        return brand;
    }
    public double getPrice() {
        return price;
    }
    public String getColor() {
        return color;
    }
    public String getCamera() {
        return camera;
    }

    // setter
    public void setId(int id) {
        this.id = id;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setCamera(String camera) {
        this.camera = camera;
    }
}
