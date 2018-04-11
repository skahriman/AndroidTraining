package com.example.sefakkahriman.makingrestcalls;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    String BASE_URL = "https://api.github.com/users/manroopsingh";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void makingRestCalls(View view) {

        switch (view.getId()) {

            case R.id.btnNative:
                NativeClient nativeClient = new NativeClient(BASE_URL);
                nativeClient.start();
                break;


        }
    }
}
