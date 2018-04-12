package com.example.sefakkahriman.contentprovider;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.sefakkahriman.contentprovider.R;

import static android.provider.OpenableColumns.DISPLAY_NAME;

public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 10;
    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //check permission for using contacts
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {

            Log.d(TAG, "onCreate: Permission is not granted");
            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_CONTACTS)) {

                Log.d(TAG, "onCreate: Show an explanation to the user");
                getExplanationDialog().show();
                // Show an explanation to the user asynchronously -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {
                askPermission();
            }
        } else {

            getContatcts();
            Log.d(TAG, "onCreate: Permission has already been granted");
            // Permission has already been granted
        }
    }

    private AlertDialog getExplanationDialog() {

        return new AlertDialog.Builder(this)
                .setTitle("Need the permission")
                .setMessage("Can you please allow this permission? I need it.")
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Toast.makeText(MainActivity.this,
                                "Features disabled",
                                Toast.LENGTH_SHORT)
                                .show();
                    }
                })
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        askPermission();
                    }
                }).create();
    }

    private void askPermission() {

        // No explanation needed; request the permission
        Log.d(TAG, "onCreate: No explanation needed; request the permission");
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.READ_CONTACTS},
                MY_PERMISSIONS_REQUEST_READ_CONTACTS);

        // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
        // app-defined int constant. The callback method gets the
        // result of the request.
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_CONTACTS: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Log.d(TAG, "onRequestPermissionsResult: permission was granted");
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                    getContatcts();

                } else {

                    Log.d(TAG, "onRequestPermissionsResult: permission denied");
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request.
        }
    }

    public void getContatcts() {

        //define content uri
        Uri contactTri = ContactsContract.Contacts.CONTENT_URI;

        //define columns
        String DIDPLAY_NAME = ContactsContract.Contacts.DISPLAY_NAME;
        String HAS_PHONE_NUMBER =  ContactsContract.Contacts.HAS_PHONE_NUMBER;

        //retrieve the contents from contactProvider
        Cursor contactsCursor = getContentResolver().query(
                contactTri, null, null, null, null
        );

        while(contactsCursor.moveToNext()) {

            String contactName = contactsCursor.getString(contactsCursor.getColumnIndex(DIDPLAY_NAME));
            Log.d(TAG, "getContacts: " + contactName);

            //retrieve phone numbers from contacts
            int hasNumberColumnIndex = contactsCursor.getColumnIndex(HAS_PHONE_NUMBER);
            int hase_phone = contactsCursor.getInt(hasNumberColumnIndex);

            if(hase_phone > 0) {
                Uri phoneUri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
                String NUMBER = ContactsContract.CommonDataKinds.Phone.NUMBER;

                Cursor phoneCursor = getContentResolver().query(
                        phoneUri,
                        new String[]{NUMBER},
                        DISPLAY_NAME + "=?",
                        new String[]{contactName},
                        null
                );

                //Select SELECTION from PHONEURI where SELECTION {SELECTION ARGS} SORTORDER

                while(phoneCursor.moveToNext()) {
                    String phoneNumber = phoneCursor.getString(phoneCursor.getColumnIndex(NUMBER));
                    Log.d(TAG, "getContatcts: " + phoneNumber);
                }

            }

        }

    }



}











