package com.example.sefakkahriman.servicesproject;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RemoteViews;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mySong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySong = MediaPlayer.create(this, R.raw.mozart);

    }

    public void startService(View view) {

        Intent intent = new Intent(this, ExampleService.class);
        startService(intent);

    }

    public void stopService(View view) {

        Intent intent = new Intent(this, ExampleService.class);
        stopService(intent);
    }

//    public void onClickStartMusic(View view) {
//        mySong.start();
//    }
//
//    public void onClickStopMusic(View view) {
//        mySong.stop();
//    }
}
