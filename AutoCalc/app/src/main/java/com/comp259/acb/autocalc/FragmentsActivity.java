package com.comp259.acb.autocalc;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by acb on 2017-01-21.
 */

public class FragmentsActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container);

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
            //pass input values as a bundle
            final Bundle bundle = new Bundle();
            bundle.putString("term", ((MainFragment) f).getUserTerm());
            bundle.putDouble("downPayment", ((MainFragment) f).getUserDownPayment());
            bundle.putDouble("price", ((MainFragment) f).getUserPrice());
            lsf.setArguments(bundle);
            fragmentTransaction.replace(R.id.mainFrame, lsf);
        }else{
            MainFragment mf = new MainFragment();
            fragmentTransaction.replace(R.id.mainFrame, mf);
        }
        //allows user to use back button
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


}
