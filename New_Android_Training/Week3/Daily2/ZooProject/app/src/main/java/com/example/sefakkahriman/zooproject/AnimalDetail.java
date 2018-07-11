package com.example.sefakkahriman.zooproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.sefakkahriman.zooproject.adapter.CVAnimalAdapter;
import com.example.sefakkahriman.zooproject.adapter.RVAnimalAdapter;
import com.example.sefakkahriman.zooproject.data.Animal;
import com.example.sefakkahriman.zooproject.data.DataCreator;

public class AnimalDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_detail);

        Bundle extras = getIntent().getExtras();

        String name = (String) extras.get("name");
        int weight = (int) extras.get("weight");
        String sound = (String) extras.get("sound");

        Animal animal = new Animal(name, weight, sound);

        RecyclerView recyclerView = findViewById(R.id.cvRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        CVAnimalAdapter adapter = new CVAnimalAdapter(DataCreator.getSingleAnimal(animal));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
