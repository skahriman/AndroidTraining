package com.example.sefakkahriman.servicesproject.problem_2;

import android.Manifest;
import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.ContactsContract;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.sefakkahriman.servicesproject.R;
import com.example.sefakkahriman.servicesproject.problem_1.NotificationReceiver;

import java.util.ArrayList;
import java.util.List;

import static com.example.sefakkahriman.servicesproject.problem_1.App.CHANNEL_ID;

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
