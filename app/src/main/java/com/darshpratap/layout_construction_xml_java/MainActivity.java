package com.darshpratap.layout_construction_xml_java;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RelativeLayout relativeLayout;
    Button button, secBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relativeLayout = findViewById(R.id.container);
        button = findViewById(R.id.first_btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secBtn = new Button(MainActivity.this);

                //creating View Group dynamically
                LinearLayout linearLayout = new LinearLayout(MainActivity.this);

                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(300, 400);

                params.addRule(RelativeLayout.BELOW, button.getId());

                linearLayout.setLayoutParams(params);
                linearLayout.setBackgroundColor(Color.RED);

                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);

                //creating view dynamically
                secBtn.setLayoutParams(layoutParams);
                secBtn.setText("New Btn");


                //adding view to view group first
                linearLayout.addView(secBtn);

                //adding view group to another view group
                relativeLayout.addView(linearLayout);
            }
        });

    }
}
