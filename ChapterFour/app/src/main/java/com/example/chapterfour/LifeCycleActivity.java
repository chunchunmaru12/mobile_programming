package com.example.chapterfour;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

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
          Button browse=findViewById(R.id.browserBtn);
          browse.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
//                  Intent intent = new Intent(Intent.ACTION_VIEW);
//                  intent.setData(Uri.parse("geo:37.7749, -122.4194?1=san+francisco"));
                  //Intent intent = new Intent(Intent.ACTION_SENDTO);
//                  intent.setData(Uri.parse("mailto:example@gmail.com"));
//                  intent.putExtra(Intent.EXTRA_SUBJECT,"BCA Testing");

                 // intent.setData(Uri.parse("https://www.google.com"));
                  Intent intent = new Intent(Intent.ACTION_PICK);
                  intent.setType("image/*");

                  startActivity(intent);
              }
          });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LifeCycleActivity.this, LifeCycleActivityTwo.class);
                intent.putExtra("STRING_KEY", "HELLO, ANDROID!!!!!");
                intent.putExtra("INT_KEY",42);
                intent.putExtra("BOOLEAN_KEY", true);

                ArrayList<String> myList = new ArrayList<>();
                myList.add("Item1 ");
                myList.add("Item2 ");
                intent.putStringArrayListExtra("LIST_KEY",myList);

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