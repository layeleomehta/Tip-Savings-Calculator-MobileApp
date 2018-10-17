package com.example.layeamehta.leotscalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import static java.lang.Double.parseDouble;

public class TipActivity extends AppCompatActivity {

    private TextView tip_percentage;
    private TextView tip_amount;
    private TextView total_amount;
    private EditText payment_entry;
    private Button calculate_button;
    private SeekBar tip_seekbar;
    private double percentage;
    private double payment;
    private double just_tip;
    private double tip_and_payment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip);

        tip_percentage = (TextView) findViewById(R.id.tip_percentage);
        tip_amount = (TextView) findViewById(R.id.tip_amount);
        total_amount = (TextView) findViewById(R.id.total_amount);
        payment_entry = (EditText) findViewById(R.id.payment_entry);
        calculate_button = (Button) findViewById(R.id.calculate_button);
        tip_seekbar = (SeekBar) findViewById(R.id.tip_seekbar);

        percentage = 25;


        tip_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                percentage = ((double) progress);
                tip_percentage.setText(progress + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });

        calculate_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                payment = parseDouble(payment_entry.getText().toString());
                just_tip = payment * percentage;
                just_tip = just_tip / 100; // THE PROBLEM IS IT IS TREATING JUST_TIP AS 0!!!
                tip_and_payment = payment + (payment * (percentage/100));
                tip_amount.setText(Double.toString(just_tip));
                total_amount.setText(Double.toString(tip_and_payment));
            }
        });


    }
}
