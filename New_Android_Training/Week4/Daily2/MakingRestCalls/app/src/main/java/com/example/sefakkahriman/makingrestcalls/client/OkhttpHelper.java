package com.example.sefakkahriman.makingrestcalls.client;

import android.util.Log;

import com.example.sefakkahriman.makingrestcalls.model.APIResponse;
import com.example.sefakkahriman.makingrestcalls.utils.HandlerUtils;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.sefakkahriman.makingrestcalls.client.NativeCallHelper.TAG;

public class OkhttpHelper {

    public static final String  BASE_URL = "https://randomuser.me/api?results=10";
    public static final String  BASE_URL2 = "https://randomuser.me/";
    public static final String  PATH = "api";
    public static final String  QUERY_RESULTS = "results";


    OkHttpClient client;
    private final Request request;

    public OkhttpHelper() {
        client = new OkHttpClient();
        request = new Request.Builder()
                .url(getUrl())
                .build();
    }

    public HttpUrl getUrl() {
        HttpUrl  httpUrl = new HttpUrl.Builder()
                .scheme("https")
                .host("randomuser.me")
                .addPathSegment(PATH)
                .addQueryParameter(QUERY_RESULTS, "10")
                .build();

        return httpUrl;
    }


    //need to create a new thread
    public void executeSyncCall() throws IOException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                String responseStr = null;
                try {
                    responseStr = client.newCall(request).execute().body().string();
                    Gson gson = new Gson();
                    APIResponse APIResponse = gson.fromJson(responseStr, APIResponse.class);
                    Log.d(TAG, "run: executeSyncCall: Result size: " +  APIResponse.getResults().size());
                    HandlerUtils.getDefault().sendMessage(String.valueOf(APIResponse.getResults().size()));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void executeAsysnCall() {
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                Gson gson = new Gson();
                APIResponse APIResponse = gson.fromJson(response.body().string(), APIResponse.class);
                Log.d(TAG, "onResponse: Thread" + Thread.currentThread().getName());
                Log.d(TAG, "onResponse: Size" + APIResponse.getResults().size());

            }
        });
    }
}









