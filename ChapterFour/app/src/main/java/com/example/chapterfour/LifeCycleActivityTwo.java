package com.example.chapterfour;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LifeCycleActivityTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        Log.d("TWO_ON_CREATE","activity created");
        Button backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Closes current activity and returns to the previous one
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TWO_ON_START","Activity is started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TWO_ON_RESUME","Activity is resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TWO_ON_PAUSE","Activity is paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TWO_ON_STOP","Activity is stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TWO_ON_DESTROY","Activity is destroyed");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("TWO_ON_RESTART","Activity is restarted");
    }
}