package com.example.sefakkahriman.contentproviderhomework.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class LocalDataSource extends SQLiteOpenHelper {

    public LocalDataSource(Context context) {
        super(context, LocalDataContract.NAME, null, LocalDataContract.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(LocalDataContract.DDL.CREATE_PERSON_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //
    public long savePerson(Person person) {

        SQLiteDatabase database = getWritableDatabase();

//        save person with content values
        ContentValues contentValues = new ContentValues();

        contentValues.put(LocalDataContract.Person.FIRST_NAME, person.getFirstName());
        contentValues.put(LocalDataContract.Person.LAST_NAME, person.getLastName());
        contentValues.put(LocalDataContract.Person.GENDER, person.getGender());
        contentValues.put(LocalDataContract.Person.ADDRESS, person.getAddress());
        contentValues.put(LocalDataContract.Person.AGE, person.getAge());

//        insert the person into the database
        long rowNumber = database.insert(LocalDataContract.TABLE_PERSON, null, contentValues);

        database.close();
        return rowNumber;

    }

    public List<Person> getAllPerson() {
        SQLiteDatabase database = getWritableDatabase();


        List<Person> personList = new ArrayList<>();

        Cursor cursor = database.rawQuery(LocalDataContract.DML.GET_ALL_PERSON, null);

        if (cursor.moveToFirst()) {

            do {
                Person person = new Person(
                        cursor.getString(cursor.getColumnIndex(LocalDataContract.Person.FIRST_NAME)),
                        cursor.getString(cursor.getColumnIndex(LocalDataContract.Person.LAST_NAME)),
                        cursor.getString(cursor.getColumnIndex(LocalDataContract.Person.GENDER)),
                        cursor.getString(cursor.getColumnIndex(LocalDataContract.Person.ADDRESS)),
                        cursor.getString(cursor.getColumnIndex(LocalDataContract.Person.AGE)));

                personList.add(person);
            } while (cursor.moveToNext());

        }

        database.close();
        return personList;

    }
}