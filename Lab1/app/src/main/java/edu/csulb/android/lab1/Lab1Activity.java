package edu.csulb.android.lab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class Lab1Activity extends AppCompatActivity {

    public static String EXTRA_MESSAGE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1);

        // Retrieve the hashmap in which with the username
        Bundle myInput = this.getIntent().getExtras();

        TextView t = new TextView(this);
        t = (TextView) findViewById(R.id.textView);
        t.setText("Hello " + (myInput.getString("uname")));


        /*
        //  Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(Lab1Activity.EXTRA_MESSAGE);

        //  Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("Hello " + message); // Print message
        */
    }


}
