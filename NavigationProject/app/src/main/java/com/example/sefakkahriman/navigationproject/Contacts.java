package com.example.sefakkahriman.navigationproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Contacts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_conctacts);

        ListView myListView = (ListView) findViewById(R.id.myListView);
        ArrayList<String> myContacts = new ArrayList<>();

        myContacts.add("Michael  Jackson: 1(404) 000-0000");
        myContacts.add("Bred pitt: 1(404) 000-0001");
        myContacts.add("Tome Cruse: 1(404) 000-0002");
        myContacts.add("Charlie Chaplin: 1(404) 000-0003");
        myContacts.add("Johnny Cash: 1(404) 000-0004");


        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myContacts);
        myListView.setAdapter(itemsAdapter);
    }
}
