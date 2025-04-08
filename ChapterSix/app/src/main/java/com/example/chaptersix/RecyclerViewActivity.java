package com.example.chaptersix;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    // Sample Data
    String[] names = {"Furina", "Nahida", "Raiden", "Yae Miko","Furina", "Nahida", "Raiden", "Yae Miko","Furina", "Nahida", "Raiden", "Yae Miko"};
    String[] phones = {"+977-985112105", "+977-9841000001", "+977-9841000002", "+977-9841000003","+977-985112105", "+977-9841000001", "+977-9841000002", "+977-9841000003","+977-985112105", "+977-9841000001", "+977-9841000002", "+977-9841000003"};
    int[] images = {R.mipmap.ic_launcher_foreground,R.mipmap.shinobu_image_foreground,R.mipmap.ganyu_image_layer,R.mipmap.shinobu_image_foreground,R.mipmap.ic_launcher_foreground,R.mipmap.shinobu_image_foreground,R.mipmap.ganyu_image_layer,R.mipmap.shinobu_image_foreground,R.mipmap.ic_launcher_foreground,R.mipmap.shinobu_image_foreground,R.mipmap.ganyu_image_layer,R.mipmap.shinobu_image_foreground};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler_view);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, names, phones, images);
        recyclerView.setAdapter(adapter);
    }
}
