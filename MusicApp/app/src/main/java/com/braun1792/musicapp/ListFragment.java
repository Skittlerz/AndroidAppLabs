package com.braun1792.musicapp;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;

/**
 * Created by acb on 2017-01-08.
 */

public class ListFragment extends Fragment {

    private OnItemSelectedListener listener;
    private String information;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstancedState){

        View view = inflater.inflate(R.layout.list_fragment, container, false);

        Button btnPlum = (Button) view.findViewById(R.id.btnPlum);
        btnPlum.setOnClickListener(ShadeChangeListener);

        Button btnBlue = (Button) view.findViewById(R.id.btnBlue);
        btnBlue.setOnClickListener(ShadeChangeListener);

        Button btnGold = (Button) view.findViewById(R.id.btnGold);
        btnGold.setOnClickListener(ShadeChangeListener);

        return view;
    }

    private View.OnClickListener ShadeChangeListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String description = (String) view.getContentDescription();
            information = description;
            updateDetail();
        }
    };

    public interface OnItemSelectedListener{
        public void onShadeItemSelected(String link);
    }

    @Override
    public void onAttach(Activity activity){

        super.onAttach(activity);
        if(activity instanceof OnItemSelectedListener){
            listener = (OnItemSelectedListener)activity;
        }else{
            throw new ClassCastException(activity.toString() + " must implement MyListFragment.OnItemSelectedListener");
        }
    }

    public void updateDetail(){
        listener.onShadeItemSelected(information);
    }
}
