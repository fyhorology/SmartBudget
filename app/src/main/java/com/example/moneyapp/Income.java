package com.example.moneyapp;

import java.text.DecimalFormat;

public class Income {

    //Defining budget_id and its value
    /*
    if(income_value <= 2000){
        budget_id = 6
    }

    if(2000 < income_value <= 4500){
        budget_id = 5
    }

    if(income_value > 4500){
        budget_id = 4
    }
     */


    //Defining income value as doubles
    private double income_value;
    //Defining the format for decimals, with two decimal places
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Income(double income_value) {
        this.income_value = income_value;
    }

    //Equation for each category value where the input income * weightage (from budget config) / 100 (to make it in percentage)
    public String getFoodValue() {
        double food_value = income_value * BudgetConfig.FOOD_BUDGET/100;
        return df.format(food_value);
    }

    public String getTransportValue() {
        double transport_value = income_value * BudgetConfig.TRANSPORT_BUDGET/100;
        return df.format(transport_value);
    }

    public String getSavingsValue() {
        double savings_value = income_value * BudgetConfig.SAVINGS_BUDGET/100;
        return df.format(savings_value);
    }

    public String getHousingValue() {
        double housing_value = income_value * BudgetConfig.HOUSING_BUDGET/100;
        return df.format(housing_value);
    }

    public String getUtilitiesValue() {
        double utilities_value = income_value * BudgetConfig.UTILITIES_BUDGET/100;
        return df.format(utilities_value);
    }

    public String getInsuranceValue() {
        double insurance_value = income_value * BudgetConfig.INSURANCE_BUDGET/100;
        return df.format(insurance_value);
    }

    public String getPersonalValue() {
        double personal_value = income_value * BudgetConfig.PERSONAL_BUDGET/100;
        return df.format(personal_value);
    }

    public String getInvestmentValue() {
        double investment_value = income_value * BudgetConfig.INVESTMENT_BUDGET/100;
        return df.format(investment_value);
    }

    public Double getCurrentIncome() {
        return income_value;
    }


}
