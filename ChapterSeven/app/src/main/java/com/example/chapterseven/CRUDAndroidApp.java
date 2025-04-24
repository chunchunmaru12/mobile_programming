package com.example.chapterseven;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class CRUDAndroidApp extends AppCompatActivity {
    TextView resultText;
    DBHelper dbHelper;
    Button insert,select,update,delete;
    EditText id,name,address;
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
        resultText=findViewById(R.id.resultText);
        dbHelper = new DBHelper(this);


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idEntered=id.getId();
                String nameEntered= name.getText().toString();
                String addressEntered=address.getText().toString();
                dbHelper.updateData( idEntered ,nameEntered,addressEntered);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idEntered=id.getId();

                dbHelper.deleteData( idEntered );
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
                ArrayList<Integer> ids = new ArrayList<Integer>();
                ArrayList<String> names = new ArrayList<String>(), address = new ArrayList<String>();

                Cursor cursor = dbHelper.selectData();
                while (cursor.moveToNext()){
                    ids.add(cursor.getInt(0));
                    names.add(cursor.getString(1));
                    address.add(cursor.getString(2));
                }
                String data = "";
                for(int i = 0; i<ids.size();i++){
                    data += "Id=" + ids.get(i) + "\t Name = " + names.get(i) + "\t Address=" + address.get(i) + "\n";
                }
                resultText.setText(data);
            }
    });


    }
}