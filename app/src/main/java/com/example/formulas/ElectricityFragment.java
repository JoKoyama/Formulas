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


public class ElectricityFragment extends Fragment {
    private EditText current,resistance,voltage;
    private Toast toast;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_electricity,container,false);
        wireWidgets(rootView);
        voltage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(voltage.getText().toString().isEmpty() && !resistance.getText().toString().isEmpty()) {

                    voltage.setText(String.valueOf(electricityCalculationVoltage(
                            Double.parseDouble(voltage.getText().toString()), Double.parseDouble(resistance.getText().toString()))));
                }
                if(resistance.getText().toString().isEmpty() && !voltage.getText().toString().isEmpty()) {

                    resistance.setText(String.valueOf(electricityCalculationVoltage(
                            Double.parseDouble(voltage.getText().toString()), Double.parseDouble(resistance.getText().toString()))));
                }
                if(!resistance.getText().toString().isEmpty() && !resistance.getText().toString().isEmpty()){
                    toast.makeText(getActivity(),"Please change either A or B to be empty",Toast.LENGTH_SHORT);
                }

            }
        });
        resistance.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!voltage.getText().toString().isEmpty() && !resistance.getText().toString().isEmpty() && !current.getText().toString().isEmpty()) {

                    current.setText(String.valueOf(electricityCalculationVoltage(
                            Double.parseDouble(voltage.getText().toString()), Double.parseDouble(resistance.getText().toString()))));
                }
            }
        });
        current.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!resistance.getText().toString().isEmpty() && !voltage.getText().toString().isEmpty()) {
                    current.setText(String.valueOf(electricityCalculationVoltage(
                            Double.parseDouble(voltage.getText().toString()), Double.parseDouble(resistance.getText().toString()))));
                }

            }
        });


        return rootView;
    }

    private void wireWidgets(View rootView) {
        voltage = rootView.findViewById(R.id.editText_electricity_voltage);
        current = rootView.findViewById(R.id.editText_electricity_current);
        resistance = rootView.findViewById(R.id.editText_electricity_resistance);
    }

    private double electricityCalculationVoltage(double current, double resistance) {
        return current*resistance;
    }
}
