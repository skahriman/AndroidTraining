package com.example.sefakkahriman.architecturecomponents;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sefakkahriman.architecturecomponents.model.Person;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PersonActivity extends AppCompatActivity {

    public static final String TAG = "myTag";
    @BindView(R.id.etPersonName)
    EditText etPersonName;
    @BindView(R.id.etPesonAge)
    EditText etPersonAge;
    @BindView(R.id.etPersonGender)
    EditText etPersonGender;
    @BindView(R.id.btnUpdatePerson)
    Button btnUpdatePerson;
    @BindView(R.id.tvPersonName)
    TextView tvPersonName;
    private PersonViewModel personViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        personViewModel = ViewModelProviders.of(this).get(PersonViewModel.class);

        Log.d(TAG, "onCreate: " + getResources().getConfiguration().orientation);

        personViewModel.getPerson().observe(this, new android.arch.lifecycle.Observer() {
            @Override
            public void onChanged(@Nullable Object object) {
                Person person = (Person) object;

                tvPersonName.setText(person.toString());
            }
        });
    }

    @OnClick(R.id.btnUpdatePerson)
    public void onViewClicked() {

        String personName = etPersonName.getText().toString();
        String personAge = etPersonAge.getText().toString();
        String personGender = etPersonGender.getText().toString();

        Person person = new Person(personName, personAge, personGender);
        personViewModel.setPerson(person);
    }
}