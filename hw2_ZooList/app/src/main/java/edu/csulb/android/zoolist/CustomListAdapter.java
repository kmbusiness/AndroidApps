package edu.csulb.android.zoolist;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class CustomListAdapter extends ArrayAdapter<String>
{
    private final Activity context;
    private final String[] animal;
    private final Integer[] imgid;

    //Constructor (Activity, animalName, imgid)
    public CustomListAdapter(Activity context, String[] itemname, Integer[] imgid)
    {
        super(context, R.layout.mylist, itemname);


        this.context=context;
        this.animal=itemname;
        this.imgid=imgid;
    }

    @Override
    public View getView(int position,View view,ViewGroup parent)
    {
        LayoutInflater inflater=context.getLayoutInflater();
        //Each row using the custom mylist.xml
        View rowView=inflater.inflate(R.layout.mylist, null,true);


        TextView txtTitle = (TextView) rowView.findViewById(R.id.rowText);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.rowImage);

        // Set Text
        txtTitle.setText(animal[position]);
        // Set View
        imageView.setImageResource(imgid[position]);
        return rowView;

    };



}
