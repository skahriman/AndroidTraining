package com.example.sefakkahriman.servicesproject;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.example.sefakkahriman.servicesproject.problem_1.MyService;
import com.example.sefakkahriman.servicesproject.problem_2.MyIntentService;
import com.example.sefakkahriman.servicesproject.problem_2.MyReceiver;
import com.example.sefakkahriman.servicesproject.problem_2.Person;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MyReceiver myReceiver;
    IntentFilter intentFilter;

    List<Person> person = new ArrayList<>();
    RecyclerView rvPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPerson = findViewById(R.id.rvPerson);

    }

    @Override
    protected void onStart() {
        super.onStart();
        myReceiver = new MyReceiver(rvPerson);
        intentFilter = new IntentFilter();
        intentFilter.addAction("myAction");

        registerReceiver(myReceiver, intentFilter);

    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myReceiver);
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
