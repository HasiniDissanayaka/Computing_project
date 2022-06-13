package com.example.computingproject;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.computingproject.databinding.ActivityUpdatefirstclzBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Updatefirstclz extends AppCompatActivity {

    ActivityUpdatefirstclzBinding binding;
    DatabaseReference databaseRefernce;
    FirebaseDatabase rootNode;
    private Button total, proceed;
    private  Spinner spiner1;
    private TextView firstclz, scndclz, price;
    private EditText firstticket;
    EditText secondticket, date, month, time, name, email, contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatefirstclz);
        binding = ActivityUpdatefirstclzBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        total = findViewById(R.id.totalval);
        firstclz = findViewById(R.id.price1st);
        scndclz = findViewById(R.id.price2nd);
        price = findViewById(R.id.totaltext);
        firstticket = findViewById(R.id.firstclasstickets);
        secondticket = findViewById(R.id.secondclasstickets);
        proceed = findViewById(R.id.proceed);
        spiner1 = findViewById(R.id.spinner1);
        date = findViewById(R.id.datee);
        month = findViewById(R.id.monthh);
        time = findViewById(R.id.timee);
        name = findViewById(R.id.name);
        email = findViewById(R.id.etemail);
        contact = findViewById(R.id.mobilenum);

        total.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                double a,d,c;
                a= Double.parseDouble(firstclz.getText().toString());
                d= Double.parseDouble(firstticket.getText().toString());
                c=a*d;


                price.setText(Double.toString(c));


            }
        });




        binding.search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String location = binding.spinner1.getSelectedItem().toString();
                if (!location.isEmpty()) {
                    Ticketbooking(location);
                } else {
                    Toast.makeText(Updatefirstclz.this, "Please enter location", Toast.LENGTH_SHORT).show();


                }
            }
        });

        Spinner mySpinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(Updatefirstclz.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.shedule));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);
    }


    private void Ticketbooking(String location) {
        databaseRefernce = FirebaseDatabase.getInstance().getReference("TicketPrices");
        databaseRefernce.child(location).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {
                    if (task.getResult().exists()) {

                        Toast.makeText(Updatefirstclz.this, "Successfuly ", Toast.LENGTH_SHORT).show();
                        DataSnapshot dataSnapshot = task.getResult();
                        String firstclass = String.valueOf(dataSnapshot.child("firstclass").getValue());
                        String secondclass = String.valueOf(dataSnapshot.child("secondclass").getValue());

                        binding.price1st.setText(firstclass);
                        binding.price2nd.setText(secondclass);


                    } else {
                        Toast.makeText(Updatefirstclz.this, "Location doesn't exist", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(Updatefirstclz.this, "Faild to read", Toast.LENGTH_SHORT).show();
                }
            }
        });
        binding.proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String train = binding.spinner1.getSelectedItem().toString().trim();
                String price = binding.price1st.getText().toString().trim();
                String date = binding.datee.getText().toString().trim();
                String month = binding.monthh.getText().toString().trim();
                String time = binding.monthh.getText().toString().trim();
                String amount = binding.firstclasstickets.getText().toString().trim();
                String name = binding.name.getText().toString().trim();
                String contact = binding.mobilenum.getText().toString().trim();
                String email = binding.etemail.getText().toString().trim();

                updateData(train, price, date, month, time, amount, name, contact, email);

            }

        });
    }

    private void updateData(String train, String price, String date, String month, String time, String amount, String name, String contact, String email) {
        HashMap User = new HashMap();
        User.put("train", train);
        User.put("price", price);
        User.put("date", date);
        User.put("month", month);
        User.put("time", time);
        User.put("amount", amount);
        User.put("name", name);
        User.put("contact", contact);
        User.put("email", email);

        databaseRefernce = FirebaseDatabase.getInstance().getReference("firestclass");
        databaseRefernce.child(contact).updateChildren(User).addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {


                if (task.isSuccessful()) {
                    binding.spinner1.getSelectedItem();
                    binding.price1st.setText("");
                    binding.datee.setText("");
                    binding.datee.setText("");
                    binding.mobilenum.setText("");
                    binding.timee.setText("");
                    binding.name.setText("");
                    binding.mobilenum.setText("");
                    binding.etemail.setText("");

                    Toast.makeText(Updatefirstclz.this, "Successfully Updated", Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(Updatefirstclz.this, "Faild to Update", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}