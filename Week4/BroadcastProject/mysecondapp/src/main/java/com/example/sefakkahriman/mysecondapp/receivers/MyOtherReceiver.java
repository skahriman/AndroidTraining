package com.example.sefakkahriman.mysecondapp.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyOtherReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d("OTHER_TAG ",  " got the message");
        Toast.makeText(context, intent.getStringExtra("data"), Toast.LENGTH_SHORT).show();
    }
}
