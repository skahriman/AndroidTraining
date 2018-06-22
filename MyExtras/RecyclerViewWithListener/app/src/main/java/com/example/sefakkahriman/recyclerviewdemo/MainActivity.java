package com.example.sefakkahriman.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.sefakkahriman.recyclerviewdemo.adapter.RecyclerViewAdapter;
import com.example.sefakkahriman.recyclerviewdemo.model.Person;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Person> personList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createList();
        initRecyclerView();
    }

    private void initRecyclerView(){
        recyclerView = findViewById(R.id.recycler_view);
        adapter = new RecyclerViewAdapter(personList, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void createList(){

        personList.add(new Person("Ali", "Kahriman"));
        personList.add(new Person("Guner", "Kahriman"));
        personList.add(new Person("Ali", "Kahriman"));
        personList.add(new Person("Ahmet", "Kahriman"));
        personList.add(new Person("Sefak", "Kahriman"));
        personList.add(new Person("Nuray", "Kahriman"));
        personList.add(new Person("Oguzhan", "Kahriman"));
        personList.add(new Person("Efe", "Kahriman"));
        personList.add(new Person("Jake", "Oliv"));
        personList.add(new Person("Michael", "Jackson"));
        personList.add(new Person("Lionel", "Messi"));
        personList.add(new Person("Selim", "Kahriman"));

    }
}
