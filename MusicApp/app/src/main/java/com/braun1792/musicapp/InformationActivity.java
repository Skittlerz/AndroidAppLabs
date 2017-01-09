package com.braun1792.musicapp;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by acb on 2017-01-08.
 */

public class InformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            finish();
            return;
        }
        setContentView(R.layout.information_fragment);

        //getActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String  shadeInfo = intent.getStringExtra("Information");

        TextView information = (TextView) findViewById(R.id.tvInfo);
        information.setText(shadeInfo);
    }
}
