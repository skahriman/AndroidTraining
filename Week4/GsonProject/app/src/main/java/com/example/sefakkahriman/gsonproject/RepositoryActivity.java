package com.example.sefakkahriman.gsonproject;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class RepositoryActivity extends AppCompatActivity implements Handler.Callback {

    final static String MY_PROFILE_URL = "https://api.github.com/users/";
    String profileName;
    Repos[] repos;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repository);

        listView = findViewById(R.id.idListView);
        profileName = getIntent().getStringExtra("profileName");

        HandlerUtils.getDefult().setReceiver(new Handler(this));
        new NativeClient(MY_PROFILE_URL + profileName + "/repos").start();
    }

    @Override
    public boolean handleMessage(Message msg) {
        Gson gson = new Gson();
        repos = gson.fromJson(msg.getData().getString("results"), Repos[].class);

        List<String> list = new ArrayList<>();

        for (int i = 0; i < repos.length; i++) {
            list.add(repos[i].getName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);


        return false;
    }

}