package com.example.chapterfive;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class CalculatorInput extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_calculator_input, container, false);
        EditText length=view.findViewById(R.id.textLength);
        EditText breadth=view.findViewById(R.id.textBreadth);
        Button calcArea=view.findViewById(R.id.calcArea);
        Button calcPeri=view.findViewById(R.id.calcPeri);
        calcArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                float lengthC = Float.parseFloat(length.getText().toString());
                float breadthC = Float.parseFloat(breadth.getText().toString());
                float area = lengthC * breadthC;
                bundle.putString("area", String.valueOf(area));
                CalculatorArea areaFragment = new CalculatorArea();
                areaFragment.setArguments(bundle);
                getParentFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragmentCalculator,areaFragment).commit();

            }
        });
        calcPeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                float lengthC = Float.parseFloat(length.getText().toString());
                float breadthC = Float.parseFloat(breadth.getText().toString());
                float perimeter = 2*(lengthC+breadthC);
                bundle.putString("perimeter", String.valueOf(perimeter));
                CalculatorPerimeter periFragment= new CalculatorPerimeter();
                periFragment.setArguments(bundle);
                getParentFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragmentCalculator,periFragment).commit();
            }
        });


        return view;
    }
}