package com.example.chapterfive;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class FragmentSecond extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_second,container,false);
        Button btnOne = view.findViewById(R.id.btn2);
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(view, "Meow Meow Meow", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });

        return  view;
    }
}
