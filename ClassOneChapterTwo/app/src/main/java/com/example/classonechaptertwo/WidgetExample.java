package com.example.classonechaptertwo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
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

        CheckBox checkBoxOne = findViewById(R.id.checkbox1);

        RadioButton radioButtonMale = findViewById(R.id.radioBtnMale);
        RadioButton radioButtonFemale = findViewById(R.id.radioBtnFemale);

        Spinner spin = findViewById(R.id.spinner);

        Button btnOne = findViewById(R.id.btn1);
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(WidgetExample.this,"Button has been clicked",Toast.LENGTH_SHORT).show();
                //Snackbar.make(view,"SnackBar Example", Snackbar.LENGTH_SHORT).show();
                String gender="Not selected";
                String selectedOption;
                selectedOption= spin.getSelectedItem().toString();
                String text = editTextOne.getText().toString();
                gender=radioButtonMale.isChecked() ?" Male": radioButtonFemale.isChecked() ? " Female": " not selected";
                boolean isChecked=checkBoxOne.isChecked();
                if(isChecked){
                    Toast.makeText(WidgetExample.this,"Value Entered: "+ text+" Gender"+gender +" Selected: "+selectedOption,Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(WidgetExample.this,"Please accept terms and condition" ,Toast.LENGTH_SHORT).show();
                }

            }
        });

        checkBoxOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(getApplicationContext(),"Checkbox state: "+ b, Toast.LENGTH_SHORT).show();
            }
        });


    }
}