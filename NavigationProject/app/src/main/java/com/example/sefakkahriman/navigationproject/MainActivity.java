package com.example.sefakkahriman.navigationproject;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

//use FragmentActivity
public class MainActivity extends FragmentActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        String menu = menuItem.toString();

                        switch (menu) {
                            case "Phone":
                                Intent intent1 = new Intent(getApplicationContext(), Contacts.class);
                                startActivity(intent1);
                                break;

                            case "Balance":
                                Intent intent2 = new Intent(getApplicationContext(), Balance.class);
                                startActivity(intent2);
                                break;

                            case "Home":
                                Intent intent3 = new Intent(getApplicationContext(), webview.class);
                                startActivity(intent3);
                                break;


                            default:
                                return false;

                        }


                        //if(menuItem.getTitle().equals("Contacts"))


                        return true;
                    }
                });
    }
}
