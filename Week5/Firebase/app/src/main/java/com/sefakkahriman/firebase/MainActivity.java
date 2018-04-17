package com.sefakkahriman.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.sefakkahriman.firebase.utils.AuthManager;


public class MainActivity extends AppCompatActivity implements AuthManager.IAuthManager{

    private EditText etPassword;
    private EditText etEmail;
    private AuthManager authManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();

        authManager = new AuthManager(this);
    }

    private void bindViews() {
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
    }

    public void onSignIn(View view) {
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        authManager.signIn(email,password);
    }

    public void onRegister(View view) {
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        authManager.register(email,password);
    }

    @Override
    public void onLoggingSucess(FirebaseUser user) {
        Toast.makeText(this,"Test: "+user.getEmail(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoggingError(Exception e) {
        Toast.makeText(this,"Error: "+e.getMessage(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSignOut(boolean isSignOut) {

    }
}
