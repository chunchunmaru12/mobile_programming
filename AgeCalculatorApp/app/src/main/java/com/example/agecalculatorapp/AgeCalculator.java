package com.example.agecalculatorapp;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AgeCalculator extends AppCompatActivity {

    int year, month, day;
    TextView inputBirth, currentDate, resYear, resMonth, resDay;
    Button calcBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_age_calculator);

        // Initialize views
        inputBirth = findViewById(R.id.inputBirthDate);
        currentDate = findViewById(R.id.currentDateTxt);
        resYear = findViewById(R.id.resYear);
        resMonth = findViewById(R.id.resMonth);
        resDay = findViewById(R.id.resDay);
        calcBtn = findViewById(R.id.calculateAge);

        // Get today's date
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        // Format and set current date
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String todayDate = sdf.format(c.getTime());
        inputBirth.setText(todayDate);
        currentDate.setText(todayDate);

        findViewById(R.id.btnBirthDate).setOnClickListener(v -> showBirthCalendar());
        findViewById(R.id.btnCurrentDate).setOnClickListener(v -> showCurrentCalendar());

        calcBtn.setOnClickListener(v -> {
            resYear.setText("0");
            resMonth.setText("0");
            resDay.setText("0");

            try {
                DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");

                String birthStr = inputBirth.getText().toString().trim();
                String currStr = currentDate.getText().toString().trim();

                Log.d("AGE_CALC", "Birth: " + birthStr + ", Current: " + currStr);

                LocalDate birthDate = formatter.parseLocalDate(birthStr);
                LocalDate currDate = formatter.parseLocalDate(currStr);

                if (birthDate.isAfter(currDate)) {
                    Snackbar.make(v, "Birth date cannot be after current date", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                Period age = new Period(birthDate, currDate, PeriodType.yearMonthDay());

                resYear.setText(String.valueOf(age.getYears()));
                resMonth.setText(String.valueOf(age.getMonths()));
                resDay.setText(String.valueOf(age.getDays()));

            } catch (Exception e) {
                Snackbar.make(v, "Error calculating age: " + e.getMessage(), Snackbar.LENGTH_LONG).show();
            }
        });
    }

    public void showBirthCalendar() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                (view, i, i1, i2) -> {
                    String selectedDate = String.format("%02d/%02d/%04d", i2, i1 + 1, i);
                    inputBirth.setText(selectedDate);
                }, year, month, day);
        datePickerDialog.show();
    }

    public void showCurrentCalendar() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                (view, i, i1, i2) -> {
                    String selectedDate = String.format("%02d/%02d/%04d", i2, i1 + 1, i);
                    currentDate.setText(selectedDate);
                }, year, month, day);
        datePickerDialog.show();
    }
}
