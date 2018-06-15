package com.example.sefakkahriman.chasemobileappdemo.model;

import java.util.List;

public class Account {

    private String accountNumber;
    private String name;
    private String address;
    static double balance = 500;
    private List<ListOfTransactions> listOfTransactions;

    public Account(String accountNumber, String name) {
        this.accountNumber = accountNumber;
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<ListOfTransactions> getListOfTransactions() {
        return listOfTransactions;
    }

    public void setListOfTransactions(List<ListOfTransactions> listOfTransactions) {
        this.listOfTransactions = listOfTransactions;
    }
}
