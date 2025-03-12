package com.example.chapterfive;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentOne extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_one, container, false);
        Button btn = view.findViewById(R.id.fragBtnOne);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTwo  twoFragment = new FragmentTwo();
                FragmentManager fragmentManager=requireActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().add(R.id.fragTest,twoFragment)
                        .addToBackStack(null).commit();
            }
        });

        return  view;
    }
}