package com.example.sefakkahriman.multithreding.threads;

import android.os.AsyncTask;
import android.widget.TextView;

import com.example.sefakkahriman.multithreding.MyTasks;
import com.example.sefakkahriman.multithreding.R;

public class MyAsyncTask extends AsyncTask <String, Integer, String> {

    TextView tvMain;

    public MyAsyncTask(TextView tvMain) {
        this.tvMain = tvMain;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //main
        tvMain.setText("Setting up task");
    }

    @Override
    protected String doInBackground(String... strings) {


        MyTasks.startJob(this.getClass().getSimpleName());
        return "Job Done";
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        tvMain.setText(s);
    }
}
