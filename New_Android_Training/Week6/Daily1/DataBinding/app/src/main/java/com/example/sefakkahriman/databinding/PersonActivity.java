package com.example.sefakkahriman.databinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sefakkahriman.databinding.databinding.ActivityMainBinding;

/**
 * we added this part to gradle
 *      dataBinding{
 *          enabled true
 *      }
 */

public class PersonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        ActivityMainBinding mainBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);

        mainBinding.setPerson(new Person("John Doe", "male", "45"));
        mainBinding.setPersonViewModel(new PersonViewModel());
    }
}



