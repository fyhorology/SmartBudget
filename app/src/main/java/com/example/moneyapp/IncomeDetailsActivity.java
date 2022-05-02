package com.example.moneyapp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.chart.common.listener.Event;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.enums.Align;
import com.anychart.enums.LegendLayout;
import com.anychart.charts.Pie;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.auth.FirebaseAuth;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class IncomeDetailsActivity extends AppCompatActivity {

    View anyChartView;

    //Defining decimal format for numbers, buttons, and firebase authentication
    private Button btn_signout2;
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private FirebaseAuth auth;
    private double income_value;
    public static final String INCOME_VALUE = "income value";
    Boolean contributor_flag = false;
    private int budgetValue = 1;
    private Budget budget;

    //Defining category Value and Percentage
    TextView foodValue;
    TextView foodPercentage;
    TextView transportValue;
    TextView transportPercentage;
    TextView savingsValue;
    TextView savingsPercentage;
    TextView housingValue;
    TextView housingPercentage;
    TextView utilitiesPercentage;
    TextView insurancePercentage;
    TextView personalPercentage;
    TextView investmentPercentage;
    TextView utilitiesValue;
    TextView insuranceValue;
    TextView personalValue;
    TextView investmentValue;

    //Defining clickables
    ImageButton btn_planty;
    ImageButton btn_settings;
    ImageButton btn_feedback;
    Button btn_editincome;
    Button btn_contributor;

    //Defining income and person budget
    TextView incomeText;
    Income personBudget;

    PieChart pieChart;

    //Defining current total spent value
    double spent_integer = 0.00;

    @Override
    protected void onResume() {
        super.onResume();
//        Intent intent = getIntent();
//        Double income_value = intent.getDoubleExtra(MainActivity.INCOME_VALUE, 1000);
//        personBudget = new Income(income_value, new Budget(budgetValue));
//
//        calculateBudget();
    }

    //Store value in local files / database ( Store & Retrieve )
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_details);

        //Check authorisation for current account
        auth = FirebaseAuth.getInstance();

        bindData();
        calculateBudget();

        pieChart = findViewById(R.id.pie_chart);

        String[] categoryPieChart = {"Food", "Transport", "Savings", "Housing", "Utilities", "Insurance", "Personal", "Investment"};
        int[] categoryPieChart_weightage = {20, 10, 5, 20, 10, 15, 15, 5};

        ArrayList<PieEntry> pieEntries = new ArrayList<>();

        for (int i = 0; i < categoryPieChart.length; i++) {
            PieEntry pieEntry = new PieEntry(categoryPieChart_weightage[i], i);
            pieEntries.add(pieEntry);
        }


        PieDataSet pieDataSet = new PieDataSet(pieEntries, "Budgeting Weightage");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieChart.setData(new PieData(pieDataSet));
        pieChart.animateXY(2000,2000);
        pieChart.getDescription().setEnabled(false);

        //anyChartView = findViewById(R.id.any_chart_view);

        //setupPieChart();


        //Finding entity by ID from xml and assigning to variables
        btn_settings = (ImageButton) findViewById(R.id.settingsicon);
        btn_planty = (ImageButton) findViewById(R.id.plantyicon);
        btn_signout2 = findViewById(R.id.btn_signout2);
        btn_feedback = findViewById(R.id.btn_feedback);
        btn_editincome = findViewById(R.id.btn_editincome);
        btn_contributor = findViewById(R.id.btn_contributor);

        //Onclick plant icon, goes to Investment.java
        btn_planty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Invest.class);
                startActivity(intent);
            }});

        //Onclick settings icon, goes to Settings.java
        btn_contributor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Contributor.class);
                startActivity(intent);

            }});

        btn_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Settings.class);
                startActivity(intent);

            }});

        //Onclick Sign Out button, Signs out of account and goes back to LoginActivity.java
        btn_signout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signOut();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        //Onclick editincome button, goes back to MainActivity.java (to key in income)
        btn_editincome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }});

        //Onclick smiley icon, goes to Feedback.java
        btn_feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Feedback.class);
                startActivity(intent);
            }});
    }


    private void bindData() {
        //Assigning category Values and percentage via ID from xml
        incomeText = findViewById(R.id.incomeValueText);
        foodValue = findViewById(R.id.food_value);
        foodPercentage = findViewById(R.id.food_percentage);
        transportValue = findViewById(R.id.transport_value);
        transportPercentage = findViewById(R.id.transport_percentage);
        savingsValue = findViewById(R.id.savings_value);
        savingsPercentage = findViewById(R.id.savings_percentage);
        housingValue = findViewById(R.id.housing_value);
        housingPercentage = findViewById(R.id.housing_percentage);
        utilitiesValue = findViewById(R.id.utilities_value);
        utilitiesPercentage = findViewById(R.id.utilities_percentage);
        insuranceValue = findViewById(R.id.insurance_value);
        insurancePercentage = findViewById(R.id.insurance_percentage);
        personalValue = findViewById(R.id.personal_value);
        personalPercentage = findViewById(R.id.personal_percentage);
        investmentValue = findViewById(R.id.investment_value);
        investmentPercentage = findViewById(R.id.investment_percentage);


        Intent intent = getIntent();
        Double income_value = intent.getDoubleExtra(MainActivity.INCOME_VALUE, 0);
        contributor_flag = intent.getBooleanExtra("EXTRA_CONTRIBUTOR_FLAG", false);

        //Defining personBudget as income value
        budget = new Budget(budgetValue);
        personBudget = new Income(income_value, budget);
        if (income_value == 0) {
            incomeText.setText("1000");
        }
        if (income_value != 0) {
            incomeText.setText(" " + df.format(income_value));
        }
    }

    private void calculateBudget() {
        //Display category values as text with prefix RM, and call back the defined variables above
        foodValue.setText(getString(R.string.MYR) + " " + personBudget.getFoodValue());
        transportValue.setText(getString(R.string.MYR) + " " + personBudget.getTransportValue());
        savingsValue.setText(getString(R.string.MYR) + " " + personBudget.getSavingsValue());
        housingValue.setText("RM" + " " + personBudget.getHousingValue());
        utilitiesValue.setText("RM" + " " + personBudget.getUtilitiesValue());
        insuranceValue.setText("RM" + " " + personBudget.getInsuranceValue());
        personalValue.setText("RM" + " " + personBudget.getPersonalValue());
        investmentValue.setText("RM" + " " + personBudget.getInvestmentValue());


        //Display category percentage as text with suffix %, and call back the defined variables from BudgetConfig.java
        foodPercentage.setText(budget.getFoodBudget() + getString(R.string.PERCENTAGE));
        transportPercentage.setText(budget.getTransportBudget() + getString(R.string.PERCENTAGE));
        savingsPercentage.setText(budget.getSavingsBudget() + getString(R.string.PERCENTAGE));
        housingPercentage.setText(budget.getHousingBudget() + "%");
        utilitiesPercentage.setText(budget.getUtilitiesBudget() + "%");
        insurancePercentage.setText(budget.getInsuranceBudget() + "%");
        personalPercentage.setText(budget.getPersonalBudget() + "%");
        investmentPercentage.setText(budget.getInvestmentBudget() + "%");

        if (contributor_flag) {


        }

    }


    public void increase_spent(View view) {
        spent_integer = spent_integer + 100;
        display(spent_integer);
        Intent i = new Intent(this, NotificationBroadcast.class);
        TextView temp_incomeText = incomeText;
        double toDouble = Double.parseDouble(temp_incomeText.getText().toString());



        if ( spent_integer > toDouble - 200 ) {
            if ( spent_integer <= toDouble ) {
                sendBroadcast(i);
                Toast.makeText(getApplicationContext(), "Warning! You are close to exceeding your budget", Toast.LENGTH_SHORT).show();
            }
        }

        if ( spent_integer > toDouble) {
            sendBroadcast(i);
            Toast.makeText(getApplicationContext(), "You are exceeding your budget for the month!", Toast.LENGTH_SHORT).show();
        }
    }

    private void display(double number) {
        TextView displayInteger = (TextView) findViewById(
                R.id.spentValue);
        displayInteger.setText("" + number);
    }

    public void onSaveMoreClicked(View view) {


    }

    public void onSpendMoreClicked(View view) {
        this.budgetValue = budgetValue + 1;
        budget.setBudgetValue(budgetValue);
        personBudget.setNewBudget(budget.getBudgetInstance());
        calculateBudget();
    }

}