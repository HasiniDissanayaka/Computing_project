package com.example.computingproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class TrainBookingOption extends AppCompatActivity {

    Button trainshedule,trainbook,seasonticket,timetable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_booking_option);

        Button trainshedule = findViewById(R.id.shedule);
        trainshedule.setOnClickListener(v -> {
            Intent intent = new Intent(this,LgActivity.class);
            startActivity(intent);
        });

        Button firstclass = findViewById(R.id.firstclz);
        firstclass.setOnClickListener(v -> {
            Intent intent = new Intent(this, Ticketbooking.class);
            startActivity(intent);
        });
        Button secondclass = findViewById(R.id.secondclz);
        secondclass.setOnClickListener(v -> {
            Intent intent = new Intent(this, secondclz.class);
            startActivity(intent);
        });
    }
}