package com.example.sefakkahriman.chasemobileappdemo.model;

public class ListItemMap {

    private String title;
    private String balance;
    private String availableBalance;

    public ListItemMap() {}

    public ListItemMap(String title, String balance, String availableBalance) {
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
