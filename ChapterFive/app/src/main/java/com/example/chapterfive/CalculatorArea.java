package com.example.chapterfive;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 *
 * create an instance of this fragment.
 */
public class CalculatorArea extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_calculator_area, container, false);
        Bundle bundle = getArguments();
        String area = bundle.getString("area");
        TextView resultText = view.findViewById(R.id.resArea);
        resultText.setText("Area: " + area);
        return view;
    }
}