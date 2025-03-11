package com.example.chapterfive;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentFirst extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_first,container,false);
        TextView textView= view.findViewById(R.id.textView);
        EditText name = view.findViewById(R.id.name);
        EditText age = view.findViewById(R.id.age);
        Button btn= view.findViewById(R.id.btn1);
        btn.setOnClickListener(v -> {
            textView.setText("Name: "+name.getText().toString()+" Age: "+age.getText().toString());
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}
