package com.braun1792.shippingcalculator;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by braun1792 on 11/15/2016.
 */
public class SecondActivity extends AppCompatActivity {

    private RadioGroup rgPatty;
    private CheckBox cbProsciutto;
    private  RadioGroup rgCheese;
    private SeekBar sbSauce;
    private TextView tvCalories;

    private Burger burger;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        burger = new Burger();
        initialize();
    }

    private void initialize(){

        rgPatty = (RadioGroup) findViewById(R.id.rgPatty);
        cbProsciutto = (CheckBox) findViewById(R.id.cbProsciutto);
        rgCheese = (RadioGroup) findViewById(R.id.rgCheese);
        sbSauce = (SeekBar) findViewById(R.id.sbSauce);
        tvCalories = (TextView) findViewById(R.id.tvCalories);

        //displayCalories();
    }
    /**
     *
     rgCheese=0x7f0b0071;
     rgPatty=0x7f0b006c;
     sbSauce=0x7f0b0075;
     tvCalories=0x7f0b0077;


     cbProsciutto=0x7f0b0070;

     rbOne=0x7f0b006d;
     rbThree=0x7f0b006f;
     rbTwo=0x7f0b006e;

     rgCone=0x7f0b0072;
     rgCtwo=0x7f0b0073;
     **/


    /***
    private void registerChangeListener(){
        rgPatty.setOnCheckedChangeListener(foodListener);
        cbProsciutto.setOnClickListener(prosciuttoListener);
        rgCheese.setOnCheckedChangeListener(foodListener);
        sbSauce.setOnSeekBarChangeListener(sauceListener);
    }

    private RadioGroup.OnCheckedChangeListener foodListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            switch (i){
                case 0x7f0b006d: //Beef
                    burger.setPattyCalories(burger.BEEF);
                    break;
                case 0x7f0b006e: //Veggie
                    burger.setPattyCalories(burger.VEGGIE);
                    break;
                case 0x7f0b006f
            }

        }
    };
     ***/
}
