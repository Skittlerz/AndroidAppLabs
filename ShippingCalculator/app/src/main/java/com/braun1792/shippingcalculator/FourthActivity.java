package com.braun1792.shippingcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by acb on 2016-12-04.
 */

public class FourthActivity extends AppCompatActivity {

    private LinearLayout mLinearLayout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth_activity);

        mLinearLayout = (LinearLayout) findViewById(R.id.linearLayout1);

        fillPaintingGallery();

    }

    private void fillPaintingGallery(){

        ImageButton imageButton;

        for(int i=0; i < RenaissanceDatabase.description.length; i++){

            imageButton = new ImageButton(this);

            Painting painting = new Painting(RenaissanceDatabase.description[i],
                    RenaissanceDatabase.id[i]);

            imageButton.setContentDescription(painting.getDescription());

            imageButton.setImageDrawable(getDrawable(painting.getId()));

            imageButton.setOnClickListener(displayPaintingInformation);

            mLinearLayout.addView(imageButton);
        }
    }

    private View.OnClickListener displayPaintingInformation =
            new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String paintingDescription = (String) view.getContentDescription();

                    displayToast(paintingDescription);

                }
            };

    private void displayToast(String descrip){
        Toast.makeText(this, descrip, Toast.LENGTH_SHORT).show();
    }
}
