package com.braun1792.shippingcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by braun1792 on 12/14/2016.
 */
public class PaintHelpActivity extends AppCompatActivity {

    private InteriorRoom mRoom;

    private EditText etLength;
    private EditText etWidth;
    private EditText etHeight;
    private EditText etDoors;
    private EditText etWindows;

    private TextView nGallonsV;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paint_help_activity);

        referenceUIcomponents();
    }

    private void referenceUIcomponents(){
        etLength = (EditText)findViewById(R.id.etLength);
        etWidth = (EditText) findViewById(R.id.etWidth);
        etHeight = (EditText) findViewById(R.id.etHeight);
        etDoors = (EditText) findViewById(R.id.etDoors);
        etWindows = (EditText) findViewById(R.id.etWindows);
        nGallonsV = (TextView) findViewById(R.id.tvGallons);
    }
}
