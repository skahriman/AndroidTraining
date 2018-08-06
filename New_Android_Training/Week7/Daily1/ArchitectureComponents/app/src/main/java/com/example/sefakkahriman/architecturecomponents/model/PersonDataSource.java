package com.example.sefakkahriman.architecturecomponents.model;

import com.example.sefakkahriman.architecturecomponents.PersonViewModel;

public class PersonDataSource {

    PersonViewModel personViewModel;

    public PersonDataSource(PersonViewModel personViewModel) {
        this.personViewModel = personViewModel;
    }

    public static Person getPerson() {
        return new Person("John Doe", "23", "male");
    }

}
