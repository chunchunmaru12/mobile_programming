package com.example.chaptersix;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GridViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        GridView gridView=findViewById(R.id.gridView);

        String names[]={"Ram","Shivam","Hari","Sita","Geeta"};
        ArrayAdapter<String> adapter= new ArrayAdapter<>(
                this,R.layout.simple_gridview_items,
                R.id.gridItemText,
                names
        );

        String[] titles = {"Keqing", "Furina","Ganyu","Shinobu"
        };

        String[] description = {
                "meow meow meow meow meow meow ", "meow meow meow meow meow meow ","meow meow meow meow meow meow ","meow meow meow meow meow meow "};

        int[] images = {
               R.mipmap.keqing_image_foreground,R.mipmap.ic_launcher_foreground,R.mipmap.ganyu_image_layer,R.mipmap.shinobu_image_foreground
        };
        CustomGridAdapter customGridAdapter= new CustomGridAdapter(this,titles,description,images);

        gridView.setAdapter(customGridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String selectedItem = names[position];
                Toast.makeText(getApplicationContext(), "You clicked: " + selectedItem, Toast.LENGTH_SHORT).show();
            }
        });

    }
}