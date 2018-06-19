package com.example.sefakkahriman.chasemobileappdemo.adapter_model;

public class ListItem {

    private String title;
    private String balance;
    private String availableBalance;

    public ListItem(String title, String balance, String availableBalance) {
        this.title = title;
        this.balance = balance;
        this.availableBalance = availableBalance;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(String availableBalance) {
        this.availableBalance = availableBalance;
    }
}
