package com.example.sefakkahriman.firebase.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {
    private static final String TAG = "myTag";

    public MyFirebaseInstanceIdService() {
    }

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        Log.d(TAG, "onTokenRefresh: ");
    }
}
