package com.example.sefakkahriman.activitylifecycleandintent;

import android.app.Activity;

/**
 * Created by SefakKahriman on 3/27/18.
 */

public class Tagger {

    public static String get(Activity test) {
        return test.getClass().getSimpleName()+"_TAG";
    }
}