package com.example.sefakkahriman.customadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView simpleList;
    ArrayList<Person> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personList = new ArrayList<>();
        personList.add(new Person("Sefak", "Kahriman"));
        personList.add(new Person("Michael", "Jackson"));
        personList.add(new Person("Elvis", "Presley"));
        personList.add(new Person("Johny", "Cash"));

        simpleList = findViewById(R.id.idListView);
        CustomAdapter adapter = new CustomAdapter(this, personList);
        simpleList.setAdapter(adapter);

    }

}
