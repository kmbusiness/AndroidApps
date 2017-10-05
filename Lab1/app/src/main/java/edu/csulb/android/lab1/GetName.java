package edu.csulb.android.lab1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//My new imports
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class GetName extends Activity implements android.view.View.OnClickListener {

    // Holds reference to text field in which the user will enter their name
    android.widget.EditText name;
    android.widget.Button button;

    public void onClick(View view) {
        // Send this intent to Lab1Activity
        Intent myIntent = new Intent(this,Lab1Activity.class);
        //  <key>, <value>
        myIntent.putExtra("uname", name.getText().toString());
        //  This command will initiate the switch to the Lab1Activity greeting Activity
        this.startActivity(myIntent);

    }

    // Override method by using superk
    // Called when the GetName starts and is where initialiaztion of local and member data will be done
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_get_name);

        // Was declared up above
        name = (EditText) this.findViewById(R.id.editText);
        button = (Button) this.findViewById(R.id.button2);

        button.setOnClickListener(this);
    }
}
