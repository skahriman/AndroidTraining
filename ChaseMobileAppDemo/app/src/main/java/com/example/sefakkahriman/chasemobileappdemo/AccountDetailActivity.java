package com.example.sefakkahriman.chasemobileappdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.sefakkahriman.chasemobileappdemo.adapter.RecyclerViewAdapterForTransactions;
import com.example.sefakkahriman.chasemobileappdemo.model.Transaction;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class AccountDetailActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerViewAdapterForTransactions adapter;
    private List<Transaction> listItems;

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private String userID;
    public static final String TAG = "MyTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_detail);

        listItems = new ArrayList<>();

        mAuth = FirebaseAuth.getInstance();
        userID = mAuth.getCurrentUser().getUid();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("transactions").child(userID);


        setMyAdapter();
    }

    public void setMyAdapter() {
        recyclerView = findViewById(R.id.recyclerViewIDForTransactionDetails);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Transaction item1 = new Transaction("Walmart", 10, "01/02/2018", 1000);
        Transaction item2 = new Transaction("Windixy", 30, "05/02/2018", 500);

        listItems.add(item1);
        listItems.add(item2);

        //Read data from database

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                showData(dataSnapshot);
                Log.d(TAG, "onDataChange: size of list is: " + listItems.size());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //Read data from database

        adapter = new RecyclerViewAdapterForTransactions(this, listItems);
        recyclerView.setAdapter(adapter);
    }

    private void showData(DataSnapshot dataSnapshot) {
        for (DataSnapshot ds : dataSnapshot.getChildren()) {
            Transaction transaction = ds.getValue(Transaction.class);
            listItems.add(transaction);
        }
    }
}
