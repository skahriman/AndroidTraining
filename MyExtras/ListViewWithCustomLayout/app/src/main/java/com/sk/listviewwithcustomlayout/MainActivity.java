package com.sk.listviewwithcustomlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.sk.listviewwithcustomlayout.R;

public class MainActivity extends AppCompatActivity {

    ListView mListView;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] teams = {"Turkey", "USA", "Germany", "India"};
        mListView = findViewById(R.id.listView);

        adapter = new ArrayAdapter<>(this,R.layout.custom_layout , R.id.textView, teams);

        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, adapterView.getItemAtPosition(i) + " is selected", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
