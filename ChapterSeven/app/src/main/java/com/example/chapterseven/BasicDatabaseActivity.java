package com.example.chapterseven;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class BasicDatabaseActivity extends AppCompatActivity {

    BasicDatabaseHelper dbHelper;
    Button insertBtn, showBtn;
    ListView listView;
    ArrayList<String> userList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_database);

        insertBtn = findViewById(R.id.insertBtn);
        showBtn = findViewById(R.id.showBtn);
        listView = findViewById(R.id.listView);

        dbHelper = new BasicDatabaseHelper(this);

        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.insertUser(" User "+(int)(Math.random()*1000));

               
            }
        });

        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userList = dbHelper.getAllUsers();
                adapter = new ArrayAdapter<>(BasicDatabaseActivity.this,
                        android.R.layout.simple_list_item_1, userList);
                listView.setAdapter(adapter);
            }
        });
    }
}
