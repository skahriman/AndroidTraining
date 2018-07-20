package com.example.sefakkahriman.broadcastreceivers;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    MyReceiver myReceiver;
    IntentFilter intentFilter;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.etMain);
    }

    @Override
    protected void onStart() {
        super.onStart();
        myReceiver = new MyReceiver();
        intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        intentFilter.addAction(Constants.Action.MY_ACTION);

        registerReceiver(myReceiver, intentFilter);

//        this part is for Local Broadcasting
//        restrict the receiver for local only
//        LocalBroadcastManager.getInstance(this).registerReceiver(myReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myReceiver);

//        This part is for Local Broadcasting
//        LocalBroadcastManager.getInstance(this).unregisterReceiver(myReceiver);
    }

    public void sendBroadcast(View view) {
        String data = editText.getText().toString();
        Intent intent = new Intent(Constants.Action.MY_ACTION);
        intent.putExtra(Constants.Key.MY_KEY, data);
        sendBroadcast(intent);
    }

    public void sendBroadcastOut(View view) {
        String data = editText.getText().toString();
        Intent intent = new Intent(Constants.Action.ACTION_OUTSIDE);
        intent.putExtra(Constants.Key.MY_KEY, data);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }
}
