package com.example.computingproject;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;

public class Dahboard extends AppCompatActivity {

    FloatingActionButton train, resorts, travel;
    FirebaseAuth Fauth;
    Button logoutbt, no, yes;

    Dialog logout;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_dashboard);

        FloatingActionButton travel = findViewById(R.id.travel);
        travel.setOnClickListener(v -> {
            Intent intent = new Intent(this, Dahmain.class);
            startActivity(intent);
        });


        FloatingActionButton resorts = findViewById(R.id.resorts);
        resorts.setOnClickListener(v -> {
            Intent intent = new Intent(this, Deleteresortbook.class);
            startActivity(intent);

        });
        FloatingActionButton train = findViewById(R.id.train);
        train.setOnClickListener(v -> {
            Intent intent = new Intent(this, TrainBookingOption.class);
            startActivity(intent);

        });
    }
}




