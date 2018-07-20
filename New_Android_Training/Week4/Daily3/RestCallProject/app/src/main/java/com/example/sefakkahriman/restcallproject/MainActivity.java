package com.example.sefakkahriman.restcallproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view) {

        switch (view.getId()) {

            case R.id.btnProfile:
                startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                break;

            case R.id.btnRepo:
                startActivity(new Intent(getApplicationContext(), RepositoryActivity.class));
                break;
        }
    }

}