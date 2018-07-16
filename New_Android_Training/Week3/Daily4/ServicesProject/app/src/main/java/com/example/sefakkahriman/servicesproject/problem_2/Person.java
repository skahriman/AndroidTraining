package com.example.sefakkahriman.servicesproject.problem_2;

public class Person {

    String name;
    String title;
    String type;

    public Person(String name, String title, String type) {
        this.name = name;
        this.title = title;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
