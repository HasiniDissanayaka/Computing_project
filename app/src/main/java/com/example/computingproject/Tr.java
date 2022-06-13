package com.example.computingproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Tr extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking);


        Button btn3=(Button)findViewById(R.id.test3);
        Button btn4=(Button)findViewById(R.id.test4);




        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Login = new Intent(Tr.this, coltoanu.class);
                Tr.this.
                        startActivity(Login);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Login = new Intent(Tr.this,coltoBadulla .class);
                Tr.this.
                        startActivity(Login);
            }
        });



    }
}
