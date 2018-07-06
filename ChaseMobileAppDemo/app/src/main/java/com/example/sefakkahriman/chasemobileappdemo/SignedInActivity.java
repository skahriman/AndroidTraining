package com.example.sefakkahriman.chasemobileappdemo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.sefakkahriman.chasemobileappdemo.adapter.MyAdapter;
import com.example.sefakkahriman.chasemobileappdemo.model.ListItemMap;
import com.example.sefakkahriman.chasemobileappdemo.model.ListOfTransactions;
import com.example.sefakkahriman.chasemobileappdemo.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;


public class SignedInActivity extends AppCompatActivity {

    private double balance;

    private static final String TAG = "myTag";
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private String id;

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<ListItemMap> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signed_in);

        mAuth = FirebaseAuth.getInstance();
        id = mAuth.getCurrentUser().getUid();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        writeNewUser(id, "John", "john@email.com", "504-434-9997");
        writeNewTransaction();

        ///////////////
        setMyAdapter();

        setMyDrawerLayout();
    }

    private void setMyDrawerLayout() {
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView nav_view = findViewById(R.id.navigation_view);
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                String title = item.getTitle().toString();
                Toast.makeText(SignedInActivity.this, "clicked on " + title, Toast.LENGTH_SHORT).show();

                return false;
            }
        });
    }

    public void setMyAdapter() {


        recyclerView = findViewById(R.id.recyclerViewIDForHomePage);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();
        ListItemMap item = new ListItemMap("CHASE CHECKING(...3795) ", " $" + this.balance, "Available balance");
        listItems.add(item);

        adapter = new MyAdapter(this, listItems);
        recyclerView.setAdapter(adapter);
    }

    public void writeNewUser(String userId, String name, String email, String address) {
        User user = new User(name, email, address);
        mDatabase.child("users").child(userId).setValue(user);
    }

    public void writeNewTransaction(){
        ListOfTransactions listOfTransactions = new ListOfTransactions();

        for(int i = 0; i < listOfTransactions.getList().size(); i++) {
            double amount = listOfTransactions.getList().get(i).getAmount();
            mDatabase.child("transactions").child(id).child("trans_" + i).setValue(listOfTransactions.getList().get(i));
        }
        int size = listOfTransactions.getList().size();
        this.balance = listOfTransactions.getList().get(size - 1).getBalance();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }

        else {
            Toast.makeText(this, "Clicked on " + item.getTitle().toString(), Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, ProfileSettingsActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.account, menu);
        return super.onCreateOptionsMenu(menu);
    }


}