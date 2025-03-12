package com.example.chapterfive;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;

public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fragment);
        Button btnOne = findViewById(R.id.btn1);
        Button btnTwo = findViewById(R.id.btn2);

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentOne oneFragment= new FragmentOne();
                FragmentManager fragmentManager= getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragTest, oneFragment).commit();

            }
        });
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTwo twoFragment= new FragmentTwo();
                FragmentManager fragmentManager= getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragTest, twoFragment).commit();

//                getSupportFragmentManager()
//                        .beginTransaction()
//                        .add(R.id.fragTest, new FragmentTwo())
//                        .commit();
            }
        });
        FragmentOne oneFragment= new FragmentOne();
        FragmentManager fragmentManager= getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragTest, oneFragment).commit();

    }
}