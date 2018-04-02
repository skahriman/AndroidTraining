package com.example.sefakkahriman.multithreding.threads;


import com.example.sefakkahriman.multithreding.MyTasks;
import com.example.sefakkahriman.multithreding.myEvents.MyMessageEvent;

import org.greenrobot.eventbus.EventBus;

public class MyEventThread extends Thread {
    @Override
    public void run() {
        super.run();
        MyTasks.startJob(this.getClass().getSimpleName());

        //send the result back
        EventBus.getDefault().post(new MyMessageEvent("Results"));
    }
}
