package com.example.tonghop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB_Helper extends SQLiteOpenHelper {
    public static final String DB_Name = "Login.db";

    public DB_Helper(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create Table users (username TEXT primary key, pass TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists users");
    }

    public Boolean insertDATA(String username, String pass){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("pass",pass);
        long result = sqLiteDatabase.insert("users", null,contentValues);
        if (result == -1)
            return false;
        else
            return true;

    }

    public Boolean checkUsername(String username){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("Select * from users where username = ? ",new String[]{username});
        if (cursor.getCount()>0 )
            return true;
        else
            return false;
    }

    public Boolean checkUsernamePass(String username, String pass){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("Select * from users where username = ? and pass = ? ",new String[]{username,pass});
        if (cursor.getCount()>0 )
            return true;
        else
            return false;
    }
}
