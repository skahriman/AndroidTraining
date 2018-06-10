package com.example.sefakkahriman.demo;

import java.util.Date;

public class MyDateImpl implements MyDate {

    private static long mDate;

    MyDateImpl(){
        this.mDate = new Date().getTime();
    }

    @Override
    public long getDate() {
        return mDate;
    }
}
