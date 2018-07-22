package com.example.sefakkahriman.servicesproject.problem_4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiverForOrdered2 extends BroadcastReceiver {

    public static final String TAG = "MyReceiver_2";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: " + "from Receiver_2");

    }
}
