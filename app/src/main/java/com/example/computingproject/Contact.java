package com.example.computingproject;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.computingproject.databinding.ActivityContactBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Contact extends AppCompatActivity {
   ActivityContactBinding binding;
    EditText Name,Email,Message;
    FirebaseDatabase db;
    DatabaseReference reference;
    private FirebaseAuth fAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContactBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        Name = findViewById(R.id.nameedt);
        Email = findViewById(R.id.emailedt);
        Message = findViewById(R.id.msgedt);


     binding.sendbtn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             db = FirebaseDatabase.getInstance();
             reference = db.getReference("ContactUs");
             String  name = Name.getText().toString().trim().trim();
             String  email = Email.getText().toString().trim().trim();
             String  message = Message.getText().toString().trim();

             //all the values


             Messageuser user = new Messageuser(name,email,message);




             reference.setValue(user);







         }
     });




    }
}