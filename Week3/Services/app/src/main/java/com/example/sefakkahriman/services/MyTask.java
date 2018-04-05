package com.example.sefakkahriman.services;

import android.util.Log;


public class MyTask {

    public static void start(final String tag) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.d(tag, "run: "+ i);
                }

            }
        }).start();
    }
}
