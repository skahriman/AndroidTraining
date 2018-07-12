package com.example.sefakkahriman.fragmentcelebrity;

import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Switch;

import com.example.sefakkahriman.fragmentcelebrity.fragments.AtaturkFragment;
import com.example.sefakkahriman.fragmentcelebrity.fragments.MichaelJacksonFragment;
import com.example.sefakkahriman.fragmentcelebrity.fragments.MuhammadAliFragment;
import com.example.sefakkahriman.fragmentcelebrity.fragments.WhitneyHoustonFragment;

public class MainActivity extends AppCompatActivity implements ListFragment.FragmentListener {

    private int input =  3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListFragment celebrityFragment = new ListFragment();
        AtaturkFragment ataturk = new AtaturkFragment();
        MuhammadAliFragment ali = new MuhammadAliFragment();
        WhitneyHoustonFragment whitneyHouston = new WhitneyHoustonFragment();
        MichaelJacksonFragment michaelJackson = new MichaelJacksonFragment();

        //Add the Fragment
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, celebrityFragment)
                .commit();


        switch (input) {

            case 0:
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.detailContainer, michaelJackson)
                        .commit();
                break;

            case 1:
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.detailContainer, ali)
                        .commit();
                break;

            case 2:
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.detailContainer, ataturk)
                        .commit();
                break;

            case 3:
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.detailContainer, ataturk)
                        .commit();
                break;
        }


    }

    @Override
    public int getInteger(int i) {
        return i;
    }
}
