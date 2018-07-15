package com.example.sefakkahriman.services.services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class MyIntentService extends IntentService {

    public static final String TAG = MyIntentService.class.getSimpleName() + " _TAG";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent: ");
        Log.d(TAG, "onHandleIntent: Thread " + Thread.currentThread().getName());

        Log.d(TAG, "onHandleIntent: Task starting");
        for (int i = 0; i < 4; i++) {
            try {
                Thread.sleep(500);
                Log.d(TAG, "onHandleIntent: " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.d(TAG, "onHandleIntent: Task complete");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}
