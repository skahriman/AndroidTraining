package com.example.sefakkahriman.sendorderedbroadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MyReceiver myOrderedReceiver1;
    MyReceiver2 myOrderedReceiver2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //register Receiver_1
        myOrderedReceiver1 = new MyReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("myAction");
        registerReceiver(myOrderedReceiver1, intentFilter);

        //register Receiver_2
        myOrderedReceiver2 = new MyReceiver2();
        IntentFilter intentFilterCustom = new IntentFilter();
        intentFilterCustom.addAction("myAction");
        registerReceiver(myOrderedReceiver2, intentFilterCustom);
    }

    public void onSendOrderedBroadcast(View view) {

        Intent intent = new Intent();
        intent.setAction("myAction");
        intent.putExtra("data","sendOrderedBroadcast method!");
        sendOrderedBroadcast(intent,null);

        Toast.makeText(this, "Check the log for outputs", Toast.LENGTH_SHORT).show();

    }
}








