package com.example.sefakkahriman.chasemobileappdemo.adapter_model;

public class ListItemForTransaction {

    private String place;
    private String amount;
    private String date;
    private String balance;

    public ListItemForTransaction(String place, String amount, String date, String balance) {
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
