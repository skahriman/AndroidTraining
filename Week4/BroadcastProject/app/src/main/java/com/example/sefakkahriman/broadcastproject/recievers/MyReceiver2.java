package com.example.sefakkahriman.broadcastproject.recievers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver2 extends BroadcastReceiver {
    private static final String TAG = MyReceiver2.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, intent.getStringExtra("data"), Toast.LENGTH_SHORT).show();
    }

}
