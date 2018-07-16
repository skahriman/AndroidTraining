package com.example.sefakkahriman.makingrestcalls;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.sefakkahriman.makingrestcalls.client.NativeCallHelper;

public class MainActivity extends AppCompatActivity {

    private NativeCallHelper callHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        callHelper = new NativeCallHelper();
    }

    public void onNativeCall(View view) {
        NativeCallHelper callHelper = new NativeCallHelper();
        callHelper.makeCall();

    }
}
