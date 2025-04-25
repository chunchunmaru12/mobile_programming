package com.example.chapterseven;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CRUDAndroidApp extends AppCompatActivity {
    TextView resultText;
    DBHelper dbHelper;
    Button insert,select,update,delete;
    EditText id,name,address;
     RecyclerView recyclerView;
     CRUDAdapter crudAdapter;
     List<DataModel> displayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_crudandroid_app);
        id=findViewById(R.id.enterId);
        name=findViewById(R.id.enterName);
        address=findViewById(R.id.enterAddress);
        insert=findViewById(R.id.insert);
        select=findViewById(R.id.select);
        update=findViewById(R.id.update);
        delete=findViewById(R.id.delete);
        recyclerView = findViewById(R.id.recyclerViewCrud);
        dbHelper = new DBHelper(this);
        displayList=new ArrayList<>();
        crudAdapter=new CRUDAdapter(displayList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(crudAdapter);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idEntered = Integer.parseInt(id.getText().toString());
                String nameEntered = name.getText().toString();
                String addressEntered = address.getText().toString();
                dbHelper.updateData(idEntered, nameEntered, addressEntered);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idEntered = Integer.parseInt(id.getText().toString());
                dbHelper.deleteData(idEntered);
            }
        });




        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idEntered=Integer.parseInt(id.getText().toString());
                String nameEntered= name.getText().toString();
                String addressEntered=address.getText().toString();
                dbHelper.insertData(idEntered,nameEntered,addressEntered);
            }
        });

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayList.clear();
                Cursor cursor = dbHelper.selectData();
                while (cursor.moveToNext()) {
                    int id = cursor.getInt(0);
                    String name = cursor.getString(1);
                    String address = cursor.getString(2);

                    displayList.add(new DataModel(id, name, address));
                }
                crudAdapter.setTasks(displayList);
            }
        });





    }
}