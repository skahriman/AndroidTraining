package com.sefakkahriman.firebase.utils.notifications;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessaging;

import static android.content.ContentValues.TAG;

public class FBInstanceIdService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);



        /*
        If you want to send messages to this application instance or
        manage this apps subscriptions on the server side, send the
        Instance ID token to your app server.
        sendRegistrationToServer(refreshedToken);
        */



    }
}
