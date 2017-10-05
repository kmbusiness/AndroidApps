package edu.csulb.android.zoolist;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class getDetails extends AppCompatActivity
{

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.details);

        // get intent
        Bundle input = this.getIntent().getExtras();


        String animalName = input.getString("animalName");
        //TextView t; Basically same thing as code below
        TextView t = new TextView(this);
        t = (TextView) findViewById(R.id.animalName);
        t.setText(animalName);


        TextView moreInfo = new TextView(this);
        moreInfo = (TextView) findViewById(R.id.moreInfo);

        // Get the imgid and set the image based on the position of the onclick
        int imgid = input.getInt("animalPic");
        if(imgid == 0)
        {
            ImageView img = (ImageView)findViewById(R.id.imageFull);
            img.setImageResource(R.drawable.pic1);
            moreInfo.setText(animalName + "s love to eat bamboo and sleep.");
        }
        else if (imgid == 1)
        {
            ImageView img = (ImageView)findViewById(R.id.imageFull);
            img.setImageResource(R.drawable.pic2);
            moreInfo.setText(animalName + "s love to eat meat and lick their paws.");
        }
        else if (imgid == 2)
        {
            ImageView img = (ImageView)findViewById(R.id.imageFull);
            img.setImageResource(R.drawable.pic3);
            moreInfo.setText(animalName + "s love to eat meat and play in the snow.");
        }
        else if (imgid == 3)
        {
            ImageView img = (ImageView)findViewById(R.id.imageFull);
            img.setImageResource(R.drawable.pic4);
            moreInfo.setText(animalName + "s love to eat meat and play with their pride");
        }
        else
        {
            ImageView img = (ImageView)findViewById(R.id.imageFull);
            img.setImageResource(R.drawable.pic5);
            moreInfo.setText(animalName + "s love to eat berries and jump around");
        }



        // Print the int
        //t.setText(String.valueOf(imgid));

    }

    // Create the action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    //Menu option response
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.about:
            {
                Intent intent = new Intent(getApplicationContext(),ZooInfo.class);
                startActivity(intent);
                return true;
            }
            case R.id.uninstall:
            {
                // Uninstall the app
                Uri packageURI = Uri.parse("package:"+MainActivity.class.getPackage().getName());
                Intent uninstallIntent = new Intent(Intent.ACTION_DELETE, packageURI);
                startActivity(uninstallIntent);
                return true;
            }
        }
        return(super.onOptionsItemSelected(item));
    }
}
