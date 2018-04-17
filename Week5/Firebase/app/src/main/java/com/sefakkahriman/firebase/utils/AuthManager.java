package com.sefakkahriman.firebase.utils;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AuthManager {

    private static final String TAG = "AuthManager";

    private FirebaseAuth mAuth;
    private Activity activity;
    IAuthManager listener;
//    private FirebaseUser user;

    public AuthManager(Activity a) {
        this.activity = a;
        this.listener = (IAuthManager) a;
        this.mAuth = FirebaseAuth.getInstance();
    }

    public void register(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            listener.onLoggingSucess(user);
//                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
//                            Toast.makeText(activity, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
                            listener.onLoggingError(task.getException());
//                            updateUI(null);
                        }

                        // ...
                    }
                });
    }

    public void signIn(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            listener.onLoggingSucess(user);
//                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
//                            Toast.makeText(activity, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                            listener.onLoggingError(task.getException());
                        }

                        // ...
                    }
                });
    }

    public void signOut() {
        mAuth.signOut();
        listener.onSignOut(mAuth.getCurrentUser()==null);
    }

    public interface IAuthManager{
        public void onLoggingSucess(FirebaseUser user);
        public void onLoggingError(Exception e);
        public void onSignOut(boolean isSignOut);
    }
}
