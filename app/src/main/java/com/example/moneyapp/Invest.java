package com.example.moneyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Invest extends AppCompatActivity {

    //Defining clickables
    private ImageButton btn_stocks;
    private ImageButton btn_crypto;
    private ImageButton btn_passive;
    private ImageButton btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invest);



        //Assigning defined clickables via object IDs from xml
        btn_stocks = findViewById(R.id.btn_stocks);
        btn_crypto = findViewById(R.id.btn_crypto);
        btn_passive = findViewById(R.id.btn_passive);
        btn_back = (ImageButton) findViewById(R.id.btn_back);

        //Upon OnClick back icon, goes back to MainDashboard (IncomeDetailsActivity.java)
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), IncomeDetailsActivity.class);
                startActivity(intent);
            }});

        //Upon OnClick stocks icon, goes to internet url as below (to learn about stocks)
        btn_stocks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.finder.com/my/how-to-buy-shares";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }});

        //Upon OnClick crypto icon, goes to internet url as below (to learn about cryptos)
        btn_crypto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.freemalaysiatoday.com/category/leisure/2021/09/27/how-to-make-your-first-purchase-of-bitcoin-with-luno/";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }});

        //Upon OnClick passive icon, goes to internet url as below (to learn about generation passive income)
        btn_passive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://ringgitohringgit.com/earning-money/guide-passive-income-in-malaysia/";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }});

    }
}