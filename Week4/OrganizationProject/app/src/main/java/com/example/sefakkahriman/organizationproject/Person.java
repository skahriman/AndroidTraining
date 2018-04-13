package com.example.sefakkahriman.organizationproject;


import java.util.ArrayList;

public class Person {

    public ArrayList<Person> list;
    public String name;

    public Person(String name){
        list = new ArrayList<Person>();
        this.name = name;
    }

    public String  getName(){
        return this.name;
    }

    public void setName(String str){
        this.name = str;
    }

    public void addChild(Person child){
        this.list.add(child);
    }

    public Person getChildByIndex(int i) {
        return list.get(i);
    }

    public ArrayList<Person> getAllChild(){
        return this.list;
    }

    public int getChildListSize(){
        return this.list.size();
    }

}








