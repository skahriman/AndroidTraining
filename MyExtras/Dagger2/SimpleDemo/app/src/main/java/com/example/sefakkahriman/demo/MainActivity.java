package com.example.sefakkahriman.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyTag";
    @Inject
    MyDate myDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyComponent myComponent = DaggerMyComponent.create();
        myComponent.inject(this);


        Log.d(TAG, "onCreate: " + myDate.getDate());

    }
}
