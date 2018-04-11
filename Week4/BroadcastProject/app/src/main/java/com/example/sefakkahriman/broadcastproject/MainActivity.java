package com.example.sefakkahriman.broadcastproject;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sefakkahriman.broadcastproject.recievers.MyReceiver;
import com.example.sefakkahriman.broadcastproject.recievers.MyReceiver2;

public class MainActivity extends AppCompatActivity {

    private MyReceiver myReceiver;
    private MyReceiver2 myReceiver2;
    private EditText etMain;

    private TextView textViewResult;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etMain = findViewById(R.id.etMain);
        textViewResult = findViewById(R.id.textViewResult);

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

//    @Override
//    protected void onStop() {
//        super.onStop();
//        unregisterReceiver(myReceiver);
//        unregisterReceiver(myReceiver2);
//
//    }

    //send sendBroadcast method
    public void onSenBroadcast(View view) {

        Intent intent = new Intent();
        intent.setAction("myAction");
        intent.putExtra("data","sendBroadcast method");

//        sendBroadcast(new Intent("com.example.NOTIFY"),
//                Manifest.permission.SEND_SMS);
    }

    //sendOrderedBroadcast method
    public void onSendOrderedBroadcast(View view) {
        Intent intent = new Intent();
        intent.setAction("myAction");
        intent.putExtra("data","sendOrderedBroadcast method!");
        sendOrderedBroadcast(intent,null);
    }

    private class MyResultReceiver extends ResultReceiver {
        private final String TAG = MyResultReceiver.class.getName();


        public MyResultReceiver(Handler handler) {
            super(handler);
        }

//        @Override
//        protected void onReceiveResult(int resultCode, Bundle resultData) {
//            super.onReceiveResult(resultCode, resultData);
//
//            Log.d(TAG, "onReceiveResultThread = " + Thread.currentThread().getName());
//
//            if(resultData != null) {
//                final String result = resultData.getString("resultData");
//
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        textViewResult.setText(result);
//                        Log.d(TAG, "Handler Thread = " + Thread.currentThread().getName());
//                    }
//                });
//
//            }
//
//        }
    }


}
