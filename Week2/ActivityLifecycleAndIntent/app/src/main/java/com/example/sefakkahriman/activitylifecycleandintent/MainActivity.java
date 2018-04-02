package com.example.sefakkahriman.activitylifecycleandintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private final String TAG = Tagger.get(this);
    private EditText etName;
    private EditText etAge;
    private EditText etGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: Instance is created");

        //bind

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    //finish();
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    public void onFinish(View view) {
        finish();
    }

    public void goToSecond(View view) {
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        etName = (EditText) findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        etGender = findViewById(R.id.etGender);

        Person person = new Person(etName.getText().toString(), etAge.getText().toString(), etGender.getText().toString());

        intent.putExtra("data",person);
        startActivity(intent);
    }
}