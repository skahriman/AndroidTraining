package com.example.sefakkahriman.chasemobileappdemo.model;

import java.util.Date;

public class Transaction {

    String place;
    double amount;
    String date;


    public Transaction(String place, double amount, String date) {
        this.place = place;
        this.amount = amount;
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "place='" + place + '\'' +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                '}';
    }
}


