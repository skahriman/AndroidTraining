package com.example.sefakkahriman.chasemobileappdemo.model;


public class User {

    public String username;
    public String email;
    public String phone_number;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String username, String email, String phone_number) {
        this.username = username;
        this.email = email;
        this.phone_number = phone_number;
    }

}