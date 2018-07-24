package com.example.sefakkahriman.googletwetterfacebookauth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;

import com.example.sefakkahriman.googletwetterfacebookauth.utils.AuthManager;

public class MainActivity extends AppCompatActivity implements AuthManager.ILoginInteraction {

    private AuthManager mAuthManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuthManager = AuthManager.getInstance(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        mAuthManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onStart() {
        super.onStart();

        mAuthManager = AuthManager.getInstance(this);
        if (mAuthManager.getUser() != null) {
            startSecondActivity();
        }
    }

    private void startSecondActivity() {
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        startActivity(intent);
    }

    public void loginFacebook(View view) {
        mAuthManager.signInWithFacebook();
    }

    public void loginGoogle(View view) {
        mAuthManager.signInWithGoogle();
    }

    @Override
    public void onLoginSuccess(FirebaseUser user) {
        startSecondActivity();
    }

    @Override
    public void onLoginError(String error) {
        Toast.makeText(this, "Login failed: " + error, Toast.LENGTH_SHORT).show();
    }
}