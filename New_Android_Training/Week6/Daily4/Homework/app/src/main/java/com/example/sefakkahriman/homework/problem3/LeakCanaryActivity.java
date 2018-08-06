package com.example.sefakkahriman.homework.problem3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sefakkahriman.homework.R;
import com.example.sefakkahriman.homework.problem3.MemoryLeakClass;

public class LeakCanaryActivity extends AppCompatActivity {

    MemoryLeakClass memoryLeakClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak_canary);

        memoryLeakClass = MemoryLeakClass.getMemoryLeakClass(this);
    }
}
