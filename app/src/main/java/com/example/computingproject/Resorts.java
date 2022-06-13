package com.example.computingproject;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.computingproject.databinding.ActivityResorts2Binding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Resorts extends AppCompatActivity {
    private EditText name, nic, cnum, adate, ddate, sdate;
    private Spinner spiner;
    private android.app.ProgressDialog ProgressDialog;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    StorageReference ref;

    private Button book;
    private Button update;
    private  Button guid;

    ActivityResorts2Binding binding;

    private FirebaseAuth fAuth;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    String NIC, resort;
    private String isroomavailable = "";
    private String resortname ="";


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resorts2);
        binding = ActivityResorts2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        name = findViewById(R.id.pname);

        nic = findViewById(R.id.nic);
        cnum = findViewById(R.id.cnum);
        sdate = findViewById(R.id.days);
        spiner = findViewById(R.id.spiner);
        adate = findViewById(R.id.adate);
        ddate = findViewById(R.id.ddate);
        book = findViewById(R.id.button8);


        fAuth = FirebaseAuth.getInstance();
        guid = findViewById(R.id.guid);

        guid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download();
            }
        });





        book.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                showDialog();



                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Book");


                String Name = name.getText().toString().trim();
                String NIC = nic.getText().toString().trim().trim();
                String Connum = cnum.getText().toString().trim();
                String Days = sdate.getText().toString().trim();
                String Resort = spiner.getSelectedItem().toString();
                String Arrival = adate.getText().toString().trim();
                String Departure = ddate.getText().toString().trim();
                String roomstatus = "book";


                if (TextUtils.isEmpty(Name)) {
                    name.setError("Arrivsl date is Required");
                    return;
                }
                if (TextUtils.isEmpty(NIC)) {
                    nic.setError("NIC is Required");
                    return;
                }
                if(NIC.length ()<10){
                    nic.setError("Password Must Be >=8 Characters");
                    return;
                }
                if (TextUtils.isEmpty(Connum)) {
                    cnum.setError("Contact Number is Required");
                    return;
                }
                if(Connum.length ()<10){
                    cnum.setError("Phone Number Must Be 10 Characters");
                    return;
                }
                if (TextUtils.isEmpty(Days)) {
                    sdate.setError("Stay date is Required");
                    return;
                }
                if (TextUtils.isEmpty(Resort)) {
                    sdate.setError("Stay date is Required");
                    return;
                }

                if (TextUtils.isEmpty(Arrival)) {
                    adate.setError("Arrival date is Required");
                    return;
                }
                if (TextUtils.isEmpty(Departure)) {
                    ddate.setError("Password is Required");
                    return;
                }else {
                    DataSave(Name, NIC, Connum, Days, Resort, Arrival, Departure,roomstatus);

                }
                //all the values






                List<String> Categories = new ArrayList<>();
                Categories.add("Nuwara Eliya A1");
                Categories.add("Nuwara Eliya Old");
                Categories.add("Nuwara Eliya B");
                Categories.add("Diyathalawa A");
                Categories.add("Diyathalawa B");
                Categories.add("Bandarawela");





            }
        });


        Spinner mySpiner = (Spinner) findViewById(R.id.spiner);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(Resorts.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpiner.setAdapter(myAdapter);




    }

    private void download() {

            storageReference = firebaseStorage.getInstance().getReference();
            ref = storageReference.child("Guideline for Resort Booking.pdf");
            ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {

                    String url = uri.toString();
                    downloadFile(Resorts.this, "Guideline for Resort Booking", ".pdf", DIRECTORY_DOWNLOADS, url);

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });

        }

        private void downloadFile (Context context, String fileName, String fileExtention, String
        destinationDirectory, String url)
        {
            DownloadManager downloadManager = (DownloadManager) context.
                    getSystemService(Context.DOWNLOAD_SERVICE);
            Uri uri = Uri.parse(url);
            DownloadManager.Request request = new DownloadManager.Request(uri);
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
            request.setDestinationInExternalFilesDir(context, destinationDirectory, fileName + fileExtention);

            downloadManager.enqueue(request);


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
                Toast.makeText(Resorts.this, "CardPayment is Clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), Payment.class));
            }
        });
        paypalpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Resorts.this, "Paypal is Clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), Paypal.class));
            }
        });
        googlepay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Resorts.this, "Googlepay is Clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), Googlepay.class));
            }
        });


        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }

    private void DataSave(String name, String NIC, String connum, String days, String resort, String arrival, String departure, String roomstatus) {

        Log.d("DBRESORT",resortname);
        Log.d("RESORT",resort);

        if(resortname.equals(resort)){

            if (isroomavailable.equals("book")){
                Toast.makeText(Resorts.this, "This room is already booked", Toast.LENGTH_SHORT).show();

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
                    Toast.makeText(Resorts.this, "Successfuly updated", Toast.LENGTH_SHORT).show();


                }else{
                    Toast.makeText(Resorts.this, "Failed to Update", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(Resorts.this, ""+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void onBackPressed() {

        finish();
        Intent intent = new Intent(Resorts.this, Dahmain.class);
        startActivity(intent);
    }
}

