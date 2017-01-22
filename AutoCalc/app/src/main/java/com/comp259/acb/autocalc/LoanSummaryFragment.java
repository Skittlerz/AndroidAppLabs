package com.comp259.acb.autocalc;

import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by acb on 2017-01-21.
 */

public class LoanSummaryFragment extends Fragment {

    String term;
    double price;
    double downPayment;
    Auto mAuto;

    TextView tvMonthlyPay;
    TextView tvLoanReport;
    String loanReport;
    String monthlyPayment;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //---Inflate the layout for this fragment---
        return inflater.inflate(R.layout.fragment_loan_summary, container, false);
    }

    public void onStart(){
        super.onStart();

        Button back = (Button) getActivity().findViewById(R.id.btnChangeFragment);
        back.setText("Go To Data Entry");

        mAuto = new Auto();
        Bundle args = getArguments();
        if (args  != null && args.containsKey("term")){
            term = args.getString("term");
            mAuto.setmLoanTerm(term);
        }

        if (args  != null && args.containsKey("price")){
            price = args.getDouble("price");
            mAuto.setmPrice(price);
        }

        if (args  != null && args.containsKey("downPayment")){
            downPayment = args.getDouble("downPayment");
            mAuto.setmDownPayment(downPayment);
        }

        //set views
        tvMonthlyPay = (TextView)getActivity().findViewById(R.id.tvMonthlyPayment2);
        tvLoanReport = (TextView)getActivity().findViewById(R.id.tvReport2);

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
}
