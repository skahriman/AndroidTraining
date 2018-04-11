package com.example.sefakkahriman.makingrestcalls;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class NativeClient extends Thread {

    String Base_URL = ;
    String BASEURL;

    StringBuilder stringBuilder;

    public NativeClient(String BASE_URL) {
        this.BASE_URL = BASE_URL;
    }

    @Override
    public void run() {
        super.run();


            URL url =  new URL(BASEURL);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            InputStream inputStream = httpURLConnection.getInputStream();

            Scanner scanner = new Scanner(inputStream);

            while(scanner.hasNext()) {
                stringBuilder.append(scanner.nextLine());
            }

            Log.d(TAG , "run "  + scanner.nextLine());

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
