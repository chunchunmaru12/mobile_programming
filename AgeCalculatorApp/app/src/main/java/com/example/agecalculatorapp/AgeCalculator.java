package com.example.agecalculatorapp;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

import java.util.Calendar;

public class AgeCalculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_age_calculator);

        Button birthDate=findViewById(R.id.btnBirthDate);
        birthDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBirthCalendar();
            }
        });
        Button currentDate=findViewById(R.id.btnCurrentDate);
        currentDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCurrentCalendar();
            }
        });
    }
    public  void showBirthCalendar(){
        final Calendar c = Calendar.getInstance();
        int year =c.get(Calendar.YEAR);
        int month =c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        TextView inputBirth=findViewById(R.id.inputBirthDate);
        DatePickerDialog datePickerDialog=new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        String selectedDate= i2 +"-"+ (i1 + 1)+"-"+i;
                        inputBirth.setText(selectedDate);
//                        Snackbar.make(findViewById(android.R.id.content),"Selected date:"+selectedDate, Snackbar.LENGTH_SHORT).show();
                    }
                },year,month,day);
        datePickerDialog.show();
    }
    public void showCurrentCalendar(){
        final Calendar c = Calendar.getInstance();
        int year =c.get(Calendar.YEAR);
        int month =c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        TextView inputBirth=findViewById(R.id.currentDateTxt);
        DatePickerDialog datePickerDialog=new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        String selectedDate= i2 +"-"+ (i1 + 1)+"-"+i;
                        inputBirth.setText(selectedDate);
//                        Snackbar.make(findViewById(android.R.id.content),"Selected date:"+selectedDate, Snackbar.LENGTH_SHORT).show();
                    }
                },year,month,day);
        datePickerDialog.show();
    }


}