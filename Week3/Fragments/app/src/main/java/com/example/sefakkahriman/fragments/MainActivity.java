package com.example.sefakkahriman.fragments;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.sefakkahriman.fragments.fragments.BlueFragment;
import com.example.sefakkahriman.fragments.fragments.RedFragment;

public class MainActivity extends AppCompatActivity {

    private static final String BLUE_FRAG_TAG = "bluefragment";
    private static final String RED_FRAG_TAG = "redfragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onAddingFragments(View view) {

        switch (view.getId()) {
            case R.id.btnAddBlue:

                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.flHolder1, new BlueFragment(), BLUE_FRAG_TAG)
                        .addToBackStack(BLUE_FRAG_TAG)
                        .commit();
                break;
            
            case R.id.btnAddRed:

                RedFragment redFragment = RedFragment.newInstance("FirstName", "LastName");
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.flHolder2, redFragment, RED_FRAG_TAG)
                        .addToBackStack("REDTAG")
                        .commit();

                break;
        }
    }
}
