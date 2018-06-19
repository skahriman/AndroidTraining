package com.example.sefakkahriman.chasemobileappdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sefakkahriman.chasemobileappdemo.model.ListOfTransactions;
import com.example.sefakkahriman.chasemobileappdemo.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class SignedInActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signed_in);

        mAuth = FirebaseAuth.getInstance();
        id = mAuth.getCurrentUser().getUid();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        writeNewUser(id, "John", "john@email.com", "Atlanta, GA");
        writeNewTransaction();

        startActivity(new Intent(this, HomePageActivity.class));

    }

    public void writeNewUser(String userId, String name, String email, String address) {
        User user = new User(name, email, address);
        mDatabase.child("users").child(userId).setValue(user);
    }

    public void writeNewTransaction(){
        ListOfTransactions listOfTransactions = new ListOfTransactions();

        for(int i = 0; i < listOfTransactions.getList().size(); i++) {
            mDatabase.child("transactions").child(id).child("trans_" + i).setValue(listOfTransactions.getList().get(i));
        }

    }


}
