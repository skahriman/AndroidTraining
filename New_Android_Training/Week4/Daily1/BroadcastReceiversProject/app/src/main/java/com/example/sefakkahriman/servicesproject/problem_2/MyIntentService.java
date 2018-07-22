package com.example.sefakkahriman.servicesproject.problem_2;

import android.app.IntentService;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

import com.example.sefakkahriman.servicesproject.R;

import java.util.ArrayList;

public class MyIntentService extends IntentService {

    public static final String TAG = MyIntentService.class.getSimpleName() + "_TAG";

    MyReceiver myReceiver;
    IntentFilter intentFilter;
    private ArrayList<Person> personList;

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        personList = new ArrayList<>();
        sendBroadcast();
    }

    public void sendBroadcast() {
        createList();
        Intent intent = new Intent("myAction");
        intent.putParcelableArrayListExtra("name", personList);
        sendBroadcast(intent);
    }

    private void createList() {
        Person p1 = new Person("Michael Jackson", "Singer", "Pop", R.raw.michael_jackson);
        Person p2 = new Person("Johnny Cash", "Singer", "Country", R.raw.johney_cash);
        Person p3 = new Person("Muhammad Ali", "Sport", "Box", R.raw.muhammad_ali);
        Person p4 = new Person("Lionel Messi", "Sport", "Soccer", R.raw.messi);

        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}