package com.example.sefakkahriman.gsonproject;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements Handler.Callback {

    private String userName;
    private static final String url = "https://api.github.com/users/skahriman";
    private String data;
    private MyProfile myProfile;
    private Repos[] myRepos;
    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bind();

        HandlerUtils.getDefult().setReceiver(new Handler(this));
        NativeClient nativeClient = new NativeClient(url);
        nativeClient.start();


    }

    private void bind() {
        editText = findViewById(R.id.idEditText);
        button = findViewById(R.id.idButton);
    }


    @Override
    public boolean handleMessage(Message message) {
        data = message.getData().getString("results");

        Gson gson = new Gson();
        myProfile = gson.fromJson(data, MyProfile.class);
  //      myRepos = gson.fromJson(data, Repos[].class);
        Log.d("====> ", data);

        return false;
    }

    public void onClickButton(View view) {
//        Intent intent = new Intent(getApplicationContext(), RepositoryActivity.class);
//        startActivity(intent);

    }
}
