package com.example.chapterfour;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LifeCycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_life_cycle);

        Log.d("MD_ON_CREATE","Activity is created");
        Button nextButton = findViewById(R.id.next_button);
          if (nextButton == null) {
            Log.e("LifeCycleActivity", "nextButton is null. Check your XML layout.");
        }

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LifeCycleActivity.this, LifeCycleActivityTwo.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MD_ON_START","Activity is started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MD_ON_RESUME","Activity is resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MD_ON_PAUSE","Activity is paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MD_ON_STOP","Activity is stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MD_ON_DESTROY","Activity is destroyed");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MD_ON_RESTART","Activity is restarted");
    }
}