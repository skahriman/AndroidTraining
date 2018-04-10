package com.example.sefakkahriman.broadcastproject;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.sefakkahriman.broadcastproject.recievers.MyReceiver;
import com.example.sefakkahriman.broadcastproject.recievers.MyReceiver2;

public class MainActivity extends AppCompatActivity {

    private MyReceiver myReceiver;
    private MyReceiver2 myReceiver2;
    private EditText etMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etMain = findViewById(R.id.etMain);

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

        //register myCustomReceiver
        myReceiver2 = new MyReceiver2();
        IntentFilter intentFilterCustom = new IntentFilter();
        intentFilterCustom.addAction("myAction");
        registerReceiver(myReceiver2, intentFilterCustom);

    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myReceiver);
        unregisterReceiver(myReceiver2);

    }

    public void onSendOrderedBroadcast(View view) {
        Intent intent = new Intent();
        intent.setAction("myAction");
        intent.putExtra("data","Notice me Sefak!");
        sendOrderedBroadcast(intent,null);
    }
}
