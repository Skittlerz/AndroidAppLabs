package com.braun1792.travelmilescalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by braun1792 on 1/23/2017.
 */
public class SecondActivity extends AppCompatActivity {

    TravelCalculator tc;
    String tCity;
    String fCity;

    TextView tvToCity;
    TextView tvFromCity;
    TextView tvDistance;
    TextView tvPrice;
    TextView tvBonusMiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Intent data = getIntent();
        tCity = data.getStringExtra("to");
        fCity = data.getStringExtra("from");

        tc = new TravelCalculator(tCity,fCity);

        tvToCity = (TextView) findViewById(R.id.tvToResult);
        tvFromCity = (TextView) findViewById(R.id.tvFromResult);
        tvDistance = (TextView) findViewById(R.id.tvDistanceResult);
        tvPrice = (TextView) findViewById(R.id.tvPriceResult);
        tvBonusMiles = (TextView) findViewById(R.id.tvBonusMilesResult);

        tvToCity.setText(tCity);
        tvFromCity.setText(fCity);
        tvDistance.setText(String.valueOf(tc.getDistance()));
        tvPrice.setText("$"+String.format("%.02f", tc.getTicketPrice()));
        tvBonusMiles.setText(String.valueOf(tc.getBonusMiles()));

    }

    public void backClick(View view){
        finish();
    }
}
