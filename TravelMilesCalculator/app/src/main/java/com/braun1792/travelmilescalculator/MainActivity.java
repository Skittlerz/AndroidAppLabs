package com.braun1792.travelmilescalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    String fCity;
    String tCity;

    Spinner toCity;
    Spinner fromCity;

    ArrayAdapter<CharSequence> cAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toCity = (Spinner) findViewById(R.id.spnrTo);
        fromCity = (Spinner) findViewById(R.id.spnrFrom);

        //set default for strings
        fCity = "Regina";
        tCity = "Regina";

        //Set the to and from city spinners
        cAdapter = ArrayAdapter.createFromResource(this,R.array.cities, android.R.layout.simple_spinner_item);
        cAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        toCity.setAdapter(cAdapter);
        fromCity.setAdapter(cAdapter);

        //register the spinner listener
        toCity.setOnItemSelectedListener(dropDownOptions);
        fromCity.setOnItemSelectedListener(dropDownOptions);

    }

    public AdapterView.OnItemSelectedListener dropDownOptions = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            switch (adapterView.getId()) {
                case R.id.spnrTo:
                    if (i == 0) {
                        tCity = "Regina";
                    }else if (i == 1){
                        tCity = "Edmonton";
                    }else if (i == 2){
                        tCity = "Vancouver";
                    }
                    break;
                case R.id.spnrFrom:
                    if (i == 0) {
                        fCity = "Regina";
                    }else if (i == 1){
                        fCity = "Edmonton";
                    }else if(i == 2){
                        fCity = "Vancouver";
                    }
                    break;
            }
        }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        };

    public void calculate(View view){
        Intent i = new Intent(this, SecondActivity.class);
        i.putExtra("to",tCity);
        i.putExtra("from",fCity);
        startActivity(i);
    }

}
