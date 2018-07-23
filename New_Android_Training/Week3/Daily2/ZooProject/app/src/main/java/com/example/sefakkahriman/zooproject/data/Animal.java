package com.example.sefakkahriman.zooproject.data;

public class Animal {

    String category;
    String name;
    int weight;
    String sound;


    public Animal(String category, String name, int weight, String sound) {
        this.category = category;
        this.name = name;
        this.weight = weight;
        this.sound = sound;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", sound='" + sound + '\'' +
                '}';
    }
}
