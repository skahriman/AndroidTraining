package com.example.sefakkahriman.servicesproject;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sefakkahriman.servicesproject.problem_2.MyIntentService;
import com.example.sefakkahriman.servicesproject.problem_2.MyReceiver;
import com.example.sefakkahriman.servicesproject.problem_3.MyBroadcastReceiver;

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

        // This part if for problem_1: sending system broadcast
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        intentFilter.addAction(Intent.ACTION_BATTERY_OKAY);
        intentFilter.addAction(Intent.ACTION_BATTERY_LOW);
        intentFilter.addAction(Intent.ACTION_HEADSET_PLUG);
        intentFilter.addAction(Intent.ACTION_USER_UNLOCKED);

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
