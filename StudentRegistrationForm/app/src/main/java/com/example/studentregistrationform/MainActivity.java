package com.example.studentregistrationform;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;import android.view.View;
import android.widget.ArrayAdapter;
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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        EditText editOne =findViewById(R.id.edit1);
        EditText editTwo =findViewById(R.id.edit2);
        EditText editThree =findViewById(R.id.edit3);
        CheckBox checkBoxOne = findViewById(R.id.checkbox1);

        RadioButton radioButtonMale = findViewById(R.id.radioBtnMale);
        RadioButton radioButtonFemale = findViewById(R.id.radioBtnFemale);

        Spinner spin = findViewById(R.id.spinner);
        Button btnOne = findViewById(R.id.btn1);
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gender="Not selected";
                String selectedOption;
                selectedOption= spin.getSelectedItem().toString();

                gender=radioButtonMale.isChecked() ?" Male": radioButtonFemale.isChecked() ? " Female": " not selected";
                boolean isChecked=checkBoxOne.isChecked();
                if(isChecked){
                    Intent intent = new Intent(MainActivity.this, DisplayList.class);
                    intent.putExtra("Name",editOne.getText().toString());
                    intent.putExtra("Email",editTwo.getText().toString());
                    intent.putExtra("Age",editThree.getText().toString());
                    intent.putExtra("Gender",gender);
                    intent.putExtra("Course",selectedOption);
                    startActivity(intent);

                }

            }
        });

    }
}