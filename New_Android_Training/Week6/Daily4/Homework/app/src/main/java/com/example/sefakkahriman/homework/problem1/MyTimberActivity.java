package com.example.sefakkahriman.homework.problem1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sefakkahriman.homework.R;

import timber.log.Timber;

public class MyTimberActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_timber);

        Timber.d("Hello");
        Timber.v("Goodbye");

        String firstName = "Johnny";
        String lastName = "Cash";

        Timber.d("Hello " + firstName + " " + lastName + "!");
    }
}
