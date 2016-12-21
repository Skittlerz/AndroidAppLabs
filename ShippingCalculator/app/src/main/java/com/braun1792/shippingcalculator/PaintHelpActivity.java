package com.braun1792.shippingcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by braun1792 on 12/14/2016.
 */
public class PaintHelpActivity extends AppCompatActivity {



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paint_help_activity);
    }

    public void goToInput(View view){
        finish();
    }

}
