package com.example.studentregistrationform;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DisplayList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_display_list);
        String name = getIntent().getStringExtra("Name");
        String email = getIntent().getStringExtra("Email");
        String age = getIntent().getStringExtra("Age");
        String gender = getIntent().getStringExtra("Gender");
        String course = getIntent().getStringExtra("Course");

        TextView view1 = findViewById(R.id.view1);
        view1.setText(name);
        TextView view2 = findViewById(R.id.view2);
        view2.setText(email);
        TextView view3 = findViewById(R.id.view3);
        view3.setText(age);
        TextView view4 = findViewById(R.id.view4);
        view4.setText(gender);
        TextView view5 = findViewById(R.id.view5);
        view5.setText(course);

    }
}