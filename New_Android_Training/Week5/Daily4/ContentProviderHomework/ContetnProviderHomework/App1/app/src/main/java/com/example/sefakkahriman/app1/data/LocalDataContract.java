package com.example.sefakkahriman.app1.data;

import android.provider.BaseColumns;

public class LocalDataContract {

    public static final String NAME = "Person.db";
    public static final int VERSION = 1;

    public static final String TABLE_PERSON = "person";

    public static class DDL {

        public static final String CREATE_PERSON_TABLE
                = "CREATE TABLE " + TABLE_PERSON + "(" +
                Person.FIRST_NAME + " TEXT, " +
                Person.LAST_NAME + " TEXT, " +
                Person.GENDER + " TEXT," +
                Person.ADDRESS + " TEXT, " +
                Person.AGE + " TEXT)";
    }

    public static class DML {
        public static final String GET_ALL_PERSON = "SELECT * FROM PERSON" ;
    }

    public static class Person implements BaseColumns {

        public static final String FIRST_NAME = "first_name";
        public static final String LAST_NAME = "last_name";
        public static final String GENDER = "gender";
        public static final String ADDRESS = "address";
        public static final String AGE = "age";

    }
}