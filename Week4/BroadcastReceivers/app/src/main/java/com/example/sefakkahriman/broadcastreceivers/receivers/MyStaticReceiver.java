package com.example.sefakkahriman.broadcastreceivers.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class MyStaticReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        switch (intent.getAction()) {
            case "myAction":
                Toast.makeText(context, intent.getStringExtra("data"), Toast.LENGTH_SHORT).show();
                break;

            case "myIntentAction":
                String result = intent.getStringExtra("result");
                Toast.makeText(context, result, Toast.LENGTH_SHORT).show();
                Log.d("RECEIVER_TAG", "onReceive: "+ result);


                break;
        }
    }
}