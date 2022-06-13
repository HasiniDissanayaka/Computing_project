package com.example.computingproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Otherservices extends AppCompatActivity {

    Button resors,season,hithachi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otherservices);

        resors = findViewById(R.id.resorts);
        season = findViewById(R.id.season);
        hithachi = findViewById(R.id.hithachi);

        resors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Resorts.class));
            }


        });
        hithachi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Hithachi.class));
            }
        });

    }

}