package com.example.sefakkahriman.gsonproject;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

public class MyProfileActivity extends AppCompatActivity  implements Handler.Callback {

    final static String MY_PROFILE_URL = "https://api.github.com/users/";
    String profileName;
    Owner model;
    ImageView ivAvatar;
    TextView tvName;
    TextView id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        ivAvatar = findViewById(R.id.ivAvatar);
        tvName = findViewById(R.id.tvName);
        profileName = getIntent().getStringExtra("profileName");
        id = findViewById(R.id.myID);

        HandlerUtils.getDefult().setReceiver(new Handler(this));
        new NativeClient(MY_PROFILE_URL + profileName).start();
    }

    @Override
    public boolean handleMessage(Message msg) {
        Gson gson = new Gson();
        model = gson.fromJson(msg.getData().getString("results"), Owner.class);
        //Glide
        Glide.with(this).load(model.getAvatarUrl()).into(ivAvatar);


        tvName.setText("login: " + model.getLogin());
        id.setText("id: " + model.getId());

        return false;
    }

    public void onClickRepos(View view)
    {
        Intent intent = new Intent(getApplicationContext(), RepositoryActivity.class);
        intent.putExtra("profileName", profileName);
        startActivity(intent);
    }
}