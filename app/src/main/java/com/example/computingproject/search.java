package com.example.computingproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class search extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Button first = findViewById(R.id.first);
        first.setOnClickListener(v -> {
            Intent intent = new Intent(this, Ticketbooking.class);
            startActivity(intent);
        });
        Button second = findViewById(R.id.second);
        second.setOnClickListener(v -> {
            Intent intent = new Intent(this, secondclz.class);
            startActivity(intent);
        });




    }



    }