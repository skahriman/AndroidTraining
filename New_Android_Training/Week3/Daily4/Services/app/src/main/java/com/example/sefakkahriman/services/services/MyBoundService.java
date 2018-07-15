package com.example.sefakkahriman.services.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyBoundService extends Service {

    public static final String TAG = MyBoundService.class.getSimpleName() + "_TAG";
    public MyBoundService() {
    }

    IBinder iBinder = new MyBinder();

    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    public String getDataFromServer() {
        return "This is  the data from server";
    }

//    Binder class to communicate with clients
    public class MyBinder extends Binder {

        public MyBoundService getService() {
            return MyBoundService.this;
        }
    }
}
