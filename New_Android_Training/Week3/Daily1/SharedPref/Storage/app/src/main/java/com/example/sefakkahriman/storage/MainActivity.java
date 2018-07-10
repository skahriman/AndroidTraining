package com.example.sefakkahriman.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sefakkahriman.storage.model.Person;
import com.example.sefakkahriman.storage.model.data.LocalDataSource;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String MY_SHARED_PREF = "mySharedPref";
    private TextView tvMain;
    private TextView etMain;
    private EditText etPersonName;
    private EditText etPersonAge;
    private EditText etPersonGender;
    private LocalDataSource localDataSource;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMain = findViewById(R.id.tvMain);
        etMain = findViewById(R.id.etMain);

        etPersonName = findViewById(R.id.etPersonName);
        etPersonAge = findViewById(R.id.etPersonAge);
        etPersonGender = findViewById(R.id.etPersonGender);

        localDataSource = new LocalDataSource(this);

    }

    public void handleSharedPreferences(View view) {
        SharedPreferences sharedPreferences =
                getSharedPreferences(MY_SHARED_PREF, Context.MODE_PRIVATE);

        switch (view.getId()) {
            case R.id.btnSaveData:

                String etString = etMain.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("etMain", etString);
                //we can use editor.apply() also
                boolean isSaved = editor.commit();
                if (isSaved) {
                    Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.btnGetData:

                String data = sharedPreferences
                        .getString("etMain", "default value");
                tvMain.setText(data);
                break;
        }
    }

    public void handlingDatabase(View view) {

        Person person = new Person(
                etPersonName.getText().toString(),
                etPersonAge.getText().toString(),
                etPersonGender.getText().toString());

        switch (view.getId()) {

            case R.id.btnSavePerson:
                long rowid = localDataSource.savePerson(person);
                if (rowid > 0) {
                    Toast.makeText(this, "Person Saved", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(this, "Not Saved", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btnGelAllPersons:
                List<Person> personList = localDataSource.getAllPerson();
                Toast.makeText(this, personList.toString(), Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
