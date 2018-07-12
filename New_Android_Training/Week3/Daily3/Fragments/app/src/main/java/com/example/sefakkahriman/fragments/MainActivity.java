package com.example.sefakkahriman.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.sefakkahriman.fragments.fragments.BlueFragment;
import com.example.sefakkahriman.fragments.fragments.RedFragment;


public class MainActivity extends AppCompatActivity
        implements BlueFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onAddingFragment(View view) {


        FragmentManager fragmentManager = getSupportFragmentManager();

        switch (view.getId()) {

            case R.id.btnAddRed:
                RedFragment redFragment = new RedFragment();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragmentHolder1, redFragment, RedFragment.STRING_TAG)
                        .addToBackStack(RedFragment.STRING_TAG)//using this we can go back to the stack
                        .commit();
                break;
            case R.id.btnAddBlue:
                BlueFragment blueFragment = BlueFragment
                        .newInstance("data1", "data2");
                fragmentManager.beginTransaction()
                        .add(R.id.fragmentHolder2, blueFragment, BlueFragment.STRING_TAG)
                        .addToBackStack(BlueFragment.STRING_TAG)
                        .commit();
                break;
        }
    }

    @Override
    public void onFragmentInteraction(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

    public void onRemoveFragments(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
//        Get red fragment
        RedFragment redFragment = (RedFragment) fragmentManager
                .findFragmentByTag(RedFragment.STRING_TAG);

        BlueFragment blueFragment = (BlueFragment) fragmentManager
                .findFragmentByTag(BlueFragment.STRING_TAG);

        fragmentManager.beginTransaction()
                .remove(redFragment)
                .remove(blueFragment)
                .commit();
    }

}
