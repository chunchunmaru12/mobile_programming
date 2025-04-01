package com.example.chaptersix;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SimpleListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_simple_list_view);
        //        ListView simpleListView = findViewById(R.id.simpleListView);
//
//        String[] fruits = {"Apple", "Mango", "Banana", "Cherry", "Orange", "Grapes"};
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, fruits);
//
//        simpleListView.setAdapter(adapter);
//        simpleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(SimpleListViewActivity.this, "You clicked: " + fruits[position], Toast.LENGTH_LONG ).show();
//            }
//        });

        ListView simpleListView = findViewById(R.id.simpleListView);

        String[] titles = {"Title 1", "Title 2", "Title 3", "Title 4","Title 1", "Title 2", "Title 3", "Title 4","Title 1", "Title 2", "Title 3", "Title 4",
        };

        String[] description = {
                "Description 1", "Description 2", "Description 3", "Description 4","Description 1", "Description 2", "Description 3", "Description 4","Description 1", "Description 2", "Description 3", "Description 4"
        };

        int[] images = {
                R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,   R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,   R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background
        };

        com.example.chaptersix.SimpleListAdapter adapter = new com.example.chaptersix.SimpleListAdapter(this, titles, description, images);

        simpleListView.setAdapter(adapter);
    }
}