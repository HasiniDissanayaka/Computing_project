package com.example.computingproject;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Trainbooking extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private Spinner Astation,Estation,Stime,Etime,Date;
    private Button Btn,datepickerbtn;
    private TextView dateText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainbooking);
        dateText = findViewById(R.id.setText);
        findViewById(R.id.date_picker_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();

            }
        });
    }
        private void showDatePickerDialog(){
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    this,
                    this,
                    Calendar.getInstance().get(Calendar.YEAR),
                    Calendar.getInstance().get(Calendar.MONTH),
                    Calendar.getInstance().get(Calendar.DAY_OF_MONTH)


            );
            datePickerDialog.show();
        }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = "month/date/year:"+month+"/"+dayOfMonth+"/"+year;
        dateText.setText(date);


    }
}










