package com.example.sefakkahriman.multithreding.threads;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.example.sefakkahriman.multithreding.MyTasks;

public class MyRunnable implements Runnable {

    Handler handler;
    public MyRunnable(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {
        MyTasks.startJob(this.getClass().getSimpleName());

        //send the result back
        Message message = new Message();
        Bundle bundle = new Bundle();
        bundle.putString("data", "Some result data");
        message.setData(bundle);
        handler.sendMessage(message);
    }
}
