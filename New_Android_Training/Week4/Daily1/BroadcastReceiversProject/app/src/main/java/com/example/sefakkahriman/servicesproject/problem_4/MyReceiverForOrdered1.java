package com.example.sefakkahriman.servicesproject.problem_4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiverForOrdered1 extends BroadcastReceiver {

    public static final String TAG = "MyReceiver_1";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: " + "from Receiver_1");

    }
}
