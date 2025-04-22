package com.example.chapterseven;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class BasicDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "SimpleDB.db";
    private static final int DATABASE_VERSION = 1;

    public BasicDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE users(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
        onCreate(db);
    }

    public boolean insertUser(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);//{"name":name} -> key value pairs
        long result = db.insert("users", null, values);
        return result != -1;
    }

    public ArrayList<String> getAllUsers() {
        ArrayList<String> userList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM users", null);
        if (cursor.moveToFirst()) {
            do {
                int index = cursor.getColumnIndex("name");
//              Columns: 0-> id || 1-> name
                if(index!=-1){
                    String user = cursor.getString(index);
                    userList.add(user);

                }
            } while (cursor.moveToNext());
        }
        cursor.close();
        return userList;
    }
}
