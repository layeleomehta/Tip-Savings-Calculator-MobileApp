package com.example.layeamehta.leotscalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class SavingsActivity extends AppCompatActivity {

    private EditText payment_amount;
    private SeekBar savings_seekbar;
    private Button calculate_savings_button;
    private TextView savings_amount;
    private TextView savings_percentage;

    private double savings_entry;
    private double savings_percent;
    private double just_savings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savings);

        payment_amount = (EditText) findViewById(R.id.payment_amount);
        savings_seekbar = (SeekBar) findViewById(R.id.savings_seekbar);
        calculate_savings_button = (Button) findViewById(R.id.calculate_savings_button);
        savings_amount = (TextView) findViewById(R.id.savings_amount);
        savings_percentage = (TextView) findViewById(R.id.savings_percentage);

        savings_percent = 25;

        savings_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                savings_percent = ((double) progress);
                savings_percentage.setText(progress + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });

        calculate_savings_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savings_entry = Double.parseDouble(payment_amount.getText().toString());

                just_savings =  savings_entry * savings_percent;

                savings_amount.setText(Double.toString(just_savings));


            }
        });





    }
}
