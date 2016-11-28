package com.braun1792.hellogoodbye;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvGreeting;
    private Boolean isHello;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvGreeting = (TextView)findViewById(R.id.tvHelloGoodbye);

        initializeGreeting();

        Button btnExclaim = (Button) findViewById(R.id.btnExclaim);
        btnExclaim.setOnClickListener(toggleGreeting);
    }

    private final View.OnClickListener toggleGreeting =
            new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (isHello){
                        isHello = false;
                        tvGreeting.setText(R.string.goodbye);
                    } else {
                        isHello = true;
                        tvGreeting.setText(R.string.hello);
                    }
                }
    };

    private void initializeGreeting(){
        isHello = true;
    }
}
