package com.example.chapterseven;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="mydb.db";
    private static final int DATABASE_VERSION=1;
    private Context context;

    public DBHelper(@Nullable Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createQuery="CREATE TABLE mytable(id INTEGER PRIMARY KEY, name TEXT, address TEXT)";
        db.execSQL(createQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+DATABASE_NAME);
        onCreate(db);
    }
    public void insertData(int id, String name, String address) {
        SQLiteDatabase db = this.getWritableDatabase();


        Cursor cursor = db.rawQuery("SELECT id FROM mytable WHERE id = ?", new String[]{String.valueOf(id)});

        if (cursor.moveToFirst()) {
            Toast.makeText(context, "ID already exists! Please enter a different ID", Toast.LENGTH_LONG).show();
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", id);
            contentValues.put("name", name);
            contentValues.put("address", address);

            long result = db.insert("mytable", null, contentValues);

            if (result == -1) {
                Toast.makeText(context, "Insert failed", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Data inserted successfully", Toast.LENGTH_SHORT).show();
            }
        }

        cursor.close(); // Always close the cursor

    }

    public void updateData(int id,String name,String address){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("address",address);

        db.update("mytable",contentValues,"id=?",new String[]{String.valueOf(id)});
        db.close();
    }
    public Cursor selectData(){
        SQLiteDatabase db= this.getReadableDatabase();
        String query="SELECT * FROM mytable";
        return db.rawQuery(query,null);
    }

    public void deleteData(int id){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete("mytable","id=?",new String[]{String.valueOf(id)});

    }


    }


