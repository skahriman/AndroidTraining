package com.example.sefakkahriman.services.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;


public class MyService extends Service {

    public static final String TAG = MyService.class.getSimpleName() + "_TAG";
    public MyService() {
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate: ");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: " + intent.getStringExtra("data"));
        Log.d(TAG, "onStartCommand: " + Thread.currentThread().getName());


//        perform a tastk
        Log.d(TAG, "onStartCommand: performing a task...");

//        stop service after task complete
        Log.d(TAG, "onStartCommand: PTask complete");


        stopSelf();

//

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }
}
