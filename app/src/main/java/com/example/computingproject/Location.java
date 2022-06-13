package com.example.computingproject;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Location extends AppCompatActivity {

    EditText etsource,destination;
    Button track;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        etsource = findViewById(R.id.et_source);
        destination = findViewById(R.id.destination);
        track = findViewById(R.id.bt_track);

        track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sSource = etsource.getText().toString().trim();
                String sDestination = destination.getText().toString().trim();

                if (sSource.equals("")&& sDestination.equals("")){
                    Toast.makeText(getApplicationContext()
                    ,"Enter both location",Toast.LENGTH_SHORT).show();
                }else {
                    DisplayTrack(sSource,sDestination);
                }
            }
        });


    }

    private void DisplayTrack(String sSource, String sDestination) {
        try {
            Uri uri = Uri.parse("https://www.google.co.in/maps/dir/"+sSource+"/"+sDestination);
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            intent.setPackage("com.google.android.apps.maps");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }catch (ActivityNotFoundException e){
            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps");
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        }
    }
}