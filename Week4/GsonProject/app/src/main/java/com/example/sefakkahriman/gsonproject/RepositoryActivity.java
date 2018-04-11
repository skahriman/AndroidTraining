package com.example.sefakkahriman.gsonproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;

public class RepositoryActivity extends AppCompatActivity implements Handler.Callback {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repository);

        HandlerUtils.getDefult().setReceiver(new Handler(this));
        NativeClient nativeClient = new NativeClient(url);
        nativeClient.start();
    }

    private static final String url = "https://api.github.com/users/skahriman/repos";
    private String data;
    private MyProfile myProfile;
    private Repos[] myRepos;

    @Override
    public boolean handleMessage(Message message) {
        data = message.getData().getString("results");

        Gson gson = new Gson();
//        myProfile = gson.fromJson(data, MyProfile.class);
        myRepos = gson.fromJson(data, Repos[].class);

        return false;
    }

}
