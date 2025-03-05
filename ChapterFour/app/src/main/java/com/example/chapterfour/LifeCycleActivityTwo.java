package com.example.chapterfour;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class LifeCycleActivityTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_life_cycle_two);

        Log.d("MD_Two_ON_CREATE","Activity is created");
        Button nextButton = findViewById(R.id.back_button);
        if (nextButton == null) {
            Log.e("LifeCycleActivity", "nextButton is null. Check your XML layout.");
        }
        Intent intent = getIntent();
        String mystring = intent.getStringExtra("STRING_KEY");
        int myInt = intent.getIntExtra("INT_KEY",0);
        boolean myBoolean = intent.getBooleanExtra("BOOLEAN_KEY",false);
        ArrayList<String> myList = intent.getStringArrayListExtra("LIST_KEY");
        TextView textView = findViewById(R.id.TextView);
        textView.setText("Recieved Data from first Activity:\n String : "+mystring+"\n Int : "+myInt+"\n Boolean: "+myBoolean+"\n List :"+myList);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MD_Two_ON_START","Activity is started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MD_Two_ON_RESUME","Activity is resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MD_Two_ON_PAUSE","Activity is paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MD_Two_ON_STOP","Activity is stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MD_Two_ON_DESTROY","Activity is destroyed");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MD_Two_ON_RESTART","Activity is restarted");
    }
}