package com.example.DBPersons;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBPersons {

    private static final String DATABASE_NAME = "persons.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "PersonsTable";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_LOGIN = "login";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_SURNAME = "surname";

    private static final int NUM_COLUMN_ID = 0;
    private static final int NUM_COLUMN_LOGIN = 1;
    private static final int NUM_COLUMN_PASSWORD = 2;
    private static final int NUM_COLUMN_NAME = 3;
    private static final int NUM_COLUMN_SURNAME = 4;

    private SQLiteDatabase mDataBase;

    public DBPersons(Context context) {
        OpenHelper mOpenHelper = new OpenHelper(context);
        mDataBase = mOpenHelper.getWritableDatabase();
    }

    public long insert(String login,String password,String name,String surname) {
        ContentValues cv=new ContentValues();
        cv.put(COLUMN_LOGIN, login);
        cv.put(COLUMN_PASSWORD, password);
        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_SURNAME,surname);
        return mDataBase.insert(TABLE_NAME, null, cv);
    }

    public int update(Persons md) {
        ContentValues cv=new ContentValues();
        cv.put(COLUMN_LOGIN, md.getLogin());
        cv.put(COLUMN_PASSWORD, md.getPassword());
        cv.put(COLUMN_NAME, md.getName());
        cv.put(COLUMN_SURNAME,md.getSurname());
        return mDataBase.update(TABLE_NAME, cv, COLUMN_ID + " = ?",new String[] { String.valueOf(md.getId())});
    }

    public void deleteAll() {
        mDataBase.delete(TABLE_NAME, null, null);
    }

    public void delete(long id) {
        mDataBase.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[] { String.valueOf(id) });
    }

    public Persons select(long id) {
        Cursor mCursor = mDataBase.query(TABLE_NAME, null, COLUMN_ID + " = ?", new String[]{String.valueOf(id)}, null, null, null);

        mCursor.moveToFirst();
        String Login = mCursor.getString(NUM_COLUMN_LOGIN);
        String Password = mCursor.getString(NUM_COLUMN_PASSWORD);
        String Name = mCursor.getString(NUM_COLUMN_NAME);
        String Surname =mCursor.getString(NUM_COLUMN_SURNAME);
        return new Persons(id, Login, Password, Name,Surname);
    }

    public ArrayList<Persons> selectAll() {
        Cursor mCursor = mDataBase.query(TABLE_NAME, null, null, null, null, null, null);

        ArrayList<Persons> arr = new ArrayList<Persons>();
        mCursor.moveToFirst();
        if (!mCursor.isAfterLast()) {
            do {
                long id = mCursor.getLong(NUM_COLUMN_ID);
                String Login = mCursor.getString(NUM_COLUMN_LOGIN);
                String Password = mCursor.getString(NUM_COLUMN_PASSWORD);
                String Name = mCursor.getString(NUM_COLUMN_NAME);
                String Surname=mCursor.getString(NUM_COLUMN_SURNAME);
                arr.add(new Persons(id, Login, Password, Name,Surname));
            } while (mCursor.moveToNext());
        }
        return arr;
    }

    private class OpenHelper extends SQLiteOpenHelper {

        OpenHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            String query = "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_LOGIN+ " TEXT, " +
                    COLUMN_PASSWORD + " TEXT, " +
                    COLUMN_NAME + " TEXT,"+
                    COLUMN_SURNAME+" TEXT);";
            db.execSQL(query);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }

}
