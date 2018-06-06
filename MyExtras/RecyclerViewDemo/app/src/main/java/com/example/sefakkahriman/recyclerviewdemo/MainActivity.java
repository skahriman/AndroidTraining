package com.example.sefakkahriman.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.sefakkahriman.recyclerviewdemo.adapter.RecyclerViewAdapter;
import com.example.sefakkahriman.recyclerviewdemo.model.PersonList;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> personList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getList();
        initRecyclerView();
    }

    private void getList(){

        personList = PersonList.createAndGetList();
    }

    private void initRecyclerView(){
        recyclerView = findViewById(R.id.recycler_view);
        adapter = new RecyclerViewAdapter(personList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
