package com.example.sefakkahriman.makingrestcalls.client;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class NativeCallHelper {

    public static final String TAG = HttpURLConnection.class.getSimpleName() + "_TAG";

    public void makeCall() {

        //need to create separate thread to for REST call
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String BaseUrl = "http://www.mocky.io/v2/5b4cc67331000064005eba28";
                    URL url = new URL(BaseUrl);

                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                    InputStream stream = httpURLConnection.getInputStream();

                    Scanner scanner = new Scanner(stream);

                    while (scanner.hasNext()) {
                        Log.d(TAG, "run: " + scanner.nextLine());
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
