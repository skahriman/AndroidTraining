package com.example.sefakkahriman.zooproject.data;

import com.example.sefakkahriman.zooproject.model.Animal;

import java.util.ArrayList;
import java.util.List;

public class AnimalFactory {


    private static List<Animal> animalList;
    private static List<Animal> typeList;

    public static List<Animal> createAnimals() {
        animalList = new ArrayList<>();
        typeList = new ArrayList<>();

        animalList.add(new Animal("Tiger", "400", "Cat"));
        animalList.add(new Animal("Python", "40", "Snake"));
        animalList.add(new Animal("Lion", "450", "Cat"));
        animalList.add(new Animal("Chimpanzee", "100", "Monkey"));
        animalList.add(new Animal("Parrot", "10", "Bird"));
        animalList.add(new Animal("Mountain Lion", "300", "Cat"));
        animalList.add(new Animal("Moose", "80", "Deer"));
        animalList.add(new Animal("Anaconda", "60", "Snake"));
        return animalList;
    }

    public static List<String> createSimpleAnimals() {

        List<String> strings = new ArrayList<>();
        strings.add("Cat");
        strings.add("Snake");
        strings.add("Monkey");
        strings.add("Bird");
        strings.add("Dear");
        return strings;

    }

    public static List<Animal> getMoreAnimals() {
        List<Animal> animalList = new ArrayList<>();

        animalList.add(new Animal("Tiger", "400", "Cat"));
        animalList.add(new Animal("Python", "40", "Snake"));
        animalList.add(new Animal("Lion", "450", "Cat"));
        animalList.add(new Animal("Chimpanzee", "100", "Monkey"));
        animalList.add(new Animal("Parrot", "10", "Bird"));
        animalList.add(new Animal("Mountain Lion", "300", "Cat"));
        animalList.add(new Animal("Moose", "80", "Deer"));
        animalList.add(new Animal("Anaconda", "60", "Snake"));

        return animalList;
    }

    public static List<Animal> getAnilamsOfSameType (String str) {
        createAnimals();
        getMoreAnimals();

        for(int i = 0; i < animalList.size(); i ++) {
            if(animalList.get(i).getType().equals(str))
                typeList.add(animalList.get(i));
        }
        return typeList;
    }
}