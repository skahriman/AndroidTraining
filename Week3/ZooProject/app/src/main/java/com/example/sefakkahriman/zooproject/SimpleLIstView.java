package com.example.sefakkahriman.zooproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sefakkahriman.zooproject.data.AnimalFactory;
import com.example.sefakkahriman.zooproject.listener.SimpleListListener;
import com.example.sefakkahriman.zooproject.model.Animal;

import java.util.ArrayList;
import java.util.List;

public class SimpleLIstView extends AppCompatActivity {

    private ListView lvSimple ;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list_view);

        bindViews();
        bindSimpleList();
        showItemOnAnimalList();

    }

    public void bindViews(){
        lvSimple = findViewById(R.id.lvSimple);
        listView = findViewById(R.id.lvSimple);
    }

    public void bindSimpleList() {

        List<String> animaList = new ArrayList<>();
        animaList = AnimalFactory.createSimpleAnimals();

        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, animaList);
        lvSimple.setAdapter(arrayAdapter);
    }

    // Show items when clicked on list elements.

    public void showItemOnAnimalList() {
        List<String> moreAnimals = new ArrayList<>();
        moreAnimals = AnimalFactory.createSimpleAnimals();
        ArrayAdapter<String> listAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, moreAnimals);
        listView.setAdapter(listAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Intent will be here
                Intent intent = new Intent(SimpleLIstView.this, ListViewOfSameKind.class);
                intent.putExtra("AnimalName", listView.getItemIdAtPosition(position));
                startActivity(intent);
            }
        });
        listView.setAdapter(listAdapter);
    }
}




















