package com.example.classonechaptertwo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class WidgetExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_widget_example);

        TextView textViewOne = findViewById(R.id.textView1);

        EditText editTextOne = findViewById(R.id.editText1);

        Button btnOne = findViewById(R.id.btn1);
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(WidgetExample.this,"Button has been clicked",Toast.LENGTH_SHORT).show();
                //Snackbar.make(view,"SnackBar Example", Snackbar.LENGTH_SHORT).show();
                String text = editTextOne.getText().toString();
                Toast.makeText(WidgetExample.this,"Value Entered: "+ text,Toast.LENGTH_LONG).show();
            }
        });



    }
}