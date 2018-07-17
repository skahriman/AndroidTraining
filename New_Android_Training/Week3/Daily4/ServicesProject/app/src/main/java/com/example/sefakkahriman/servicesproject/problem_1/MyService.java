package com.example.sefakkahriman.servicesproject.problem_1;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.sefakkahriman.servicesproject.R;

import java.net.IDN;

import static com.example.sefakkahriman.servicesproject.problem_1.App.CHANNEL_ID;

public class MyService extends Service {
    MediaPlayer mediaPlayer;
    public static final String TAG = MyService.class.getSimpleName() + "_TAG";

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d(TAG, "onStartCommand: " + intent.getAction());
        String action = intent.getAction();

        switch (action) {
            case "PLAY":
                play();
                Log.d(TAG, "onStartCommand: onPLAY " + intent.getAction());

                break;

            case "STOP":
                mediaPlayer.stop();
                Log.d(TAG, "onStartCommand: onSTOP " + intent.getAction());
//                onDestroy();
                break;

            case "PAUSE":
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                } else {
                    mediaPlayer.start();
                }

                Log.d(TAG, "onStartCommand: onPAUSE " + intent.getAction());
//                onDestroy();
                break;
        }

        return super.onStartCommand(intent, flags, startId);
    }

    private void play() {
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.mozart);
        mediaPlayer.start();
//
//        Intent startIntent = new Intent(getApplicationContext(), MyService.class);
//        startIntent.setAction("START");
//        PendingIntent pendingStart = PendingIntent.getService(getApplicationContext(), 0, startIntent, PendingIntent.FLAG_CANCEL_CURRENT);
//

        Intent pauseIntent = new Intent(getApplicationContext(), MyService.class);
        pauseIntent.setAction("PAUSE");
        PendingIntent pendingPause = PendingIntent.getService(getApplicationContext(), 0, pauseIntent, PendingIntent.FLAG_CANCEL_CURRENT);


        Notification notification = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                .setContentTitle("MUSIC PLAYER")
//                .setContentText(input)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .setSmallIcon(R.drawable.ic_music)
                .addAction(R.mipmap.ic_launcher, "PAUSE/START", pendingPause)

                .setColor(Color.BLUE)
                .build();

        startForeground(1, notification);
    }


    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        stopSelf();
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
