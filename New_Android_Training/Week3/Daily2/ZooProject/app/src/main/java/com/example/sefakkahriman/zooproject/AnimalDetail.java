package com.example.sefakkahriman.zooproject;

import android.content.res.Resources;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.sefakkahriman.zooproject.adapter.CVAnimalAdapter;
import com.example.sefakkahriman.zooproject.adapter.RVAnimalAdapter;
import com.example.sefakkahriman.zooproject.data.Animal;
import com.example.sefakkahriman.zooproject.data.DataCreator;

public class AnimalDetail extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_detail);

        Bundle extras = getIntent().getExtras();

        String category = (String) extras.get("category");
        String name = (String) extras.get("name");
        int weight = (int) extras.get("weight");
        String sound = (String) extras.get("sound");

        Animal animal = new Animal(category, name, weight, sound);

        RecyclerView recyclerView = findViewById(R.id.cvRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        CVAnimalAdapter adapter = new CVAnimalAdapter(DataCreator.getSingleAnimal(animal));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        switch (category) {
            case "LION":
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.lion);
                break;
            case "TIGER":
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.tiger);
                break;
            case "WOLF":
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.wolf);
                break;
            case "ZEBRA":
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.zebra);
                break;
            case "SNAKE":
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.snake);
                break;
            case "DOG":
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.dog);
                break;
        }

        mediaPlayer.start();


    }
}
