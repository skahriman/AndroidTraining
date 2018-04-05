package com.example.sefakkahriman.fragmentproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.sefakkahriman.fragmentproject.adapter.MyAdapter;
import com.example.sefakkahriman.fragmentproject.fragments.AddFragment;
import com.example.sefakkahriman.fragmentproject.fragments.ViewFragment;
import com.example.sefakkahriman.fragmentproject.model.Car;

public class MainActivity extends AppCompatActivity {

    private static final String ADD_TAG = "addragment";
    private static final String VIEW_TAG = "viewfragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyAdapter.adapter = new ArrayAdapter<Car>(this, android.R.layout.simple_list_item_1,
                MyAdapter.car);
    }

    public void onClickFragments(View view) {

        switch (view.getId()) {
            case R.id.idAddButton:

                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.flHolder1, new AddFragment())
                        .addToBackStack(ADD_TAG)
                        .commit();
                break;

            case R.id.idViewButton:

                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.flHolder2, new ViewFragment())
                        .addToBackStack(VIEW_TAG)
                        .commit();
        }
    }
}
