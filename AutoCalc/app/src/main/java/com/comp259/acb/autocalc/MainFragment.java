package com.comp259.acb.autocalc;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by acb on 2017-01-21.
 */

public class MainFragment extends Fragment {

    private EditText etPrice;
    private EditText etDownPay;
    private RadioGroup rgTerm;

    double price;
    double downPayment;
    String years;

    Auto auto;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //---Inflate the layout for this fragment---
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    public void onStart(){
        super.onStart();

        //Set views
        etPrice = (EditText) getActivity().findViewById(R.id.etPrice2);
        etDownPay = (EditText) getActivity().findViewById(R.id.etDownPayment2);
        rgTerm = (RadioGroup) getActivity().findViewById(R.id.rgTerm2);


    }


    public double getUserPrice(){
        if(!etPrice.getText().toString().equals("")) {
            price = Double.parseDouble(etPrice.getText().toString());
            return price;
        }else{
            return 0;
        }
    }

    public double getUserDownPayment(){
        if(!etDownPay.getText().toString().equals("")) {
            downPayment = Double.parseDouble(etDownPay.getText().toString());
            return downPayment;
        }else{
            return 0;
        }
    }

    public String getUserTerm(){
        Integer radioId = rgTerm.getCheckedRadioButtonId();
        RadioButton term = (RadioButton) getActivity().findViewById(radioId);
        years = term.getText().toString();
        return years;
    }


}
