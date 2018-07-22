package com.example.sefakkahriman.servicesproject.problem_3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle = intent.getExtras();
        String str = bundle.getString("name");
        Toast.makeText(context, str, Toast.LENGTH_LONG).show();
    }
}
