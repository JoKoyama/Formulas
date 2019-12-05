package com.example.formulas;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PythagoreanFragment extends Fragment {
    private EditText editTextA,editTextB,editTextC;
    private Toast toast;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pythagorean,container,false);
        wireWidgets(rootView);
        editTextA.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!editTextB.getText().toString().isEmpty() && !editTextA.getText().toString().isEmpty()) {
                    editTextC.setText(String.valueOf(pythagoreanCalculation(
                            Double.parseDouble(editTextA.getText().toString()), Double.parseDouble(editTextB.getText().toString()))));
                }
            }
        });
        editTextB.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!editTextA.getText().toString().isEmpty() && !editTextB.getText().toString().isEmpty() && !editTextC.getText().toString().isEmpty()) {

                    editTextC.setText(String.valueOf(pythagoreanCalculation(
                            Double.parseDouble(editTextA.getText().toString()), Double.parseDouble(editTextB.getText().toString()))));
                }
            }
        });
        editTextC.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editTextA.getText().toString().isEmpty() && !editTextB.getText().toString().isEmpty()) {

                    editTextA.setText(String.valueOf(pythagoreanCalculation(
                            Double.parseDouble(editTextA.getText().toString()), Double.parseDouble(editTextB.getText().toString()))));
                }
                if(editTextB.getText().toString().isEmpty() && !editTextA.getText().toString().isEmpty()) {

                    editTextB.setText(String.valueOf(pythagoreanCalculation(
                            Double.parseDouble(editTextA.getText().toString()), Double.parseDouble(editTextB.getText().toString()))));
                }
                if(!editTextB.getText().toString().isEmpty() && !editTextB.getText().toString().isEmpty()){
                    toast.makeText(getActivity(),"Please change either A or B to be empty",Toast.LENGTH_SHORT);
                }

            }
        });


        return rootView;
    }

    private double pythagoreanCalculation(double aValue, double bValue) {
        return Math.sqrt(Math.pow(aValue,2)+Math.pow(bValue,2));
    }
    private double reversePythag(double cValue,double aOrBValue){
        return Math.sqrt(Math.pow(aOrBValue,2)+Math.pow(cValue,2));
    }

    private void wireWidgets(View rootView) {

       editTextA = rootView.findViewById(R.id.editText_pythagorean_a);
       editTextB = rootView.findViewById(R.id.editText_pythagorean_b);
       editTextC = rootView.findViewById(R.id.editText_pythagorean_c);
    }
}
