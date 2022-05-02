package com.example.moneyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Feedback extends AppCompatActivity {

    //Defining clickables
    private ImageButton btn_back3;
    Button btn_submit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        //Finding corresponding clickables by ID from xml
        btn_back3 = (ImageButton) findViewById(R.id.btn_back3);
        btn_submit2 = findViewById(R.id.btn_submit2);

        //OnClick btn_back3, goes to IncomeDetailsActivity (Main Dashboard)
        btn_back3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), IncomeDetailsActivity.class);
                startActivity(intent);
            }});

        //OnClick btn_back3, goes to IncomeDetailsActivity (Main Dashboard)
        btn_submit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), IncomeDetailsActivity.class);
                startActivity(intent);
            }});
    }




}