package com.example.sefakkahriman.multithreding.threads;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.TextView;

import com.example.sefakkahriman.multithreding.MyTasks;

import org.w3c.dom.Text;

public class MyThread extends Thread {

    private TextView tvMain;
    Handler handler = new Handler(Looper.getMainLooper());

    public MyThread(TextView tv) {
        tvMain = tv;
    }

    @Override
    public void run() {
        super.run();

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            final int finalI = i;
            handler.post(new Runnable() {
                @Override
                public void run() {
                    tvMain.setText("Starting job");
                }
            });

            //start the task
            MyTasks.startJob(this.getName());

            handler.post(new Runnable() {
                @Override
                public void run() {
                    tvMain.setText("Task Completed");
                }
            });
        }
    }
}
