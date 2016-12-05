package com.braun1792.shippingcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by acb on 2016-12-04.
 */

public class MyActivity extends AppCompatActivity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_activity);

        //Set the marriage spinner
        Spinner mSpinner = (Spinner) findViewById(R.id.spnMarried);
        ArrayAdapter<CharSequence> mAdapter = ArrayAdapter.createFromResource(this,
                R.array.married_array, android.R.layout.simple_spinner_item);
        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(mAdapter);

        //set the role spinner
        Spinner rSpinner = (Spinner) findViewById(R.id.spnRole);
        ArrayAdapter<CharSequence> rAdapter = ArrayAdapter.createFromResource(this,
                R.array.role_array, android.R.layout.simple_spinner_item);
        rAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rSpinner.setAdapter(rAdapter);
    }
}
