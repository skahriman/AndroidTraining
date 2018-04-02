package com.example.sefakkahriman.multithreding;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sefakkahriman.multithreding.myEvents.MyMessageEvent;
import com.example.sefakkahriman.multithreding.threads.MyAsyncTask;
import com.example.sefakkahriman.multithreding.threads.MyEventThread;
import com.example.sefakkahriman.multithreding.threads.MyRunnable;
import com.example.sefakkahriman.multithreding.threads.MyThread;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity implements Handler.Callback {

    private TextView tvMain;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMain = findViewById(R.id.tvMain);
        handler = new Handler(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    public void onStartThread(View view) {
        Log.d(MainActivity.class.getSimpleName(), "onStartThread: "
                + Thread.currentThread());
        MyThread myThread = new MyThread(tvMain);
        myThread.start();
    }

    public void onStartRunnable(View view) {
        MyRunnable myRunnable = new MyRunnable(handler);
        Thread myThread = new Thread(myRunnable);
        myThread.start();
    }

    public void onStartAsyncTask(View view) {
        MyAsyncTask myAsyncTask = new MyAsyncTask(tvMain);
        myAsyncTask.execute();
    }


    @Override
    public boolean handleMessage(Message msg) {
        Toast.makeText(this, msg.getData().getString("data"), Toast.LENGTH_SHORT).show();

        return false;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageReceived(MyMessageEvent myMessageEvent) {
        Toast.makeText(this, myMessageEvent.getData(), Toast.LENGTH_SHORT).show();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageReceived2(MyMessageEvent myMessageEvent) {
        tvMain.setText(myMessageEvent.getData());
    }


    public void onStartEventBus(View view) {
        MyEventThread myEventThread = new MyEventThread();
        myEventThread.start();
    }
}











