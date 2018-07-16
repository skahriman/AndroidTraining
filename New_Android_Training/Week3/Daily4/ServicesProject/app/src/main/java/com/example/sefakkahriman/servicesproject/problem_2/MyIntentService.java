package com.example.sefakkahriman.servicesproject.problem_2;

import android.Manifest;
import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class MyIntentService extends IntentService {

    public static final String TAG = MyIntentService.class.getSimpleName() + " _TAG";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

//        List<Person> personList;
//        personList = DataCreator.getPersons();

        //some job
        Intent intent1 = new Intent("myIntentAction");
        intent1.putExtra("result", "Completed");
        sendBroadcast(intent1, Manifest.permission.INTERNET);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}
