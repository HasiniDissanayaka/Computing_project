package com.example.computingproject;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.computingproject.databinding.ActivityTicketbookingBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Ticketbooking extends AppCompatActivity {
    ActivityTicketbookingBinding binding;
    private DatabaseReference reference;
    private Button total, proceed;
    Spinner spiner;
    FirebaseDatabase rootNode;


    private TextView firstclz, scndclz, price;
    private EditText firstticket;
    EditText secondticket, date, month, time, name, email, contact;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticketbooking);
        binding = ActivityTicketbookingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        total = findViewById(R.id.totalval);
        firstclz = findViewById(R.id.price1st);
        scndclz = findViewById(R.id.price2nd);
        price = findViewById(R.id.totaltext);
        firstticket = findViewById(R.id.firstclasstickets);
        secondticket = findViewById(R.id.secondclasstickets);
        proceed = findViewById(R.id.proceed);
        spiner = findViewById(R.id.spinner1);
        date = findViewById(R.id.datee);
        month = findViewById(R.id.monthh);
        time = findViewById(R.id.timee);
        name = findViewById(R.id.name);
        email = findViewById(R.id.etemail);
        contact = findViewById(R.id.mobilenum);

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("firestclass");

                String Train = spiner.getSelectedItem().toString().trim();
                String Price = price.getText().toString().trim();
                String Date = date.getText().toString().trim();
                String Month = month.getText().toString().trim();
                String Time = time.getText().toString().trim();
                String Amount = firstticket.getText().toString();
                String Name = name.getText().toString().trim();
                String Contact = contact.getText().toString().trim();
                String Email = email.getText().toString().trim();
                FirestclassHelper helperclass = new FirestclassHelper(Train, Price, Date, Month, Time, Amount, Name, Contact, Email);

                reference.child(Contact).setValue(helperclass);
            }
        });

        total.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                double a, d, c;
                a = Double.parseDouble(firstclz.getText().toString());
                d = Double.parseDouble(firstticket.getText().toString());
                c = a * d;


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
                    Toast.makeText(Ticketbooking.this, "Please enter location", Toast.LENGTH_SHORT).show();


                }
            }
        });

        Spinner mySpinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(Ticketbooking.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.shedule));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);


    }



    private void showDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottomsheetlayout);

        LinearLayout cardpay = dialog.findViewById(R.id.card);
        LinearLayout paypalpay = dialog.findViewById(R.id.paypal);
        LinearLayout googlepay = dialog.findViewById(R.id.googlepay);

        cardpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Ticketbooking.this, "CardPayment is Clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), Payment.class));
            }
        });
        paypalpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Ticketbooking.this, "Paypal is Clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), Paypal.class));
            }
        });
        googlepay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Ticketbooking.this, "Googlepay is Clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), Googlepay.class));
            }
        });


        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }

    private void Ticketbooking(String location) {
        reference = FirebaseDatabase.getInstance().getReference("TicketPrices");
        reference.child(location).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {
                    if (task.getResult().exists()) {

                        Toast.makeText(Ticketbooking.this, "Successfuly ", Toast.LENGTH_SHORT).show();
                        DataSnapshot dataSnapshot = task.getResult();
                        String firstclass = String.valueOf(dataSnapshot.child("firstclass").getValue());
                        String secondclass = String.valueOf(dataSnapshot.child("secondclass").getValue());

                        binding.price1st.setText(firstclass);
                        binding.price2nd.setText(secondclass);


                    } else {
                        Toast.makeText(Ticketbooking.this, "Location doesn't exist", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(Ticketbooking.this, "Faild to read", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}





