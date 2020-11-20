package com.uni.Lab7.dto;

public class FoodDto {

    private String name;
    private double price;
    private String information;

    public FoodDto(String name, double price, String information) {
        this.name = name;
        this.price = price;
        this.information = information;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
