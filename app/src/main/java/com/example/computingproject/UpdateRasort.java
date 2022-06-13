package com.example.computingproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.computingproject.databinding.ActivityUpdateRasortBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class UpdateRasort extends AppCompatActivity {
    private EditText name, nic, cnum, adate, ddate, sdate;
    private Spinner spiner;
    private android.app.ProgressDialog ProgressDialog;


    private Button book;
    private Button update;

    ActivityUpdateRasortBinding binding;

    private FirebaseAuth fAuth;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    String NIC, resort;
    private String isroomavailable = "";
    private String resortname ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_rasort);
        setContentView(R.layout.activity_update_rasort);
        binding = ActivityUpdateRasortBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        name = findViewById(R.id.pname);

        nic = findViewById(R.id.nic);
        cnum = findViewById(R.id.cnum);
        sdate = findViewById(R.id.days);
        spiner = findViewById(R.id.spiner);
        adate = findViewById(R.id.adate);
        ddate = findViewById(R.id.ddate);

        update = findViewById(R.id.update);

        fAuth = FirebaseAuth.getInstance();


        binding.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = binding.pname.getText().toString();
                String nic = binding.nic.getText().toString();
                String connum = binding.cnum.getText().toString();
                String days = binding.days.getText().toString();
                String resorts = binding.spiner.getSelectedItem().toString();
                String arrival = binding.adate.getText().toString();
                String departure = binding.ddate.getText().toString();


                Update(name, nic, connum, days, resorts, arrival, departure);

            }
        });












        Spinner mySpiner = (Spinner) findViewById(R.id.spiner);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(UpdateRasort.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpiner.setAdapter(myAdapter);




    }

    private void DataSave(String name, String NIC, String connum, String days, String resort, String arrival, String departure, String roomstatus) {

        Log.d("DBRESORT",resortname);
        Log.d("RESORT",resort);

        if(resortname.equals(resort)){

            if (isroomavailable.equals("book")){
                Toast.makeText(UpdateRasort.this, "This room is already booked", Toast.LENGTH_SHORT).show();

            }else {
                UserHelper helperclass = new UserHelper(name, NIC, connum, days, resort, arrival, departure,roomstatus);
                reference.child(NIC).setValue(helperclass).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        startActivity(new Intent(getApplicationContext(), Paypal.class));
                    }
                });

            }

        }else {
            UserHelper helperclass = new UserHelper(name, NIC, connum, days, resort, arrival, departure,roomstatus);
            reference.child(NIC).setValue(helperclass).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    startActivity(new Intent(getApplicationContext(), Paypal.class));
                }
            });

        }

    }


    private void Update(String username, String nic,String cnum, String sdate, String spiner, String adate, String ddate) {
        HashMap User = new HashMap();
        User.put("name",username);
        User.put("nic",nic);
        User.put("connum",cnum);
        User.put("days",sdate);
        User.put("resort",spiner);
        User.put("arrival",adate);
        User.put("departure",ddate);



        reference = FirebaseDatabase.getInstance().getReference("Book");
        reference.child(nic).updateChildren(User).addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                if(task.isSuccessful()){

                    binding.pname.setText("");
                    binding.nic.setText("");
                    binding.cnum.setText("");
                    binding.days.setText("");
                    binding.spiner.getSelectedItem();
                    binding.adate.setText("");
                    binding.ddate.setText("");
                    Toast.makeText(UpdateRasort.this, "Successfuly updated", Toast.LENGTH_SHORT).show();


                }else{
                    Toast.makeText(UpdateRasort.this, "Failed to Update", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        LoadIfResortAvailable();
    }

    private void LoadIfResortAvailable() {

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Book");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    for (DataSnapshot ds : snapshot.getChildren()) {
                        isroomavailable = "" + ds.child("roomstatus").getValue();
                        resortname = "" + ds.child("resort").getValue();
                        Log.d("DBSS",resortname);
                        Log.d("isroomavailable",isroomavailable);

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateRasort.this, ""+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

