package com.braun1792.shippingcalculator;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by acb on 2017-01-21.
 */

public class ShippingInputFragment extends Fragment {

    private EditText etWeight;
    ShipItem shipItem = new ShipItem();



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstancedState) {

        View view = inflater.inflate(R.layout.shipping_input_fragment, container, false);

        return view;
    }

    public void onStart(){
        super.onStart();

        etWeight = (EditText) getActivity().findViewById(R.id.etWeight2);
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
            TextView tvBaseCost = (TextView) getActivity().findViewById(R.id.tvBaseCost2);
            TextView tvAddedCost = (TextView) getActivity().findViewById(R.id.tvAddedCost2);
            TextView tvTotalCost = (TextView) getActivity().findViewById(R.id.tvTotalCost2);

            tvBaseCost.setText("$"+String.format("%.02f", shipItem.getBaseCost()));
            tvAddedCost.setText("$"+String.format("%.02f", shipItem.getAddedCost()));
            tvTotalCost.setText("$"+String.format("%.02f", shipItem.getTotalCost()));

        }
        @Override
        public void afterTextChanged(Editable editable) {}
    };

}
