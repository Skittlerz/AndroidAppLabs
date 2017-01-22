package com.braun1792.shippingcalculator;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by acb on 2017-01-21.
 */

public class ShippingCostFragment extends Fragment {



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstancedState) {

        View view = inflater.inflate(R.layout.shipping_cost_fragment, container, false);

        return view;
    }


}
