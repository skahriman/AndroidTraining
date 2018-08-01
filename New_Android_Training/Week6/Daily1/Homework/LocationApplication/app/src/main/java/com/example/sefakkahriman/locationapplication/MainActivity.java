package com.example.sefakkahriman.locationapplication;

import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;


public class MainActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {

    GoogleApiClient mGoogleApiClient;
    private FusedLocationProviderClient mFusedLocationClient;
    private LocationRequest mLocationRequest;
    private LocationCallback mLocationCallback;


    private long UPDATE_INTERVAL = 15000;

    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;

    private final static int ALL_PERMISSIONS_RESULT = 101;

    TextView latLng;

    EditText etInput;
    TextView tvShowInputAddress;


    Geocoder geocoder = null;

    private SupportMapFragment mMapFragment;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        latLng = findViewById(R.id.latLng);
        etInput = findViewById(R.id.etInput);
        tvShowInputAddress = findViewById(R.id.tvShowInputAddress);

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        geocoder = new Geocoder(this, Locale.getDefault());

        createLocationCallback();
        createLocationRequest();

        mMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);


    }

    private void createLocationRequest() {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setInterval(UPDATE_INTERVAL);
    }

    private void createLocationCallback() {
        mLocationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                super.onLocationResult(locationResult);

                for (Location location : locationResult.getLocations()) {
                    if (location != null) {
                        latLng.setText("Latitude : "+location.getLatitude()+" , Longitude : "+location.getLongitude());
                        new LookupAddress().execute(location);
                    }
                }
            };
        };
    }

    protected void startLocationUpdates() {
        if (ActivityCompat.checkSelfPermission(this, ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(getApplicationContext(), "Enable Permissions", Toast.LENGTH_LONG).show();
        }

        mFusedLocationClient.requestLocationUpdates(mLocationRequest,mLocationCallback,null /* Looper */);
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (mGoogleApiClient != null) {
            mGoogleApiClient.connect();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (mGoogleApiClient != null) {
            mGoogleApiClient.disconnect();
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        if (ContextCompat.checkSelfPermission(this, ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED)
        {
            // No explanation needed, we can request the permission.

            ActivityCompat.requestPermissions(this,
                    new String[]{ACCESS_FINE_LOCATION},
                    ALL_PERMISSIONS_RESULT);
        }
        else
        {
            // get my first location
            mFusedLocationClient.getLastLocation()
                    .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            if (location != null) {
                                latLng.setText("");
                                latLng.append("Latitude : " + location.getLatitude() + " , Longitude : " + location.getLongitude());
                                new LookupAddress().execute(location);
                            }
                        }
                    });

            startLocationUpdates();
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        showMessageOKCancel("Connection failed",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

        switch (requestCode) {

            case ALL_PERMISSIONS_RESULT:  {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay!

                } else {
                    // permission denied, boo! Disable the functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other permissions this app might request
        }
    }

    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(MainActivity.this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

    public void onClickConvertButton(View view) {

        MyMapFragment mapFragment = new MyMapFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragmentHolder1, mapFragment, MyMapFragment.STRING_TAG)
                .addToBackStack(MyMapFragment.STRING_TAG)//using this we can go back to the stack
                .commit();
    }


    private class LookupAddress extends AsyncTask<Location, Void, ArrayList<String>>
    {
        @Override
        protected ArrayList<String> doInBackground(Location... params) {
            Location location = params[0];
            List<Address> addresses = null;

            Log.v("Jason", "Latitude = " + location.getLatitude() + ", Longitude = " + location.getLongitude());

            if (Geocoder.isPresent()) {
                try {
                    addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 3);
                } catch (IOException ioExceptin) {
                    // catch network or other I/O problems
                } catch (IllegalArgumentException illegalArgumentException) {
                    Log.e("Jason", "Latitude = " + location.getLatitude() + ", Longitude = " +
                            location.getLongitude(), illegalArgumentException);
                }

                // Handle case where no address was found.
                if (addresses == null || addresses.size() == 0) {
                    // display error no address found
                } else {
                    Address address = addresses.get(0);
                    ArrayList<String> addressFragments = new ArrayList<String>();

                    // Fetch the address lines using getAddressLine, join them, and send them to the thread.
                    for (int i = 0; i <= address.getMaxAddressLineIndex(); i++) {
                        addressFragments.add(address.getAddressLine(i));
                    }
                    return addressFragments;
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(ArrayList<String> result) {
            latLng.append("\n");

            if (result != null) {
                for (String temp : result) {
                    Log.v("RESULTS -  ", temp);
                    latLng.append(temp);
                    latLng.append("\n");
                }
            }
        }
    }
}
