package com.example.moneyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


public class Contributor extends AppCompatActivity {

    private ImageButton btn_back3;
    Button btn_submit_contributor;
    EditText editTextIncomeValue, editTextWeightage;
    private double incomeValue;
    private double contributorIncomeValue;
    private double weightage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contributor);

        incomeValue = getIntent().getDoubleExtra("EXTRA_INCOME_VALUE", 0);
        btn_back3 = (ImageButton) findViewById(R.id.btn_back3);
        btn_submit_contributor = (Button) findViewById(R.id.btn_submit_contributor);
        editTextWeightage = (EditText) findViewById(R.id.editTextWeightage);
        editTextIncomeValue = (EditText) findViewById(R.id.editTextIncomeValue);


        //Onclick back icon, goes back to Main Dashboard (IncomeDetailsActivity.java)
        btn_back3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        btn_submit_contributor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                continueToIncomeDetails();
            }
        });
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
    }

    private void getInputData() {
        if (!editTextIncomeValue.getText().toString().isEmpty()) {
            contributorIncomeValue = Double.parseDouble(editTextIncomeValue.getText().toString());
        }

        if (!editTextWeightage.getText().toString().isEmpty()) {
            weightage = Double.parseDouble(editTextWeightage.getText().toString());
        }
    }

    private double calculateBudget(double incomeValue, double contributorIncomeValue, double weightage) {
        incomeValue = incomeValue + (contributorIncomeValue * weightage/100);
        return incomeValue;
    }

    private void continueToIncomeDetails() {
        getInputData();
        double newIncomeValue = calculateBudget(incomeValue, contributorIncomeValue, weightage);
        Intent intent = new Intent(getApplicationContext(), IncomeDetailsActivity.class);
        intent.putExtra(MainActivity.INCOME_VALUE, newIncomeValue);
        startActivity(intent);
    }


}