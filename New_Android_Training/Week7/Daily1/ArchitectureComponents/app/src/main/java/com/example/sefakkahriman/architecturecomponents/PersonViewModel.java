package com.example.sefakkahriman.architecturecomponents;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sefakkahriman.architecturecomponents.model.Person;
import com.example.sefakkahriman.architecturecomponents.model.PersonDataSource;

public class PersonViewModel extends ViewModel {


    MutableLiveData<Person> personMutableLiveData;

    public LiveData getPerson() {
        if (personMutableLiveData == null) {
            personMutableLiveData = new MutableLiveData<>();
            loadPerson();
        }
        return personMutableLiveData;
    }

    private void loadPerson() {
        personMutableLiveData.setValue(PersonDataSource.getPerson());
    }

    public void setPerson(Person person) {

        personMutableLiveData.setValue(person);
    }
}
