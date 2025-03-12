package com.example.chapterfive;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CalculatorInput#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalculatorInput extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_calculator_input, container, false);
        EditText length=view.findViewById(R.id.textLength);
        EditText breadth=view.findViewById(R.id.textBreadth);
        Button calc=view.findViewById(R.id.calcResult);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        return view;
    }
}