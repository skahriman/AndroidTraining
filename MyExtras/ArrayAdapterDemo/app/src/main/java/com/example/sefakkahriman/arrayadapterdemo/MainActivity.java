package com.example.sefakkahriman.arrayadapterdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    List<String> colors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listViewMain);
        List<String> colors = new ArrayList<>();

        //create list with elements
        colors.add("Yellow");colors.add("Black");colors.add("Blue");colors.add("Green");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, colors);

        listView.setAdapter(adapter);
    }

}
