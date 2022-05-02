package com.example.moneyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Settings extends AppCompatActivity {

    //defining clickables
    private ImageButton btn_back2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //Assigning clickables via ID from xml
        btn_back2 = (ImageButton) findViewById(R.id.btn_back2);

        //Onclick back icon, goes back to Main Dashboard (IncomeDetailsActivity.java)
        btn_back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), IncomeDetailsActivity.class);
                startActivity(intent);
            }});
    }
}