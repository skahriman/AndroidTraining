package com.example.sefakkahriman.zooproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sefakkahriman.zooproject.data.AnimalFactory;
import com.example.sefakkahriman.zooproject.model.Animal;

import java.util.ArrayList;
import java.util.List;

public class ListViewOfSameKind extends AppCompatActivity {

    private ListView listView;
    private List<Animal> typeList;

    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_of_same_kind);

        bindViews();
        getIntent().getStringExtra("Type");
        type = getIntent().getStringExtra("Type");
        Toast.makeText(this, "Category " + type, Toast.LENGTH_SHORT).show();

        bindSameKindOfList();
    }

    public void bindViews(){
        listView = findViewById(R.id.idOfListOfSameKind);
    }

    public void bindSameKindOfList() {
        typeList = AnimalFactory.getAnilamsOfSameType(type);

        ArrayAdapter<Animal> arrayAdapter =
                new ArrayAdapter<Animal>(this, android.R.layout.simple_list_item_1, typeList);
        listView.setAdapter(arrayAdapter);
    }
}














