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

    private int input;
    private ListFragment celebrityFragment;
    private AtaturkFragment ataturk;
    private MuhammadAliFragment ali;
    private WhitneyHoustonFragment whitneyHouston;
    private MichaelJacksonFragment michaelJackson;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        celebrityFragment = new ListFragment();

        ataturk = new AtaturkFragment();
        ali = new MuhammadAliFragment();
        whitneyHouston = new WhitneyHoustonFragment();
        michaelJackson = new MichaelJacksonFragment();

        //Add the Fragment
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, celebrityFragment)
                .commit();
    }

    @Override
    public void getInteger(int i) {

        switch (i) {

            case 0:
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.detailContainer, michaelJackson)
                        .commit();
                break;

            case 1:
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.detailContainer, ali)
                        .addToBackStack(MuhammadAliFragment.class.getSimpleName())
                        .commit();
                break;

            case 2:
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.detailContainer, ataturk)
                        .addToBackStack(WhitneyHoustonFragment.class.getSimpleName())
                        .commit();
                break;

            case 3:
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.detailContainer, whitneyHouston)
                        .addToBackStack(AtaturkFragment.class.getSimpleName())
                        .commit();
                break;
        }
    }
}
