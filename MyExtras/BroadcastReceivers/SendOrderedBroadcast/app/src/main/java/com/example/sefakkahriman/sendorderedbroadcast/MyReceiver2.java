package com.example.sefakkahriman.sendorderedbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver2 extends BroadcastReceiver {

    public static final String TAG = "MyReceiver2";

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d(TAG, "onReceive: " + "from Receiver_2");
    }
}
