package com.example.sefakkahriman.zooproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sefakkahriman.zooproject.data.AnimalFactory;

import java.util.ArrayList;
import java.util.List;

public class SimpleLIstView extends AppCompatActivity {

    private ListView listView;
    private List<String> kindList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list_view);

        bindViews();
        bindCategoryList();
        clickItemOnAnimalList();

    }

    public void bindViews(){
        listView = findViewById(R.id.lvSimple);
    }

    public void bindCategoryList() {

        kindList = AnimalFactory.createSimpleAnimals();

        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, kindList);
        listView.setAdapter(arrayAdapter);
    }

    // Show items when clicked on list elements.

    public void clickItemOnAnimalList() {
        List<String> moreAnimals = new ArrayList<>();
        moreAnimals = AnimalFactory.createSimpleAnimals();
        ArrayAdapter<String> listAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, moreAnimals);
        listView.setAdapter(listAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Intent will be here
//                Intent intent = new Intent(SimpleLIstView.this, ListViewOfSameKind.class);
                Intent intent = new Intent(SimpleLIstView.this, RecyclerActivity.class);
                intent.putExtra("Type", kindList.get(position));
                startActivity(intent);
            }
        });
        listView.setAdapter(listAdapter);
    }

}




















