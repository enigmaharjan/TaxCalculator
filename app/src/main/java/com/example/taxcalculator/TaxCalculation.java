package com.example.taxcalculator;

public class TaxCalculation {
    double amt = 0;
    public void setAmount(double amount){
        if(amount>350000){
            double threeLakh = amount - 350000;
            amount = 350000;
            amt += (threeLakh+(0.25*(threeLakh)));
        }
        if(amount<=350000 && amount >=200000){
            double fifteenPer = amount - 200000;
            amount = 200000;
            amt += (fifteenPer+(0.15*(fifteenPer)));
        }
        if(amount<=200000 && amount>=1){
            amt += (amount+(0.01*(amount)));
        }
    }
    public double getAmount(){
        return amt;
    }
}
