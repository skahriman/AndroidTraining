package com.example.sefakkahriman.servicesproject.problem_2;

import java.util.ArrayList;
import java.util.List;

public class DataCreator {


    private static List<Person> list;

    public static List<Person> getPersons() {
        list = new ArrayList<>();

        list.add(new Person("Michael ", "Jackson", "Singer"));
        list.add(new Person("Muhammed ", "Ali", "Boxer"));
        list.add(new Person("Johny ", "Cash", "Country Singer"));
        list.add(new Person("Lionel ", "Messi", "Soccer Player"));

        return list;
    }
}
