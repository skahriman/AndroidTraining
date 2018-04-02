package com.example.sefakkahriman.navigationproject;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

//use FragmentActivity
public class MainActivity extends AppCompatActivity {

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
                                intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_overflow, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.backSpace:
                finishActivity(0);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
