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
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String loanReport;
    //passed TO LoanSummaryActivity
    Double downPayment;
    String years;
    Double price;
    //passed FROM LoanSummaryActivity
    Double interest;
    Double borrowedAmount;
    Double totalCost;

    private EditText etPrice;
    private EditText etDownPay;
    private RadioGroup rgTerm;
    private TextView tvSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set views
        etPrice = (EditText) findViewById(R.id.etPrice);
        etDownPay = (EditText) findViewById(R.id.etDownPayment);
        rgTerm = (RadioGroup) findViewById(R.id.rgTerm);
        tvSummary = (TextView) findViewById(R.id.tvSummary);
    }

    private void collectAutoData(){
        //collect user data from views
        Integer radioId = rgTerm.getCheckedRadioButtonId();
        RadioButton term = (RadioButton) findViewById(radioId);

        price = Double.parseDouble(etPrice.getText().toString());
        downPayment = Double.parseDouble(etDownPay.getText().toString());
        years = term.getText().toString();
    }

    private void buildLoanReport(){

        Resources res = getResources();
        //build string to display totalCost, borrowedAmount, and interestAmount using data passed to this activity
        loanReport = res.getString(R.string.report_line5) + String.format("%.02f", totalCost);
        loanReport += res.getString(R.string.report_line6) + String.format("%.02f", borrowedAmount);
        loanReport += res.getString(R.string.report_line7) + String.format("%.02f", interest);

    }

    public void activateLoanSummary(View view){

        collectAutoData();
        //pass the collected user data to second activity
        Intent launchReport = new Intent(this, LoanSummaryActivity.class);
        launchReport.putExtra("carPrice", price);
        launchReport.putExtra("downPayment", downPayment);
        launchReport.putExtra("term", years);

        startActivityForResult(launchReport,1);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){

        if (requestCode == 1){

            if(resultCode == RESULT_OK){

                //get calculated values passed from second activity
                interest = data.getDoubleExtra("interestAmount",0);
                borrowedAmount = data.getDoubleExtra("borrowedAmount",0);
                totalCost = data.getDoubleExtra("totalCost",0);
                //build report string using  passed values
                buildLoanReport();
                //display report
                tvSummary.setText(loanReport);

                //Toast.makeText(this, data.getData().toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
