package com.example.moneyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class Contributor extends AppCompatActivity {

    private ImageButton btn_back3;
    Button btn_submit_contributor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contributor);

        btn_back3 = (ImageButton) findViewById(R.id.btn_back3);
        btn_submit_contributor = (Button) findViewById(R.id.btn_submit_contributor);

        //Onclick back icon, goes back to Main Dashboard (IncomeDetailsActivity.java)
        btn_back3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), IncomeDetailsActivity.class);
                startActivity(intent);
            }});


    btn_submit_contributor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), IncomeDetailsActivity.class);
                startActivity(intent);
            }});
}


}