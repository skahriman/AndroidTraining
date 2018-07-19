package com.example.sefakkahriman.makingrestcalls;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.sefakkahriman.makingrestcalls.client.NativeCallHelper;
import com.example.sefakkahriman.makingrestcalls.client.OkhttpHelper;
import com.example.sefakkahriman.makingrestcalls.client.RetrofitHelper;
import com.example.sefakkahriman.makingrestcalls.model.CustomUser;
import com.example.sefakkahriman.makingrestcalls.model.Result;
import com.example.sefakkahriman.makingrestcalls.utils.HandlerUtils;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Handler.Callback {

    public static final String TAG = MainActivity.class.getSimpleName() + "_TAG";
    public static final String BASE_URL = "https://randomuser.me/";

    private NativeCallHelper callHelper;
    private OkhttpHelper okhttpHelper;
    private TextView tvResult;
    private RetrofitHelper retrofitHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvResults);

        //This part is for changing policy no to trigger ANR
//        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder());
        initClients();

    }

    private void initClients() {
        callHelper = new NativeCallHelper();
        okhttpHelper = new OkhttpHelper();
        retrofitHelper = new RetrofitHelper();
    }

    public void onNativeCall(View view) {
        callHelper.makeCall();
    }

    public void onOkhttp(View view) throws IOException {
        switch (view.getId()) {
            case R.id.btnOkhttpSync:
                okhttpHelper.executeSyncCall();
                break;
            case R.id.btnOkhttpAsync:
                okhttpHelper.executeAsysnCall();
                break;
        }
    }

    @Override
    public boolean handleMessage(Message message) {
        tvResult.setText(HandlerUtils.getDefault().parseMessage(message));
        return false;
    }

    @Override
    protected void onStart() {
        super.onStart();
        HandlerUtils.getDefault().registerOwner(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        HandlerUtils.getDefault().unregisterOwner();
    }

    public void onRetrofit(View view) {

        final String results = "20";
        switch (view.getId()) {

            case R.id.btnRetroSync:
                retrofitHelper.makeCallSync(results);
                break;

            case R.id.btnRetroAsync:
                retrofitHelper.makeCallAsync(results);
                break;

            case R.id.btnRetroRxJava:
                retrofitHelper.makeCallRxJava(results);
                break;
            case R.id.btnRetroRxCustom:
                retrofitHelper.makeCallCustomRx(results, new RetrofitHelper.RetrofitCallback() {
                            @Override
                            public void onResults(CustomUser customUser) {

                            }
                        }
                );
                break;

            case R.id.btnRetroRxCustomUserName:
                retrofitHelper.makeCallCustomRxJava(results, new RetrofitHelper.ListCallBack() {
                    @Override
                    public void onResults(List<Result> resultList) {
                        for (Result result: resultList) {
                            Log.d(TAG, "onResults: on Name " + results);
                        }
                    }
                });
                break;
        }
    }
}
