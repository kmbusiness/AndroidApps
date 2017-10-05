package edu.csulb.android.zoolist;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ZooInfo extends AppCompatActivity
{
    // On create load this page
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.zooinfo);


        //Listener could only work in on create
        //When the phone number is clicked
        TextView phoneNum = (TextView)findViewById(R.id.phoneNum);
        phoneNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                // Dial the phone number
                Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "888 8888"));
                startActivity(callIntent);
            }
        });

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