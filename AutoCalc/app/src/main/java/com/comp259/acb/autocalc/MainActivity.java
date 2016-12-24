package com.comp259.acb.autocalc;

import android.content.Intent;
import android.content.res.Resources;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    Auto mAuto;

    String loanReport;
    String monthlyPayment;

    private EditText etPrice;
    private EditText etDownPay;
    private RadioGroup rgTerm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set views
        etPrice = (EditText) findViewById(R.id.etPrice);
        etDownPay = (EditText) findViewById(R.id.etDownPayment);
        rgTerm = (RadioGroup) findViewById(R.id.rgTerm);

        mAuto = new Auto();
    }

    private void collectAutoData(){

        mAuto.setmPrice(Double.parseDouble(etPrice.getText().toString()));
        mAuto.setmDownPayment(Double.parseDouble(etDownPay.getText().toString()));

        Integer radioId = rgTerm.getCheckedRadioButtonId();
        RadioButton term = (RadioButton) findViewById(radioId);
        mAuto.setmLoanTerm(term.getText().toString());
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

    public void activateLoanSummary(View view){

        collectAutoData();
        buildLoanReport();

        Intent launchReport = new Intent(this, LoanSummaryActivity.class);
        launchReport.putExtra("LoanReport", loanReport);
        launchReport.putExtra("MonthlyPayment", monthlyPayment);

        startActivity(launchReport);
    }
}
