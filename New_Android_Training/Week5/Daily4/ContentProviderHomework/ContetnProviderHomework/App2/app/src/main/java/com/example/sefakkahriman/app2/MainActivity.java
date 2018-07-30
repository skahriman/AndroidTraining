package com.example.sefakkahriman.app2;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.sefakkahriman.app2.data.Person;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PermissionManager.Callback {
    private static final String TAG = "MainActivity";

    public static final String CONTENT_URI = "com.example.sefakkahriman.contentproviderhomework.PersonProvider";
    private PermissionManager permissionManager;
    private RecyclerView rvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvList = findViewById(R.id.rvList);

        Log.d(TAG, "onCreate: Check permission");
        permissionManager = new PermissionManager(this);
        permissionManager.checkPermission();
    }

    @Override
    public void onPermissionResults(int requestCode, boolean isGranted) {
        switch (requestCode){
            case PermissionManager.MY_PERMISSIONS_REQUEST_READ_CONTACTS:{
                if(isGranted){
                    Log.d(TAG, "onPermissionResults: Granted");
                    List<Person> contentProviderList = getAnimals();

                    RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,contentProviderList);
                    rvList.setAdapter(adapter);
                    rvList.setLayoutManager(new LinearLayoutManager(this));
                }else {
                    Log.d(TAG, "onPermissionResults: Denied");
                }
                break;
            }

        }
    }

    private List<Person> getAnimals(){
        Log.d(TAG, "onCreate: Cursor loading");
        Cursor cursor = this.getContentResolver().query(Uri.parse("com.example.sefakkahriman.contentproviderhomework.data/Person"),null,null,null,null);
        List<Person> list = new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                Person person = new Person();
                String firstName = cursor.getString(cursor.getColumnIndex("firstName"));
                String lastName = cursor.getString(cursor.getColumnIndex("lastName"));
                String address = cursor.getString(cursor.getColumnIndex("address"));
                String gender = cursor.getString(cursor.getColumnIndex("gender"));
                String age = cursor.getString(cursor.getColumnIndex("age"));
                person.setFirstName(firstName);
                person.setLastName(lastName);
                person.setAddress(address);
                person.setAddress(gender);
                person.setAge(age);

                list.add(person);
            }while (cursor.moveToNext());
        }
        Log.d(TAG, "List animal: " + list);
        return list;
    }
}
