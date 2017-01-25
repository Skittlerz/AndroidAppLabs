package com.braun1792.travelmilescalculator;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String fCity;
    String tCity;
    String discountCode;

    Spinner toCity;
    Spinner fromCity;

    EditText etDiscount;
    TextView tvResults;
    Button btnCalculate;
    String results;
    String newline = "\n";

    ArrayAdapter<CharSequence> cAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toCity = (Spinner) findViewById(R.id.spnrTo);
        fromCity = (Spinner) findViewById(R.id.spnrFrom);
        etDiscount = (EditText) findViewById(R.id.etDiscount);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        tvResults = (TextView) findViewById(R.id.tvResults);

        //set default for strings
        fCity = "Regina";
        tCity = "Regina";

        //Set the to and from city spinners
        cAdapter = ArrayAdapter.createFromResource(this,R.array.cities, android.R.layout.simple_spinner_item);
        cAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        toCity.setAdapter(cAdapter);
        fromCity.setAdapter(cAdapter);

        //set the button click listener
        btnCalculate.setOnClickListener(calculateClick);

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

    public View.OnClickListener calculateClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(!etDiscount.getText().toString().equals(""))
            {
                discountCode = etDiscount.getText().toString();
            }else{
                discountCode = "none";
            }
            calculate();
        }
    };

    public void calculate(){

        Intent i = new Intent(this, SecondActivity.class);
        i.putExtra("discount", discountCode);
        i.putExtra("to",tCity);
        i.putExtra("from",fCity);
        startActivityForResult(i,1);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){

        if (requestCode == 1){

            if(resultCode == RESULT_OK){

                Resources res = getResources();

                results = res.getString(R.string.to) + " " + data.getStringExtra("to") + newline;
                results += res.getString(R.string.from) + " " + data.getStringExtra("from") + newline;
                results += res.getString(R.string.discount) + " " + data.getStringExtra("discount") + newline;
                results += res.getString(R.string.distance) + " " + Integer.toString(data.getIntExtra("distance",0)) + newline;
                results += res.getString(R.string.price) + " " + data.getStringExtra("price") + newline;
                results += res.getString(R.string.bonus) + " " + Integer.toString(data.getIntExtra("bonus",0)) + newline;

                tvResults.setText(results);
            }
        }
    }

}
