package com.example.taxcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvResult, tvPrevAmt, tvDeduct, tvMonthly;
    private Button btnCalculate;
    private EditText etAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvResult);
        btnCalculate = findViewById(R.id.btnCalculate);
        etAmount = findViewById(R.id.etTax);
        tvPrevAmt = findViewById(R.id.tvAmount);
        tvDeduct = findViewById(R.id.tvDeduction);
        tvMonthly = findViewById(R.id.tvMonth);


        btnCalculate.setOnClickListener(this);
    }

    public boolean validate() {
        boolean flag = true;
        if (TextUtils.isEmpty(etAmount.getText().toString())) {
            etAmount.setError("Please Enter Your Amount");
            etAmount.requestFocus();
            flag = false;
        }

        return flag;
    }

    @Override
    public void onClick(View v) {
        if (validate()) {
            double amount = Double.parseDouble(etAmount.getText().toString())*12.0;
            if (v.getId() == R.id.btnCalculate) {

                TaxCalculation tx = new TaxCalculation();
                tx.setAmount(amount);
                tvMonthly.setText(etAmount.getText().toString());
                tvDeduct.setText(Float.toString(tx.taxAmount(amount)));
                tvPrevAmt.setText(Double.toString(amount));
                tvResult.setText(Double.toString(tx.getAmount()));
                etAmount.setText("");
            }
        }
    }
}
