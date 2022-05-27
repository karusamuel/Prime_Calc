package com.example.primecalc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.primecalc.adapters.MyAdapter;
import com.example.primecalc.fragments.ExitDialog;
import com.example.primecalc.primecalculator.PrimeCalculator;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CalculatorActivity extends AppCompatActivity {
    @BindView(R.id.grid)
    GridView myGrid;
    @BindView(R.id.start)
    TextView startInt;
    @BindView(R.id.end)
    TextView endInt;
    @BindView(R.id.exit)
    ImageView exit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        ButterKnife.bind(this);

        myGrid.setNumColumns(4);

        Intent incomingIntent = getIntent();

        int start = incomingIntent.getIntExtra("StartInt",1);
        int end = incomingIntent.getIntExtra("EndInt",1);

        startInt.setText(Integer.toString(start));
        endInt.setText(Integer.toString(end));

        calculatePrimeNumbers(start,end);
        FragmentManager fragmentManager = getSupportFragmentManager();
        ExitDialog exitDialog = new ExitDialog();
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              exitDialog.show(fragmentManager,"Exit Dialog");
            }
        });



    }

    private void calculatePrimeNumbers(Integer startInt,Integer endInt){

        if(startInt<0||endInt<0){
            Toast.makeText(getApplicationContext(),"Cannot be less than 0",Toast.LENGTH_LONG).show();
        }
        else {
            PrimeCalculator primeCalculator = new PrimeCalculator();
            ArrayList list =  primeCalculator.calculatePrime(startInt,endInt);
            myGrid.setAdapter(new MyAdapter(getApplicationContext(),list));
        }

    }
}