package com.comp259.acb.autocalc;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by acb on 2016-12-21.
 */

public class  LoanSummaryActivity extends AppCompatActivity {

    String loanReport;
    String monthlyPayment;
    Auto mAuto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_summary);

        TextView tvMonthlyPay = (TextView)findViewById(R.id.tvMonthlyPayment);
        TextView tvLoanReport = (TextView)findViewById(R.id.tvReport);

        //Get input values passed from first activity
        Intent intent = getIntent();

        Double price;
        price = intent.getDoubleExtra("carPrice",0);
        Double downPay;
        downPay = intent.getDoubleExtra("downPayment",0);
        String term;
        term = intent.getStringExtra("term");

        //set values to auto object
        mAuto = new Auto();
        mAuto.setmLoanTerm(term);
        mAuto.setmPrice(price);
        mAuto.setmDownPayment(downPay);

        //format the report
        buildLoanReport();

        //display report
        tvLoanReport.setText(loanReport);
        tvMonthlyPay.setText(monthlyPayment);

    }

    private void buildLoanReport(){

        Resources res = getResources();
        monthlyPayment = res.getString(R.string.monthlyPayment) + String.format("%.02f", mAuto.monthlyPayment());

        loanReport = res.getString(R.string.report_line1) + String.format("%.02f", mAuto.getmPrice());
        loanReport += res.getString(R.string.report_line2) + String.format("%.02f", mAuto.getmDownPayment());

        loanReport += res.getString(R.string.report_line4) + String.format("%.02f", mAuto.taxAmount());
        loanReport += res.getString(R.string.report_line5) + String.format("%.02f", mAuto.totalCost());
        loanReport += res.getString(R.string.report_line6) + String.format("%.02f", mAuto.borrowedAmount());
        loanReport += res.getString(R.string.report_line7) + String.format("%.02f", mAuto.interestAmount());

        loanReport += "\n" + res.getString(R.string.report_line3) + " " + mAuto.getmLoanTerm() + " years";

        loanReport += res.getString(R.string.note_line1);
        loanReport += res.getString(R.string.note_line2);
        loanReport += res.getString(R.string.note_line3);
        loanReport += res.getString(R.string.note_line4);
    }

    public void goDataEntry(View view){

        Intent i = new Intent();
        //pass calculated values back to the first activity
        i.putExtra("totalCost", mAuto.totalCost());
        i.putExtra("borrowedAmount", mAuto.borrowedAmount());
        i.putExtra("interestAmount", mAuto.interestAmount());
        i.setData(Uri.parse(monthlyPayment));
        setResult(RESULT_OK, i);
        finish();
    }
}
