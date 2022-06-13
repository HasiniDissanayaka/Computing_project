package com.example.computingproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Timetablesearch extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetablesearch);

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Stations, R.layout.my_selected_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), "Selected", Toast.LENGTH_SHORT).show();
        if(parent.getItemAtPosition(position).equals("Kurunagala"))
        {
            Intent intent = new Intent(Timetablesearch.this,Timetable.class);
            startActivity(intent);
        }
        if(parent.getItemAtPosition(position).equals("Anurdhapurabt"))
        {
            Intent intent = new Intent(Timetablesearch.this,Timetable.class);
            startActivity(intent);
        }
        if(parent.getItemAtPosition(position).equals("Galle"))
        {
            Intent intent = new Intent(Timetablesearch.this,Timetable.class);
            startActivity(intent);
        }
        if(parent.getItemAtPosition(position).equals("Matara"))
        {
            Intent intent = new Intent(Timetablesearch.this,Timetable.class);
            startActivity(intent);
        }
        if(parent.getItemAtPosition(position).equals("Galgamuwa"))
        {
            Intent intent = new Intent(Timetablesearch.this,Timetable.class);
            startActivity(intent);
        }
        if(parent.getItemAtPosition(position).equals("Nuwaraeliya"))
        {
            Intent intent = new Intent(Timetablesearch.this,Timetable.class);
            startActivity(intent);
        }
        if(parent.getItemAtPosition(position).equals("Colombo Fort"))
        {
            Intent intent = new Intent(Timetablesearch.this,Timetable.class);
            startActivity(intent);
        }
        if(parent.getItemAtPosition(position).equals("Kandy"))
        {
            Intent intent = new Intent(Timetablesearch.this,Timetable.class);
            startActivity(intent);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
