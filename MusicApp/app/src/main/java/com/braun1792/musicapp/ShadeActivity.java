package com.braun1792.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by acb on 2017-01-08.
 */

public class ShadeActivity extends AppCompatActivity implements ListFragment.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shade);
    }

    @Override
    public void onShadeItemSelected(String link){

        //Check if the info frag exists in this layout
        InformationFragment infoFrag = (InformationFragment) getFragmentManager().findFragmentById(R.id.fInfo);

        //Check if two pane configuration is being displayed
        if(infoFrag != null && infoFrag.isInLayout()){
            infoFrag.setText(link);
        }else{
            Intent intent = new Intent(this, InformationActivity.class);
            intent.putExtra("Information", link);
            startActivity(intent);
        }
    }
}
