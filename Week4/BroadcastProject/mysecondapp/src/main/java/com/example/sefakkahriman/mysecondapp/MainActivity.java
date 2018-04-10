package com.example.sefakkahriman.mysecondapp;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.sefakkahriman.mysecondapp.receivers.MyOtherReceiver;

public class MainActivity extends AppCompatActivity {

    private MyOtherReceiver myReceiver;
    private EditText etMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        //register myOtherReceiver
        myReceiver = new MyOtherReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("myAction");
        registerReceiver(myReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myReceiver);
    }

    public void onSendOrderedBroadcast(View view) {
        Intent intent = new Intent();
        intent.setAction("myAction");
        intent.putExtra("data","Notice me Sefak!");
        sendOrderedBroadcast(intent,null);
    }
}
