package com.example.sefakkahriman.zooproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.sefakkahriman.zooproject.adapter.RVAnimalAdapter;
import com.example.sefakkahriman.zooproject.data.Book;
import com.example.sefakkahriman.zooproject.data.DataCreator;

import java.util.List;

public class AnimalsForCategory extends AppCompatActivity {

    private static final String TAG = "myTag";

    private List<Book> animalList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals_for_category);

        Bundle extras = getIntent().getExtras();

        String animalType = (String) extras.get("name");
//        this.animalList = DataCreator.getAnimals(animalType);
        this.animalList = DataCreator.getBookList();

        RecyclerView recyclerView = findViewById(R.id.rvAnimals);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        RVAnimalAdapter adapter = new RVAnimalAdapter(DataCreator.getAnimals(animalType));
//        RVBookAdapter adapter = new RVBookAdapter(DataCreator.getBookList());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


    }
}
