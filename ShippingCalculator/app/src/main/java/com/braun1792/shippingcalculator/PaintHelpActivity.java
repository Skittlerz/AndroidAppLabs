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

        mRoom = new InteriorRoom();
    }

    private void referenceUIcomponents(){
        etLength = (EditText)findViewById(R.id.etLength);
        etWidth = (EditText) findViewById(R.id.etWidth);
        etHeight = (EditText) findViewById(R.id.etHeight);
        etDoors = (EditText) findViewById(R.id.etDoors);
        etWindows = (EditText) findViewById(R.id.etWindows);
        nGallonsV = (TextView) findViewById(R.id.tvGallons);
    }

    public void computeGallons(View view){
        double l = Double.valueOf(etLength.getText().toString());
        double h = Double.valueOf(etHeight.getText().toString());
        double w = Double.valueOf(etWidth.getText().toString());
        mRoom.setmLength(l);
        mRoom.setmHeight(h);
        mRoom.setmWidth(w);

        int doors = Integer.valueOf(etDoors.getText().toString());
        int windows = Integer.valueOf(etWindows.getText().toString());
        mRoom.setmDoors(doors);
        mRoom.setmWindows(windows);

        nGallonsV.setText("Interior surface area: " + mRoom.surfaceArea() + " feet" + "\nGallons needed: "+ mRoom.gallons());
    }
}
