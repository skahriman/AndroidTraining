package com.example.sefakkahriman.app1.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class LocalDataSource extends SQLiteOpenHelper {

    public LocalDataSource(Context context) {
        super(context, LocalDataContract.TABLE_PERSON, null, LocalDataContract.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(LocalDataContract.DDL.CREATE_PERSON_TABLE);
        init(sqLiteDatabase);


    }

    private void init(SQLiteDatabase sqLiteDatabase) {

        Person p1 = new Person("Sefak", "Kahriman", "Atlanta", "Male", "37");
        Person p2 = new Person("Ahmet", "Kahriman", "Atlanta", "Male", "39");
        Person p3 = new Person("Nuray", "Kahriman", "Atlanta", "Female", "33");
        Person p4 = new Person("Oguzhan", "Kahriman", "Atlanta", "Male", "21");
        Person p5 = new Person("Anadale", "Kahriman", "Atlanta", "Male", "32");
        Person p6 = new Person("Efe", "Kahriman", "Atlanta", "Male", "3");
        Person p7 = new Person("Ali", "Kahriman", "Atlanta", "Male", "57");
        Person p8 = new Person("Guner", "Kahriman", "Atlanta", "Female", "57");

        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);
        list.add(p7);
        list.add(p8);

        for (Person p : list) {
            ContentValues contentValues = new ContentValues();
            //contentValues.put(LocalDataContract.Animal.ID,a.getId());
            contentValues.put(LocalDataContract.Person.FIRST_NAME, p.getFirstName());
            contentValues.put(LocalDataContract.Person.LAST_NAME, p.getLastName());
            contentValues.put(LocalDataContract.Person.ADDRESS, p.getAddress());
            contentValues.put(LocalDataContract.Person.GENDER, p.getGender());
            contentValues.put(LocalDataContract.Person.AGE, p.getAge());


            sqLiteDatabase.insert(LocalDataContract.TABLE_PERSON, null, contentValues);
        }

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