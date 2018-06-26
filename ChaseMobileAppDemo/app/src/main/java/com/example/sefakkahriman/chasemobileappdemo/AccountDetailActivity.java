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

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                showData(dataSnapshot);
                //this part is very important to update it
                adapter.notifyDataSetChanged();
                //this part is very important to update it

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
