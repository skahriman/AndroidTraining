package com.example.sefakkahriman.fridaytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sefakkahriman.fridaytest.util.Utils;


public class MainActivity extends AppCompatActivity implements Fragment1.OnFragmentInteractionListener {

    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG";
    private EditText etMain;
    private Button btnSearch;
    private Fragment2 fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMain = findViewById(R.id.etMain);
        btnSearch = findViewById(R.id.btnSearch);
        addFragments();

    }

    private void addFragments() {
        Fragment1 fragment1 = new Fragment1();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragmentHolder1, fragment1, Fragment1.STRING_TAG)
                .addToBackStack(Fragment1.STRING_TAG)
                .commit();

        fragment2 = new Fragment2();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragmentHolder2, fragment2, Fragment2.STRING_TAG)
                .addToBackStack(Fragment2.STRING_TAG)
                .commit();
    }

    @Override
    public void onFragmentInteraction(String zipCode) {
        Utils.hideKeyboard(this);
        fragment2.getList(zipCode);
        Toast.makeText(this, zipCode, Toast.LENGTH_SHORT).show();
    }
}














