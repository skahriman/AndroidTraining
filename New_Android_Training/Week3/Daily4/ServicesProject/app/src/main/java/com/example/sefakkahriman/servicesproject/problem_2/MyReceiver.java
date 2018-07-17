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
                String size = Integer.toString(personList.size());
//                Toast.makeText(context, "size ===> " + size, Toast.LENGTH_SHORT).show();
                populateRecycleView(personList);

                break;
        }
    }

    private void populateRecycleView(List<Person> personList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(personList, context);
        rvPerson.setLayoutManager(layoutManager);
        rvPerson.setAdapter(adapter);
    }
}
