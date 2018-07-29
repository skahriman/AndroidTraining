package com.example.sefakkahriman.contentproviderhomework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sefakkahriman.contentproviderhomework.data.LocalDataSource;
import com.example.sefakkahriman.contentproviderhomework.data.Person;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private EditText firstName;
    private EditText lastName;
    private EditText address;
    private EditText gender;
    private EditText age;

    LocalDataSource localDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
        localDataSource = new LocalDataSource(this);
    }

    private void bindViews() {
        firstName = findViewById(R.id.etFirstName);
        lastName = findViewById(R.id.etLastName);
        address = findViewById(R.id.etAddress);
        gender = findViewById(R.id.etGender);
        age = findViewById(R.id.etAge);
    }

    public void handlingDatabase(View view) {

        Person person = new Person(
                firstName.getText().toString(),
                lastName.getText().toString(),
                address.getText().toString(),
                gender.getText().toString(),
                age.getText().toString()
        );

        switch (view.getId()) {

            case R.id.btnSavePerson:

                long rowid = localDataSource.savePerson(person);
                if (rowid > 0) {
                    Toast.makeText(this, "Person saved", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Not saved", Toast.LENGTH_SHORT).show();
                }


                break;

            case R.id.btnGetAllPersons:

                List<Person> personList = localDataSource.getAllPerson();

                Toast.makeText(this, personList.toString(), Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
