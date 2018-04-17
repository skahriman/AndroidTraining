package com.sefakkahriman.employeecontentprovider.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.sefakkahriman.employeecontentprovider.model.EmployeeContract;

public class EmployeeDataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "employee.db";
    public static final int DATABASE_VERSION = 1;


    public EmployeeDataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            EmployeeContract.onCreate(sqLiteDatabase);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }



    //implement logic if you want to upgrade the current database.
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}