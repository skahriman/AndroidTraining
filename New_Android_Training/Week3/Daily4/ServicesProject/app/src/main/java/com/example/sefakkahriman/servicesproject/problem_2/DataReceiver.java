package com.example.sefakkahriman.servicesproject.problem_2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.sefakkahriman.servicesproject.R;

import java.util.List;

import static com.example.sefakkahriman.servicesproject.problem_2.MyIntentService.TAG;

public class DataReceiver extends BroadcastReceiver {

    List<Person> list;

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d(TAG, "onReceive: ");

        switch (intent.getAction()) {
            case "myAction":
                Toast.makeText(context, intent.getStringExtra("data"), Toast.LENGTH_SHORT).show();
                break;

            case "myIntentAction":
                String result = intent.getStringExtra("result");
                Toast.makeText(context, result, Toast.LENGTH_SHORT).show();
                Log.d("RECEIVER_TAG", "onReceive: "+ result);


                break;
        }

    }
}
