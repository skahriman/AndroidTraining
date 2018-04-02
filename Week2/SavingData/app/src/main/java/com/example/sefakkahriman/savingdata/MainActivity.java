package com.example.sefakkahriman.savingdata;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sefakkahriman.savingdata.data.LocalDataContract;
import com.example.sefakkahriman.savingdata.data.LocalDataSource;
import com.example.sefakkahriman.savingdata.model.Person;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private EditText etSharedPref;
    private TextView tvSharedPref;
    private EditText etFirstName;
    private EditText etLastName;
    private EditText etGender;
    private TextView tvAllPersons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
    }

    private void bindViews() {
        etSharedPref = findViewById(R.id.etSharedPref);
        tvSharedPref = findViewById(R.id.tvSharedPref);
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etGender = findViewById(R.id.etGender);
        tvAllPersons = findViewById(R.id.tvAllPersons);

    }

    public void handlingSharedPref(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("mySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        switch (view.getId()) {
            case R.id.btnSavePref:
                editor.putString("data", etSharedPref.getText().toString());

                boolean isSaved = editor.commit();
                if (isSaved) {
                    Toast.makeText(this, "Date saved", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btnRestorePref:
                tvSharedPref.setText(sharedPreferences.getString("data", "defaultString"));
                break;
        }
    }

    public void handlingSQLite(View view) {
        LocalDataSource dataSource = new LocalDataSource(this);

        switch (view.getId()) {
            case R.id.btnSavePerson:
                Person person = new Person(
                        etFirstName.getText().toString(),
                        etLastName.getText().toString(),
                        etGender.getText().toString()
                );

                long rowNumber = dataSource.savePerson(person);

                Toast.makeText(this, String.valueOf(rowNumber), Toast.LENGTH_SHORT).show();

                break;

            case R.id.btnRetrivePerson:
                Toast.makeText(this, "**************", Toast.LENGTH_SHORT).show();
                tvAllPersons.setText(dataSource.getAllPerson().toString());
                break;
        }
    }
}
