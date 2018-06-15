package com.example.sefakkahriman.chasemobileappdemo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private EditText etUserId, etPassword;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etUserId = findViewById(R.id.etUserIdSignUp);
        etPassword = findViewById(R.id.etPasswordSignUP);

        //get Firebase instance
        mAuth = FirebaseAuth.getInstance();



    }

    public void onSignUpClicked(View view) {

        String userId = etUserId.getText().toString();
        String password = etPassword.getText().toString();

        if(TextUtils.isEmpty(userId)){
            Toast.makeText(this, "Enter User ID", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Enter password", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.length() < 6) {
            Toast.makeText(this, "Password is too short, minimum 6 characters", Toast.LENGTH_SHORT).show();
            return;
        }

        //Create user

        mAuth.createUserWithEmailAndPassword(userId, password)
                .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(RegisterActivity.this, "createUserWithEmailOnComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();

                        //if signin fails display a message to the user
                        if(!task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this, "Authentication failed." + task.getException()
                                    , Toast.LENGTH_SHORT).show();
                        }
                        else {
                            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                            finish();
                        }
                    }
                });
    }

    public void onAlreadySignedUpClicked(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }
}























