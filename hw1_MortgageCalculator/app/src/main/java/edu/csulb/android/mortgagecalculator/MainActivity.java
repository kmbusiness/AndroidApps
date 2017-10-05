package edu.csulb.android.mortgagecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // For the progress bar from the interest rate seekbar
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        final TextView textView = (TextView) findViewById(R.id.seekBarValue);

        // On create get the progress bar
        textView.setText(String.valueOf((float) seekBar.getProgress() / 10) + "%");

        // Get value of the seekbar when moving the dot
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                float decimalProgress = (float) progress / 10;
                textView.setText(String.valueOf(decimalProgress) + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
        });

    }


    public void onClick(View view) {
        // Amount borrowed called
        EditText amount = (EditText) findViewById(R.id.amountBorrowed);

        String regex = "[0-9]+(\\.[0-9][0-9]?)?";

        // Check for correct regex for ammount input
        if (amount.getText().toString().trim().matches(regex)) {
            CheckBox checked = (CheckBox) findViewById(R.id.checkBox);
            TextView answer = (TextView) findViewById(R.id.answer);

            //Amount borrowed (P)
            double inputAmount = Double.parseDouble(amount.getText().toString());

            //Interest
            SeekBar seek = (SeekBar) findViewById(R.id.seekBar);
            // Divide by 10 cause the Min - 100 and Max is 200. so divide by 10 will get the decimal
            double inputRate = (double) seek.getProgress() / 10;

            // Years
            // Select the radio group
            RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
            // Get the the id into a string
            String radiovalue = ((RadioButton) findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();
            // Get the sub string of the second and third letters for the number
            String radioVal = radiovalue.substring(0, 3);
            // Assign the number into the year
            double years = Double.valueOf(radioVal);

            // j
            double j = (double) (inputRate / 100) / 1200;
            // n
            double n = (double) years * 12;


            // Tax
            double tax = (double) ((inputAmount * 0.01));

            //double tax = 0;
            //answer.setText("$" + String.format("%.2f",(calculate.calculateZero(inputAmount, n, tax))));
            //answer.setText("$" + String.format("%.2f",(calculate.calculate(inputAmount, j, n, tax))));

            //answer.setText(String.valueOf(j));

            // Check for if the check box is clicked or not
            boolean theBox = false;
            if(checked.isChecked())
            {
                theBox = true;
            }
            else
            {
                theBox = false;
            }


            // For the monthly payment textbox
            TextView hidden = (TextView) findViewById(R.id.textView);


            // If interest rate not 0
            if(theBox == true && inputRate != 0)
            {
                hidden.setVisibility(View.VISIBLE);
                answer.setText("$" + String.format("%.2f",(calculate.calculate(inputAmount, j, n, tax))));
            }
            // If interest rate is 0
            else if (theBox == true && inputRate == 0)
            {
                hidden.setVisibility(View.VISIBLE);
                answer.setText("$" + String.format("%.2f",(calculate.calculateZero(inputAmount, n, tax))));
            }
            // No check so don't add tax
            else if (theBox == false && inputRate == 0)
            {
                hidden.setVisibility(View.VISIBLE);
                tax = 0;
                answer.setText("$" + String.format("%.2f",(calculate.calculateZero(inputAmount, n, tax))));
            }
            else
            {
                hidden.setVisibility(View.VISIBLE);
                tax = 0;
                answer.setText("$" + String.format("%.2f",(calculate.calculate(inputAmount, j, n, tax))));
            }
        }
        // Not correct input will display a message
        else
        {
            Toast.makeText(this, "Please enter a valid amount", Toast.LENGTH_LONG).show();
            return;
        }


        }

    }
