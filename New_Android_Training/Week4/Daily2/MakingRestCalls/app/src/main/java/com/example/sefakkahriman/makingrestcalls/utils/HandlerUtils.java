package com.example.sefakkahriman.makingrestcalls.utils;


//we will use this class to pass data to the main thread

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;



public class HandlerUtils {
    public static HandlerUtils instance = null;
    private static final String STRING_KEY = "key";
    Handler handler;

    private HandlerUtils() {
        //denies initiation
    }

    //this is called lazy initialization
    public static HandlerUtils getDefault(){
        if (instance == null) {
            instance = new HandlerUtils();
        }
        return  instance;
    }

    public void registerOwner(Handler.Callback object) {

        if (object instanceof Handler.Callback) {
            handler = new Handler((Handler.Callback) object);
        }
    }

    public void unregisterOwner() {
        this.handler = null;
    }

    public void sendMessage(String data) {
        Message message = new Message();
        Bundle bundle = new Bundle();
        bundle.putString(STRING_KEY, data);
        message.setData(bundle);
        handler.sendMessage(message);
    }

    public String parseMessage(Message message) {
        return message.getData().getString(STRING_KEY);
    }



}
