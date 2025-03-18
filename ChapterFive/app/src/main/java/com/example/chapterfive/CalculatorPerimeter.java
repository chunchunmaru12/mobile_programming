package com.example.chapterfive;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CalculatorPerimeter#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalculatorPerimeter extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_calculator_perimeter, container, false);
        Bundle bundle = getArguments();
        String perimeter = bundle.getString("perimeter");

        TextView resPeri= view.findViewById(R.id.resPeri);
        resPeri.setText("perimeter: " + perimeter);
        return view;
    }
}