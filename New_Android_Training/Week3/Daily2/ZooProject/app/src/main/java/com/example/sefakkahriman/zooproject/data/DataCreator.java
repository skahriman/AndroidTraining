package com.example.sefakkahriman.zooproject.data;

import java.util.ArrayList;
import java.util.List;

public class DataCreator {

    public static List<String> getCategories() {

        List<String> list = new ArrayList<>();

        String lion = "Lion";
        String tiger = "Tiger";
        String snake = "Snake";
        String wolf = "Wolf";
        String zebra = "Zebra";
        String dog = "Dog";

        list.add(lion);
        list.add(tiger);
        list.add(snake);
        list.add(wolf);
        list.add(zebra);
        list.add(dog);

        return list;
    }

    public static List<Animal> getSingleAnimal(Animal animal) {
        List<Animal> list = new ArrayList<>();
        list.add(animal);
        return list;
    }

    public static List<Animal> getAnimals(String animalName) {
        List<Animal> list = new ArrayList<>();

        List<Animal> lionList = new ArrayList<>();
        List<Animal> tigerList = new ArrayList<>();
        List<Animal> snakeList = new ArrayList<>();
        List<Animal> wolfList = new ArrayList<>();
        List<Animal> zebraList = new ArrayList<>();
        List<Animal> dogList = new ArrayList<>();


        Animal lion1 = new Animal("Lion1", 400, "Lion Roars");
        Animal lion2 = new Animal("Lion2", 380, "Lion Roars");
        Animal lion3 = new Animal("Lion3", 360, "Lion Roars");
        lionList.add(lion1);lionList.add(lion2);lionList.add(lion3);

        Animal tiger1 = new Animal("Tiger1", 360, "Tiger growls");
        Animal tiger2 = new Animal("Tiger2", 350, "Tiger growls");
        Animal tiger3 = new Animal("Tiger3", 340, "Tiger growls");
        tigerList.add(tiger1);tigerList.add(tiger2);tigerList.add(tiger3);

        Animal wolf1 = new Animal("Wolf1", 60, "snake hisses");
        Animal wolf2 = new Animal("Wolf1", 50, "Snake hisses");
        Animal wolf3 = new Animal("Wolf1", 550, "Snake hisses");
        wolfList.add(wolf1);wolfList.add(wolf2);wolfList.add(wolf3);

        Animal snake1 = new Animal("Snake1", 5, "wolf howls");
        Animal snake2 = new Animal("Snake2", 10, "wolf howls");
        Animal snake3 = new Animal("Snake3", 20, "wolf howls");
        snakeList.add(snake1);snakeList.add(snake2);snakeList.add(snake3);

        Animal zebra1 = new Animal("Zebra1", 500, "zebra sound");
        Animal zebra2 = new Animal("Zebra2", 600, "zebra sound");
        Animal zebra3 = new Animal("Zebra3", 650, "zebra sound");
        zebraList.add(zebra1);zebraList.add(zebra2);zebraList.add(zebra3);

        Animal dog1 = new Animal("dog1", 40, "zebra sound");
        Animal dog2 = new Animal("dog2", 42, "zebra sound");
        Animal dog3 = new Animal("dog3", 60, "zebra sound");
        dogList.add(dog1);dogList.add(dog2);dogList.add(dog3);


        switch (animalName) {
            case "Tiger":
                list =  tigerList;
                break;
            case "Lion":
                list = lionList;
                break;
            case "Wolf":
                list = wolfList;
                break;
            case "Snake":
                list = snakeList;
                break;
            case "Zebra":
                list = zebraList;
                break;
            case "Dog":
                list = dogList;
                break;
        }

        return list;

    }

}
