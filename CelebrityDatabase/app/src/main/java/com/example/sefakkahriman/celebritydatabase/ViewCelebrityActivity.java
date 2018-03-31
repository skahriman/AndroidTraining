package com.example.sefakkahriman.celebritydatabase;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


import com.example.sefakkahriman.celebritydatabase.data.LocalDataContract;
import com.example.sefakkahriman.celebritydatabase.data.LocalDataSource;
import com.example.sefakkahriman.celebritydatabase.model.Person;

import java.util.List;
//import com.example.sefakkahriman.celebritydatabase.model.Person;

public class ViewCelebrityActivity extends AppCompatActivity {

    private EditText etFirstName;
    private EditText etLastName;
    private EditText etTitle;
    private ListView tvAllCelebrities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_celebrity);
        bindViews();
        LocalDataSource dataSource = new LocalDataSource(this);

//        tvAllCelebrities.setText(dataSource.getAllPerson().toString());
        List<Person> personList = dataSource.getAllPerson();

        int size = dataSource.getAllPerson().size();
        String[] items = new String[size];

        for(int i = 0; i < size; i++ ) {
            items[i] = personList.get(i).toString();
        }


        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        ListView myView = findViewById(R.id.tvAllCelebrities);

        myView.setAdapter(itemsAdapter);
    }

    private void bindViews() {

        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etTitle = findViewById(R.id.etTitle);
        tvAllCelebrities = findViewById(R.id.tvAllCelebrities);

    }
}
