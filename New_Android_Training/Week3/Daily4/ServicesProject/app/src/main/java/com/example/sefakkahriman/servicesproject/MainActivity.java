package com.example.sefakkahriman.servicesproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.sefakkahriman.servicesproject.problem_1.MyService;
import com.example.sefakkahriman.servicesproject.problem_2.MyIntentService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void startService(View view) {

        Intent intent = new Intent(getApplicationContext(), MyService.class);
        intent.setAction("PLAY");
        startService(intent);

    }

    public void stopService(View view) {

        Intent intent = new Intent(getApplicationContext(), MyService.class);
        stopService(intent);
    }

    public void onClickCreateBtn(View view) {

        startService(new Intent(getApplicationContext(), MyIntentService.class));
    }
}
