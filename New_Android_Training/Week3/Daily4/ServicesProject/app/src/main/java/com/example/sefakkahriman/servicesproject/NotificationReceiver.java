package com.example.sefakkahriman.servicesproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;


public class NotificationReceiver extends BroadcastReceiver {

    private MediaPlayer mySong;

    @Override
    public void onReceive(Context context, Intent intent) {

        String message = intent.getStringExtra("toastMessage");
        Toast.makeText(context, "My Toast message", Toast.LENGTH_SHORT).show();

        mySong = MediaPlayer.create(context, R.raw.mozart);
        mySong.start();

    }
}
