package com.example.sefakkahriman.chasemobileappdemo.model;

public class Transaction {

    String place;
    double amount;
    String date;
    double balance;

    public Transaction(){
        // Default constructor required for calls to DataSnapshot.getValue(Transaction.class)
    }

    public Transaction(String place, double amount, String date, double balance) {
        this.place = place;
        this.amount = amount;
        this.date = date;
        this.balance = balance;
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

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}


