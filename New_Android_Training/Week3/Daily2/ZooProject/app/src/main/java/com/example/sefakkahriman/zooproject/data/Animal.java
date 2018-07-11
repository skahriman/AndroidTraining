package com.example.sefakkahriman.zooproject.data;

public class Animal {

    String name;
    int weight;
    String sound;

    public Animal(String name, int weight, String sound) {
        this.name = name;
        this.weight = weight;
        this.sound = sound;
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
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", sound='" + sound + '\'' +
                '}';
    }
}