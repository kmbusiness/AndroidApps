package edu.csulb.android.listviewlab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create the listview
        initiList();

        //Get the ListView component from the layout
        ListView lv = (ListView) findViewById(R.id.listView);

        // (context, data list, row layout that is used during the row creation, keys used to retrieve the data, view id used to show the data (The key number and the view id must match)
        SimpleAdapter simpleAdpt = new SimpleAdapter(this, planetsList,android.R.layout.simple_list_item_1, new String[] {"planet"}, new int[] {android.R.id.text1} );

        // Planets are added on to the listView through the adapter
        lv.setAdapter(simpleAdpt);

        // React to the user clicks on the item
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public void onItemClick(AdapterView<?> parentAdapter, View view, int position, long id)
          {
              //Type cast
              TextView clickedView = (TextView) view;

              Toast.makeText(MainActivity.this, "Item with id ["+id+"] - Position ["+position+"] - Planet ["+clickedView.getText()+"]", Toast.LENGTH_SHORT).show();

          }
        });
    }

    // initial a list of map object
    List <Map<String, String>> planetsList = new ArrayList<Map<String,String>>();

    // function to populate the list
    private void initiList()
    {
        planetsList.add(createPlanet("planet", "Mercury"));
        planetsList.add(createPlanet("planet", "Venus"));
        planetsList.add(createPlanet("planet", "Mars"));
        planetsList.add(createPlanet("planet", "Jupiter"));
        planetsList.add(createPlanet("planet", "Saturn"));
        planetsList.add(createPlanet("planet", "Uranus"));
        planetsList.add(createPlanet("planet", "Neptune"));
    }

    // Constructor for the map
    private HashMap <String, String> createPlanet(String key, String name)
    {
        HashMap<String, String> planet = new HashMap<String, String>();
        planet.put(key, name);

        return planet;
    }
}
