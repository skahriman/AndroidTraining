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
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText etUserId, etPassword;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUserId = findViewById(R.id.etUserIdSignUp);
        etPassword = findViewById(R.id.etPasswordSignUP);

        //Get Firebase instance
        mAuth = FirebaseAuth.getInstance();
//
//        if(mAuth.getCurrentUser() != null) {
//            startActivity(new Intent(this, SignedInActivity.class));
//            finish();
//        }

    }

    public void onLoginClicked(View view) {
        final String userId = etUserId.getText().toString();
        final String password = etPassword.getText().toString();

        if (TextUtils.isEmpty(userId)) {
            Toast.makeText(this, "Enter User ID!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Enter password!", Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.signInWithEmailAndPassword(userId, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "wrong password//userId", Toast.LENGTH_SHORT).show();
                            return;

                            }
                            else{

                                startActivity(new Intent(LoginActivity.this, SignedInActivity.class));
                                finish();
                            }
                        }

                });
    }
}
