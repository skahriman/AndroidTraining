package com.example.sefakkahriman.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d(TAG, "onReceive: runs on: " + Thread.currentThread().getName());
        switch (intent.getAction()) {

            case Intent.ACTION_AIRPLANE_MODE_CHANGED:

                boolean state = intent.getBooleanExtra("state", false);
                Toast.makeText(context, String.valueOf(state), Toast.LENGTH_SHORT).show();

                break;

            case Constants.Action.MY_ACTION:

                String data = intent.getStringExtra(Constants.Key.MY_KEY);
                Toast.makeText(context, data, Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
