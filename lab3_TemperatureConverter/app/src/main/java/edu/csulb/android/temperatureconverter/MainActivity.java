package edu.csulb.android.temperatureconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (EditText) findViewById(R.id.editText);
    }

    // Create onClick for the button
    public void onClick (View view)
    {
        switch(view.getId())
        {
            case R.id.button:
                RadioButton cButton = (RadioButton) findViewById(R.id.radioButton8);
                RadioButton fButton = (RadioButton) findViewById(R.id.radioButton9);

                if(text.getText().length() == 0)
                {
                    Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_LONG).show();
                    return;
                }
                // New float input for parameter for the function
                float inputValue = Float.parseFloat(text.getText().toString());
                if(cButton.isChecked())
                {
                    text.setText(String.valueOf(utility.convertFtoC(inputValue)));
                    cButton.setChecked(false);
                    fButton.setChecked(true);
                }
                else
                {
                    text.setText(String.valueOf(utility.convertCtoF(inputValue)));
                    fButton.setChecked(false);
                    cButton.setChecked(true);
                }
                break;
        }
    }
}
