package com.example.sefakkahriman.makingrestcalls.utils;

import android.os.Bundle;
import android.os.Message;

import java.util.logging.Handler;

public class HandlerUtils {
    public static HandlerUtils instance = null;
    Handler handler;

    private   HandlerUtils() {

    }

    public static HandlerUtils getDefault() {
        if(instance == null) {
            instance = new HandlerUtils();
        }
        return  instance;
    }

    public void setReceiver() {
        this.handler = handler;
    }

    public void sendMessage(String message) {
        Message handlerMessage = new Mesage();
        //Bundle bundle =
    }


}
