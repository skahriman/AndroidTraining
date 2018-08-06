package com.example.sefakkahriman.homework.problem4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sefakkahriman.homework.R;
import com.flurry.android.FlurryAgent;

public class FurryAnalyticsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_furry_analytics);

        new FlurryAgent.Builder()
                .withLogEnabled(true)
                .build(this, "CYRXMX6BGT7TZZCXW64H");
    }
}
