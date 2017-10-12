package edu.csulb.android.intentslab;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.List;

public class ActivitiyLoaderActivitiy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitiy_loader_activitiy);
    }

    // Click on the web button, createChooser will be open for the user to select
    public void onClickWeb(View view)
    {
        // Set uri
        Uri website = Uri.parse("http://www.amazon.com");
        //Call intent
        Intent intent = new Intent(Intent.ACTION_VIEW, website);

        String chooser_title = "Open with";
        // Create intent to show chooser
        Intent chooser = Intent.createChooser(intent, chooser_title);

        // Verify the intent will resolve to at least one activity
        if(intent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(chooser);
        }

    }

    // Call when button is clicked
    public void onClickCall(View view)
    {
        // Dial the phone number
        Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "+194912344444"));
        startActivity(callIntent);


    }
}
