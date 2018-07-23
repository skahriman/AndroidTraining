package com.example.sefakkahriman.zooproject.data;

import android.content.Context;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class SoundPlayer extends AppCompatActivity{

    MediaPlayer mediaPlayer;
    Context context;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void playSound(String string) {

        switch (string) {

            case "LION":

                break;
        }

    }
}
