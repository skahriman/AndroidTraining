package com.example.sefakkahriman.homework.problem3;

import android.content.Context;

public class MemoryLeakClass {

    private static MemoryLeakClass memoryLeakClassInstance;

    private Context context;

    private MemoryLeakClass(Context context) {
        this.context = context;
    }

    public static MemoryLeakClass getMemoryLeakClass(Context context) {
        if (memoryLeakClassInstance == null) {
            memoryLeakClassInstance = new MemoryLeakClass(context);
        }

        return memoryLeakClassInstance;
    }

}
