package com.example.sefakkahriman.googletwetterfacebookauth.utils;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import com.example.sefakkahriman.googletwetterfacebookauth.R;

public class GoogleManager {
    private AuthManager.ILoginInteraction loginListener;
    private AuthManager.ISignOutInteraction signOutListener;

    private static final int RC_SIGN_IN = 1;
    private static GoogleManager instance;
    private Activity activity;
    private GoogleSignInClient mGoogleSignInClient;
    private FirebaseAuth mAuth;
    private final String TAG = "GOOGLETAG";

    private GoogleManager() {

    }

    private GoogleManager(Activity activity) {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(activity.getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        this.mGoogleSignInClient = GoogleSignIn.getClient(activity, gso);
        this.mAuth = FirebaseAuth.getInstance();
    }

    public static GoogleManager getInstance(Activity activity) {
        if (instance == null)
            instance = new GoogleManager(activity);
        instance.attach(activity);
        return instance;
    }

    private void attach(Object object) {
        if (object instanceof AuthManager.ILoginInteraction) {
            this.loginListener = (AuthManager.ILoginInteraction) object;
        }
        if (object instanceof AuthManager.ISignOutInteraction) {
            this.signOutListener = (AuthManager.ISignOutInteraction) object;
        }
        if (object instanceof Activity) {
            this.activity = (Activity) object;
        }
    }

    public void signOut() {
        mGoogleSignInClient.signOut();
    }

    public void signIn(){
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        activity.startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                Log.w(TAG, "Google sign in failed", e);
            }
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            loginListener.onLoginSuccess(user);
                        } else {
                            loginListener.onLoginError(task.getException().getMessage());
                        }

                    }
                });
    }

}