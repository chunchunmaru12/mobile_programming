package com.example.chapterfive;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class CustomDialogFragment extends DialogFragment {
    private  CustomDialogListener listener;
    public interface CustomDialogListener{
        void onDialogResult(String input);

    }
    public void setCustomDialogListener(CustomDialogListener customDialogListener){
        this.listener=customDialogListener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View dialogView = inflater.inflate(R.layout.custom_dialog,container,false);
        Button btnCal= dialogView.findViewById(R.id.calculateBtn);
        EditText editTextOne = dialogView.findViewById(R.id.editOne);
        EditText editTextTwo = dialogView.findViewById(R.id.editTwo);
        TextView result = dialogView.findViewById(R.id.calculateRes);

        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    String numOne=editTextOne.getText().toString();
                    String numTwo=editTextTwo.getText().toString();
                    float num1 = Float.parseFloat(numOne);
                    float num2 = Float.parseFloat(numTwo);
                    float sum = (num1+num2);
                    result.setText("Result: "+sum);
                    listener.onDialogResult(String.valueOf(sum));

                }catch (Exception e){
                    result.setText("Error: " + e.getMessage());
                }
            }
        });


        return dialogView;
    }
}
