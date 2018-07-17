package com.example.sefakkahriman.servicesproject;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.example.sefakkahriman.servicesproject.problem_2.MyIntentService;
import com.example.sefakkahriman.servicesproject.problem_2.MyReceiver;

public class MainActivity extends AppCompatActivity {

    MyReceiver myReceiver;
    IntentFilter intentFilter;

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

    public void onClickCreateBtn(View view) {

        startService(new Intent(getApplicationContext(), MyIntentService.class));
    }
}
