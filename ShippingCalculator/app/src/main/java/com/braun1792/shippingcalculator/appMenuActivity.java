package com.braun1792.shippingcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;

/**
 * Created by braun1792 on 11/30/2016.
 */
public class appMenuActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_menu);
    }

    public void calorieScreen(View view)
    {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void shippingScreen(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void calculatorScreen(View view)
    {
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }

    public void paintingScreen(View view)
    {
        Intent intent = new Intent(this, FourthActivity.class);
        startActivity(intent);
    }

    public void personnelScreen(View view)
    {
        Intent intent = new Intent(this, MyActivity.class);
        startActivity(intent);
    }

    public void onClick(View view){
        Intent i = new Intent(this, PassingDataActivity.class);
        i.putExtra("stuff", "extra stuff");
        i.putExtra("age",29);

        Bundle extra = new Bundle();
        extra.putString("bundle string","this is the bundle string");
        extra.putInt("bundle int", 42);

        i.putExtras(extra);

        startActivity(i);
    }
}
