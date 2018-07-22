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

public class MyReceiver extends BroadcastReceiver {

    public List<Person> personList;
    RecyclerView rvPerson;
    Context context;

    public MyReceiver(RecyclerView rvPerson) {
        this.rvPerson = rvPerson;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        this.context = context;
        Log.d(TAG, "onReceive: ");

        switch (intent.getAction()) {

            case "myAction":

                personList = intent.getParcelableArrayListExtra("name");
                populateRecycleView(personList);

                break;

            case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                boolean state1 = intent.getBooleanExtra("state", false);
                Toast.makeText(context, String.valueOf(state1), Toast.LENGTH_SHORT).show();

                break;

            case Intent.ACTION_BATTERY_OKAY:
                boolean state2 = intent.getBooleanExtra("state", false);
                Toast.makeText(context, String.valueOf(state2), Toast.LENGTH_SHORT).show();

                break;

            case Intent.ACTION_BATTERY_LOW:
                boolean state3 = intent.getBooleanExtra("state", false);
                Toast.makeText(context, String.valueOf(state3), Toast.LENGTH_SHORT).show();

                break;

            case Intent.ACTION_HEADSET_PLUG:
                boolean state4 = intent.getBooleanExtra("state", false);
                Toast.makeText(context, String.valueOf(state4), Toast.LENGTH_SHORT).show();

                break;

            case Intent.ACTION_USER_UNLOCKED:
                boolean state5 = intent.getBooleanExtra("state", false);
                Toast.makeText(context, String.valueOf(state5), Toast.LENGTH_SHORT).show();

                break;
        }
    }

    private void populateRecycleView(List<Person> personList) {
        if (personList == null) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(personList, context);
        rvPerson.setLayoutManager(layoutManager);
        rvPerson.setAdapter(adapter);
    }
}