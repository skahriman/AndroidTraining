package com.example.sefakkahriman.threadpoolexecuter;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity implements Handler.Callback
{
    android.os.Handler handler = new android.os.Handler(this);
    ExecutorService executor;
    Random random;

    ProgressBar bar1;
    ProgressBar bar2;
    ProgressBar bar3;
    ProgressBar bar4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        executor = Executors.newFixedThreadPool(4);
        random = new Random();

        bar1 = findViewById(R.id.progressBar1);
        bar2 = findViewById(R.id.progressBar2);
        bar3 = findViewById(R.id.progressBar3);
        bar4 = findViewById(R.id.progressBar4);

        bar1.setMax(100);
        bar2.setMax(100);
        bar3.setMax(100);
        bar4.setMax(100);

    }

    public void onStartThreads(View view) {
        for (int i = 1; i < 5; i++) {
            Runnable worker = new MyThread(i, handler, generateNumber());
            executor.execute(worker);
        }
    }

    public int generateNumber(){
        return 5 + (int)(Math.random()*100)/10; //creates number between 5 and 15
    }


    @Override
    public boolean handleMessage(Message msg) {
        Bundle bundle = msg.getData();
        Double progress = bundle.getDouble("progress");
        int id = bundle.getInt("id");

        switch (id) {
            case 1:
                bar1.setProgress((int) (progress*100));
                break;
            case 2:
                bar2.setProgress((int) (progress*100));
                break;
            case 3:
                bar3.setProgress((int) (progress*100));
                break;
            case 4:
                bar4.setProgress((int) (progress*100));
                break;
            default:
                Toast.makeText(this, "wrong", Toast.LENGTH_SHORT).show();

        }

        return false;
    }
}
