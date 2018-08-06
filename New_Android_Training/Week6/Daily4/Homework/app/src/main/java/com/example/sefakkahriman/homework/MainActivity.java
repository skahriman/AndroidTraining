package com.example.sefakkahriman.homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.sefakkahriman.homework.problem1.MyTimberActivity;
import com.example.sefakkahriman.homework.problem2.BarcodeReaderActivity;
import com.example.sefakkahriman.homework.problem3.LeakCanaryActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickTimber(View view) {
        startActivity(new Intent(this, MyTimberActivity.class));
    }

    public void onClickReadBarcode(View view) {
        startActivity(new Intent(this, BarcodeReaderActivity.class));
    }

    public void onClickLeakCanary(View view) {
        startActivity(new Intent(this, LeakCanaryActivity.class));
    }
}
