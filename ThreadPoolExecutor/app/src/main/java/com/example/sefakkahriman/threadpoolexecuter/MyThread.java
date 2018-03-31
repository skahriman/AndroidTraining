package com.example.sefakkahriman.threadpoolexecuter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.TextView;

public class MyThread implements Runnable {

    Handler handler;
    int id;
    int rand;

    public MyThread(int id, Handler handler, int rand) {
        this.id = id;
        this.handler = handler;
        this.rand =  rand;
    }

    @Override
    public void run() {

        for (int i = 0; i < rand; i++) {
            final int j = i;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sendMessage(i);
        }
        sendMessage(rand);
    }

    public void sendMessage(int i) {
        Message message = new Message();
        Bundle bundle = new Bundle();

        bundle.putInt("id", id);
        bundle.putDouble("progress", i/(double) rand);

        message.setData(bundle);
        handler.sendMessage(message);
    }
}
