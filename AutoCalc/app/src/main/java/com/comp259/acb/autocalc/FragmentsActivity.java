package com.comp259.acb.autocalc;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;

/**
 * Created by acb on 2017-01-21.
 */

public class FragmentsActivity extends AppCompatActivity {

    String loanReport;
    //passed TO LoanSummaryActivity
    Double downPayment;
    String years;
    Double price;
    //passed FROM LoanSummaryActivity
    Double interest;
    Double borrowedAmount;
    Double totalCost;
    Auto mAuto;
    Button switchFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container);

        switchFragment = (Button) findViewById(R.id.btnChangeFragment);
        switchFragment.setText("Loan Report");

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        MainFragment mf = new MainFragment();
        fragmentTransaction.add(R.id.mainFrame, mf);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }


    public void changeFragment(View view){

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //check which is active fragment
        Fragment f = getFragmentManager().findFragmentById(R.id.mainFrame);
        if (f instanceof MainFragment){
            LoanSummaryFragment lsf = new LoanSummaryFragment();
            final Bundle bundle = new Bundle();
            bundle.putString("term", ((MainFragment) f).getUserTerm());
            bundle.putDouble("downPayment", ((MainFragment) f).getUserDownPayment());
            bundle.putDouble("price", ((MainFragment) f).getUserPrice());
            lsf.setArguments(bundle);
            fragmentTransaction.replace(R.id.mainFrame, lsf);
            switchFragment.setText("Go to Data Entry");
        }else{
            MainFragment mf = new MainFragment();
            fragmentTransaction.replace(R.id.mainFrame, mf);
            switchFragment.setText("Loan Report");
        }

        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


}
