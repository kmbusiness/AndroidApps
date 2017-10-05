package edu.csulb.android.zoolist;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{


    android.widget.ImageView animalPic;
    android.widget.TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declare the list for the adapter
        ListView list;
        final String[] animals = {"Panda", "Tiger", "Snow Leopard", "Lion", "Kangaroo"};
        final Integer[] imgid = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5};

        //Calling the constructor
        CustomListAdapter adapter = new CustomListAdapter(this, animals, imgid);
        list = (ListView)findViewById(R.id.customView);

        //Set up the list using the adapter from the CustomListAdapter
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id)
            {
                // If the user click on the last box an alert dialog will run
                if(position == 4)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                    builder.setTitle("Warning");
                    builder.setMessage("The following animal is very scary, do you want to continue?");

                    builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which)
                        {
                            //Create intent
                            Intent intent = new Intent(getApplicationContext(),getDetails.class);
                            //Send the animal name
                            intent.putExtra("animalName", animals[position]);
                            //Send the animal picture
                            intent.putExtra("animalPic", position);
                            startActivity(intent);
                        }
                    });

                    builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            // Do nothing
                            dialog.dismiss();
                        }
                    });

                    AlertDialog alert = builder.create();
                    alert.show();
                }
                // If not the last item on the list there will be no warning
                else
                {
                    //Create intent
                    // parameter is from which activity to which
                    Intent intent = new Intent(getApplicationContext(),getDetails.class);
                    //Send the animal name
                    intent.putExtra("animalName", animals[position]);
                    //Send the animal position, that will be use for the animal picture
                    intent.putExtra("animalPic", position);
                    startActivity(intent);
                }

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
