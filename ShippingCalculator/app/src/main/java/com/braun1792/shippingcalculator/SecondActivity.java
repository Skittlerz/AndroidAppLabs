package com.braun1792.shippingcalculator;

import android.content.DialogInterface;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
        registerChangeListener();
        displayCalories();
    }

    private void initialize(){

        rgPatty = (RadioGroup) findViewById(R.id.rgPatty);
        cbProsciutto = (CheckBox) findViewById(R.id.cbProsciutto);
        rgCheese = (RadioGroup) findViewById(R.id.rgCheese);
        sbSauce = (SeekBar) findViewById(R.id.sbSauce);
        tvCalories = (TextView) findViewById(R.id.tvCalories);

    }
    /**
     *
     * HEX values in R class
     rgPatty=0x7f0b006d;
     rbOne=0x7f0b006e;
     rbTwo=0x7f0b006f;
     rbThree=0x7f0b0070;

     rgCheese=0x7f0b0072;
     rgCone=0x7f0b0073;
     rgCtwo=0x7f0b0074;
     **/



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
                case 0x7f0b006e: //Beef
                    burger.setPattyCalories(Burger.BEEF);
                    break;
                case 0x7f0b006f: //Veggie
                    burger.setPattyCalories(Burger.VEGGIE);
                    break;
                case 0x7f0b0070: //Chickpea
                    burger.setPattyCalories(Burger.CHICKPEA);
                    break;
                case 0x7f0b0073: // Asiago
                    burger.setCheeseCalories(Burger.ASIAGO);
                    break;
                case 0x7f0b0074: //Creme Fraiche
                    burger.setCheeseCalories(Burger.CREMEFRAICHE);
                    break;
            }

            displayCalories();
        }
    };

    private View.OnClickListener prosciuttoListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if(((CheckBox) view).isChecked()){
                burger.setProsciuttoCalories(Burger.PROSCIUTTO);
            }else{
                burger.clearProsciuttoCalories();
            }

            displayCalories();

        }
    };

    private SeekBar.OnSeekBarChangeListener sauceListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            burger.setSauceCal(seekBar.getProgress());
            displayCalories();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    private void displayCalories(){

        String calories = "Calories: " + burger.getTotalCalories();
        tvCalories.setText(calories);
    }

}
