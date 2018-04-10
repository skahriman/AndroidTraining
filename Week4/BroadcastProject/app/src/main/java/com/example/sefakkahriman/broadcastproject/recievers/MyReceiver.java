package com.example.sefakkahriman.broadcastproject.recievers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d("MY_RECEIVER_TAG ", "onReceive: ");

        switch (intent.getAction()) {
            case Intent.ACTION_AIRPLANE_MODE_CHANGED:

                boolean status1 = intent.getBooleanExtra("state", false);

                Toast.makeText(context, "Airplane mode " + status1, Toast.LENGTH_SHORT).show();
                break;

            case Intent.ACTION_POWER_CONNECTED:
                Log.d("MY_RECEIVER_TAG ", "connected: ");
                Toast.makeText(context, "Charger connected", Toast.LENGTH_SHORT).show();

                break;

            case Intent.ACTION_POWER_DISCONNECTED:
                Log.d("MY_RECEIVER_TAG ", "disconnected: ");
                Toast.makeText(context, "Charger disconnected", Toast.LENGTH_SHORT).show();

                break;

            case Intent.ACTION_SCREEN_ON:
                Toast.makeText(context, "Screen is off ", Toast.LENGTH_SHORT).show();
                break;

            case Intent.ACTION_SCREEN_OFF:
                Toast.makeText(context, "Screen is on", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
