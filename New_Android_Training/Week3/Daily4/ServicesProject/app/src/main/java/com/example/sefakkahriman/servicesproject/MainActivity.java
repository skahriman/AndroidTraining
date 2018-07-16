package com.example.sefakkahriman.servicesproject;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.sefakkahriman.servicesproject.problem_1.ExampleService;
import com.example.sefakkahriman.servicesproject.problem_2.DataCreator;
import com.example.sefakkahriman.servicesproject.problem_2.MyIntentService;
import com.example.sefakkahriman.servicesproject.problem_2.RecyclerViewAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void startService(View view) {

        Intent intent = new Intent(getApplicationContext(), ExampleService.class);
        intent.setAction("PLAY");
        startService(intent);

    }

    public void stopService(View view) {

        Intent intent = new Intent(getApplicationContext(), ExampleService.class);
        stopService(intent);
    }

    public void onClickCreateBtn(View view) {

        startService(new Intent(getApplicationContext(), MyIntentService.class));
    }
}
