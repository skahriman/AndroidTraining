package com.example.sefakkahriman.celebritydatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.sefakkahriman.celebritydatabase.data.LocalDataSource;
import com.example.sefakkahriman.celebritydatabase.model.Person;


public class NewCelebrityActivity extends AppCompatActivity {

    private EditText etFirstName;
    private EditText etLastName;
    private EditText etTitle;
//    private TextView tvAllCelebrities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_celebrity);
        bindViews();
    }

    private void bindViews() {

        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etTitle = findViewById(R.id.etTitle);
   //     tvAllCelebrities = findViewById(R.id.tvAllPersons);

    }

    public void handlingSQLite(View view) {
        LocalDataSource dataSource = new LocalDataSource(this);

        if(view.getId() == R.id.btnSaveCelebrity) {
            Person person = new Person(
                    etFirstName.getText().toString(),
                    etLastName.getText().toString(),
                    etTitle.getText().toString()
            );
            long rowNumber = dataSource.savePerson(person);

            Toast.makeText(this, String.valueOf(rowNumber), Toast.LENGTH_SHORT).show();
        }
    }

    public void handlingViewCelebrities(View view) {
        Intent intent = new Intent(getApplicationContext(), ViewCelebrityActivity.class);
        startActivity(intent);
    }
}











