package com.example.moneyapp;

public class Budget {

    public int foodBudget = 20;
    public int transportBudget = 10;
    public int savingsBudget = 5;
    public int housingBudget = 20;
    public int utilitiesBudget = 10;
    public int insuranceBudget = 15;
    public int personalBudget = 15;
    public int investmentBudget = 5;

    Budget(int budgetValue) {
        setBudgetValue(budgetValue);
    }

    public int getFoodBudget() {
        return foodBudget;
    }

    public int getTransportBudget() {
        return transportBudget;
    }

    public int getSavingsBudget() {
        return savingsBudget;
    }

    public int getHousingBudget() {
        return housingBudget;
    }

    public int getUtilitiesBudget() {
        return utilitiesBudget;
    }

    public int getInsuranceBudget() {
        return insuranceBudget;
    }

    public int getPersonalBudget() {
        return personalBudget;
    }

    public int getInvestmentBudget() {
        return investmentBudget;
    }

    public Budget getBudgetInstance() {
        return this;
    }

    public void setBudgetValue(int budgetValue) {
        if (budgetValue == 1) {
            foodBudget = 20;
            transportBudget = 10;
            savingsBudget = 5;
            housingBudget = 20;
            utilitiesBudget = 10;
            insuranceBudget = 15;
            personalBudget = 15;
            investmentBudget = 5;
        }

        else if (budgetValue == 2) {
            foodBudget = 15;
            transportBudget = 10;
            savingsBudget = 5;
            housingBudget = 20;
            utilitiesBudget = 10;
            insuranceBudget = 15;
            personalBudget = 20;
            investmentBudget = 5;
        }
    }

}
