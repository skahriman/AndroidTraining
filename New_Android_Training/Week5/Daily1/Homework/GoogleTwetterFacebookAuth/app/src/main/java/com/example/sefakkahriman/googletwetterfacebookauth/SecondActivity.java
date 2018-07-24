package com.example.sefakkahriman.googletwetterfacebookauth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.sefakkahriman.googletwetterfacebookauth.utils.AuthManager;

public class SecondActivity extends AppCompatActivity implements AuthManager.ISignOutInteraction{

    private AuthManager mAuthManager;
    private TextView tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mAuthManager = AuthManager.getInstance(this);

        tvEmail = findViewById(R.id.tvEmail);
        tvEmail.setText(mAuthManager.getUser().getEmail());
    }

    public void onSignOut(View view) {
        mAuthManager.signOut();
    }

    @Override
    public void onSignOut(boolean isSignedOut) {
        finish();
    }
}