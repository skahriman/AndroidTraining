package com.example.sefakkahriman.chasemobileappdemo.model;


public class User {

    public String username;
    public String email;
    public String address;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String username, String email, String address) {
        this.username = username;
        this.email = email;
        this.address = address;
    }

}