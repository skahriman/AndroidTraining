package com.example.sefakkahriman.googletwetterfacebookauth.utils;

import android.app.Activity;
import android.content.Intent;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AuthManager {

    private static AuthManager instance;

    private AuthManager.ILoginInteraction loginListener;
    private AuthManager.ISignOutInteraction signOutListener;

    private FirebaseAuth mAuth;

    private FacebookManager mFacebookManager;
    private GoogleManager mGoogleManager;


    public static AuthManager getInstance(Activity activity) {
        if (instance == null)
            instance = new AuthManager(activity);
        instance.attach(activity);
        return instance;
    }

    private AuthManager(Activity activity) {
        this.mAuth = FirebaseAuth.getInstance();
        this.mFacebookManager = FacebookManager.getInstance(activity);
        this.mGoogleManager = GoogleManager.getInstance(activity);
    }

    private void attach(Object object) {
        if (object instanceof AuthManager.ILoginInteraction) {
            this.loginListener = (AuthManager.ILoginInteraction) object;
        }
        if (object instanceof AuthManager.ISignOutInteraction) {
            this.signOutListener = (AuthManager.ISignOutInteraction) object;
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        mFacebookManager.onActivityResult(requestCode,resultCode,data);
        mGoogleManager.onActivityResult(requestCode,resultCode,data);
    }

    public FirebaseUser getUser() {
        return mAuth.getCurrentUser();
    }

    public void signInWithFacebook(){
        mFacebookManager.signIn();
    }

    public void signInWithGoogle(){
        mGoogleManager.signIn();
    }

    public void signOut() {
        mAuth.signOut();
        mFacebookManager.signOut();
        mGoogleManager.signOut();
        signOutListener.onSignOut(mAuth.getCurrentUser() == null);
    }

    public interface ILoginInteraction {
        void onLoginSuccess(FirebaseUser user);
        void onLoginError(String error);
    }

    public interface ISignOutInteraction {
        void onSignOut(boolean isSignedOut);
    }
}