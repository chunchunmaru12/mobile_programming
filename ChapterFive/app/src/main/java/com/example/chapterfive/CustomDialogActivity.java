package com.example.chapterfive;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;

public class CustomDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);
        Button customDialogBtn=findViewById(R.id.customDialogBtn);
        customDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomDialog();
            }
        });
        Button customDialogBtn2 = findViewById(R.id.customDialogBtn2);
        customDialogBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDialogFragment customDialogFragment= new CustomDialogFragment();
                customDialogFragment.setCustomDialogListener(new CustomDialogFragment.CustomDialogListener() {
                    @Override
                    public void onDialogResult(String input) {
                        Toast.makeText(
                                CustomDialogActivity.this,"Result"+input,Toast.LENGTH_LONG
                        ).show();
                    }
                });
                FragmentManager fragmentManager= getSupportFragmentManager();
                customDialogFragment.show(fragmentManager,"custom_dialog");
            }
        });
    }
    private void showCustomDialog(){
        LayoutInflater inflator = LayoutInflater.from(this);
        View customDialogvView = inflator.inflate(R.layout.custom_dialog,null);
        Button btnCal= customDialogvView.findViewById(R.id.calculateBtn);
        EditText editTextOne = customDialogvView.findViewById(R.id.editOne);
        EditText editTextTwo = customDialogvView.findViewById(R.id.editTwo);
        TextView result = customDialogvView.findViewById(R.id.calculateRes);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Calculate Sum");
        builder.setView(customDialogvView); //<---------setting custom view into alert dialog
        AlertDialog alertDialog=builder.create();

        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    String numOne=editTextOne.getText().toString();
                    String numTwo=editTextTwo.getText().toString();
                    float num1 = Float.parseFloat(numOne);
                    float num2 = Float.parseFloat(numTwo);
                    float sum = (num1+num2);
                    result.setText("Result : " + sum);

                }catch (Exception e){
                    result.setText("Error: " + e.getMessage());
                }
            }
        });
        alertDialog.show();




    }
}