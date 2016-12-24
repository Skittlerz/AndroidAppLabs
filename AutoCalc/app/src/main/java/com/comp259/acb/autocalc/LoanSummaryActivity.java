package com.comp259.acb.autocalc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by acb on 2016-12-21.
 */

public class LoanSummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_summary);

        TextView tvMonthlyPay = (TextView)findViewById(R.id.tvMonthlyPayment);
        TextView tvLoanReport = (TextView)findViewById(R.id.tvReport);

        Intent intent = getIntent();

        String report;
        report = intent.getStringExtra("LoanReport");

        String monthlyPay;
        monthlyPay = intent.getStringExtra("MonthlyPayment");
        tvMonthlyPay.setText(monthlyPay);
        tvLoanReport.setText(report);

    }

    public void goDataEntry(View view){
        finish();
    }
}
