package com.braun1792.shippingcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by braun1792 on 12/13/2016.
 */
public class PassingDataActivity extends AppCompatActivity{


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.passing_data_activity);

        Intent data = getIntent();

        Toast.makeText(this, data.getStringExtra("stuff"), Toast.LENGTH_SHORT).show();

        Toast.makeText(this, Integer.toString(data.getIntExtra("age",0)), Toast.LENGTH_SHORT).show();

        Bundle b = getIntent().getExtras();

        Toast.makeText(this, b.getString("bundle string"), Toast.LENGTH_SHORT).show();

        Toast.makeText(this, Integer.toString(b.getInt("bundle int")), Toast.LENGTH_SHORT).show();
    }

    public void onClick(View view){
        Intent i = new Intent();

        i.putExtra("random int", 38);
    }
}
