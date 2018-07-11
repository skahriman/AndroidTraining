package com.example.sefakkahriman.zooproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sefakkahriman.zooproject.data.DataCreator;

public class Categories extends AppCompatActivity implements AdapterView.OnItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        ListView lvSimple = findViewById(R.id.idListView);

        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, DataCreator.getCategories());
        lvSimple.setAdapter(adapter);

        lvSimple.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String item = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(this, item, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, AnimalsForCategory.class);
        intent.putExtra("name", item);

        startActivity(intent);
    }
}
