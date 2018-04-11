package com.example.sefakkahriman.gsonproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUserName = findViewById(R.id.etUserName);
    }

    public void onClickButton(View view) {
        Intent intent = new Intent(getApplicationContext(), MyProfileActivity.class);
        intent.putExtra("profileName", etUserName.getText().toString());
        startActivity(intent);
    }
}