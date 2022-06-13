package com.example.computingproject;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Contactus extends AppCompatActivity {

    public EditText mEmail;
    public EditText mSubject;
    public EditText mMessage;
    public Button mailbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);

        mEmail =  findViewById(R.id.mailID);
        mSubject = findViewById(R.id.subjectID);
        mMessage = findViewById(R.id.messageID);
        mailbutton = findViewById(R.id.mailbtn);

        mailbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("mailto:"+mEmail.getText().toString()));
                intent.putExtra(Intent.EXTRA_SUBJECT,mSubject.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT,mMessage.getText().toString());
                startActivity(intent);

            }


        });

    }

}