package com.braun1792.musicapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by acb on 2017-01-08.
 */

public class InformationFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstancedState){

        View view = inflater.inflate(R.layout.information_fragment, container, false);
        return view;
    }

    public void setText(String shadeInfo){
        TextView view = (TextView) getView().findViewById(R.id.tvInfo);
        view.setText(shadeInfo);
    }
}
