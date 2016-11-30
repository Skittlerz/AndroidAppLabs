package com.braun1792.shippingcalculator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ShipItem shipItem;

    private EditText etWeight;
    private TextView tvBaseCost;
    private TextView tvAddedCost;
    private TextView tvTotalCost;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            shipItem = new ShipItem();

            etWeight = (EditText)findViewById(R.id.etWeight);
            tvBaseCost = (TextView)findViewById(R.id.tvBaseCost);
            tvAddedCost = (TextView)findViewById(R.id.tvAddedCost);
            tvTotalCost = (TextView)findViewById(R.id.tvTotalCost);

            etWeight.addTextChangedListener(weightTextWatcher);
        }

        private TextWatcher weightTextWatcher = new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    try{
                        shipItem.setWeight((int)Double.parseDouble(charSequence.toString()));
                    }catch (NumberFormatException e){
                        shipItem.setWeight(0);
                    }
                    displayShipping();
                }

                @Override
                public void afterTextChanged(Editable editable) {}
            };

        private void displayShipping(){

            tvBaseCost.setText("$"+String.format("%.02f", shipItem.getBaseCost()));
            tvAddedCost.setText("$"+String.format("%.02f", shipItem.getAddedCost()));
            tvTotalCost.setText("$"+String.format("%.02f", shipItem.getTotalCost()));
        }

        public void nextScreen(View view)
        {
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
        }

}
