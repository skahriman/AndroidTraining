package com.example.sefakkahriman.servicesproject.problem_1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

import com.example.sefakkahriman.servicesproject.R;


public class NotificationReceiver extends BroadcastReceiver {

    private MediaPlayer mySong;

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "Music is playing", Toast.LENGTH_SHORT).show();

        mySong = MediaPlayer.create(context, R.raw.mozart);
        mySong.start();

    }
}
