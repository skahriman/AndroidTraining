package com.example.sefakkahriman.fragmentproject.model;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private String brand;
    private String model;
    private String year;
    private List<String> carList;

    public Car(String brand, String model, String year) {
        carList = new ArrayList<>();
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
