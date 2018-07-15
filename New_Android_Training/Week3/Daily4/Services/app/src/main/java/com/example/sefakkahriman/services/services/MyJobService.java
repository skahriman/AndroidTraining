package com.example.sefakkahriman.services.services;

import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.RequiresApi;
import android.util.Log;

// This class must extend JobSerice not Service
// NEDDS PERMISSION
// in manifest file ==> android:permission="android.permission.BIND_JOB_SERVICE">

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MyJobService extends JobService {

    public static final String TAG = MyJobService.class.getSimpleName() + "_TAG";

    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        Log.d(TAG, "onStartJob: ");
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        Log.d(TAG, "onStopJob: ");
        return false;
    }
}
