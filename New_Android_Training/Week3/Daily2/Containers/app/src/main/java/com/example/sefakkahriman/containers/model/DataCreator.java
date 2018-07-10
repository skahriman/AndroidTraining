package com.example.sefakkahriman.containers.model;

import java.util.ArrayList;
import java.util.List;

public class DataCreator {

    public static List<String> getSimpleStrings() {

        List<String> strings = new ArrayList<>();
        strings.add("String 1");
        strings.add("String 2");
        strings.add("String 3");
        strings.add("String 4");

        return strings;
    }

    public static List<Book> getBookList() {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("AKF-111", "John Doe Chronicles", "John Doe"));
        bookList.add(new Book("AKF-222", "Dostoyevsky", "Crime and Punishment"));
        bookList.add(new Book("AKF-333", "Halide Edip Adivar", "Atesten Gomlek"));
        bookList.add(new Book("AKF-444", "Yasar Kemal", "Teneke"));

        return bookList;
    }
}
