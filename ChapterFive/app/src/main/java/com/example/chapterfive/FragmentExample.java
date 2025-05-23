package com.example.chapterfive;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FragmentExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fragment_example);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragmentLayoutOne, new FragmentFirst())
                .commit();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragmentLayoutTwo, new FragmentSecond())
                .commit();


    }
}