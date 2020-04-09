package com.exmaple.android.recyclerviewwithinterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    String[] persons =  {"Jake", "John", "Doe", "Mike", "Suzan", "Amenda"};
    RecyclerView mRecyclerView;
    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();
    }

    private void initRecyclerView() {
        mRecyclerView = findViewById(R.id.rv_recyclerView);
        adapter = new RecyclerViewAdapter(this, persons);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


}
