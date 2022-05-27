package com.example.primecalc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.primecalc.fragments.ExitDialog;
import com.example.primecalc.primecalculator.PrimeCalculator;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.start_int)
    TextInputLayout startInt;
    @BindView(R.id.end_int)
    TextInputLayout endInt;
    @BindView(R.id.calculate)
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int start = Integer.parseInt(startInt.getEditText().getText().toString());
                int end = Integer.parseInt(endInt.getEditText().getText().toString());
                Intent intent = new Intent(getApplicationContext(),CalculatorActivity.class);
                intent.putExtra("StartInt",start);
                intent.putExtra("EndInt",end);
                startActivity(intent);
            }
        });
    }



}