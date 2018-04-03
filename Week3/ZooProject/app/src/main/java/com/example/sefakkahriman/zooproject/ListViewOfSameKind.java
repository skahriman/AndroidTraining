package com.example.sefakkahriman.zooproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.sefakkahriman.zooproject.data.AnimalFactory;
import com.example.sefakkahriman.zooproject.model.Animal;

import java.util.ArrayList;
import java.util.List;

public class ListViewOfSameKind extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_of_same_kind);
        bindViews();
        bindSimpleList();
    }

    public void bindViews(){
        listView = findViewById(R.id.idOfListOfSameKind);
    }

    public void bindSimpleList() {

        List<Animal> animaList = AnimalFactory.getMoreAnimals();

        AnimalFactory.getMoreAnimals();

        ArrayAdapter<Animal> arrayAdapter =
                new ArrayAdapter<Animal>(this, android.R.layout.simple_list_item_1, animaList);
        listView.setAdapter(arrayAdapter);
    }
}
