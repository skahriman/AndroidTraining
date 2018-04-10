package com.example.sefakkahriman.broadcastproject;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.sefakkahriman.broadcastproject.recievers.MyReceiver;

public class MainActivity extends AppCompatActivity {
    private MyReceiver myReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        //register myCustomReceiver
        myReceiver = new MyReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);

        registerReceiver(myReceiver, intentFilter);

    }

    public void sendBroadcast(View view) {
        Intent intent = new Intent();
        intent.setAction("sendBroadcastAction");
        sendBroadcast(intent);
    }

    public void onClickSendOrderedBroadcast(View view) {
        Intent intent = new Intent();
        intent.setAction("sendOrderedBroadcastAction");
        sendOrderedBroadcast(intent, "hello there");
    }

}
