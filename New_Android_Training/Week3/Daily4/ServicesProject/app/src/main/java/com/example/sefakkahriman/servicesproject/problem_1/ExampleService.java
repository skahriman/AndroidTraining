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

import com.example.sefakkahriman.servicesproject.MainActivity;
import com.example.sefakkahriman.servicesproject.R;
import com.example.sefakkahriman.servicesproject.problem_2.MyIntentService;

import static com.example.sefakkahriman.servicesproject.problem_1.App.CHANNEL_ID;

public class ExampleService extends Service {
    MediaPlayer mediaPlayer;
    public static final String TAG = ExampleService.class.getSimpleName() + "_TAG";

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d(TAG, "onStartCommand: " + intent.getAction());

        switch (intent.getAction()) {
            case "PLAY":
                play();
                break;

            case "STOP":
                mediaPlayer.stop();
//                onDestroy();
                break;
        }

        return super.onStartCommand(intent, flags, startId);
    }

    private void play() {
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.mozart);
        mediaPlayer.start();

        Intent stopIntent = new Intent(getApplicationContext(), ExampleService.class);
        stopIntent.setAction("STOP");

        PendingIntent pendingStop = PendingIntent.getService(getApplicationContext(), 0, stopIntent, PendingIntent.FLAG_CANCEL_CURRENT);


        Notification notification = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                .setContentTitle("Example Service")
//                .setContentText(input)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .setSmallIcon(R.drawable.ic_music)
                .addAction(R.mipmap.ic_launcher, "STOP", pendingStop)
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
