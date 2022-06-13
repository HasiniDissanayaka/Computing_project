package com.example.computingproject;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

import android.app.Dialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.example.computingproject.databinding.ActivityHithachiBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.HashMap;

public class Hithachi extends AppCompatActivity {

    private EditText name,nic,cnum,address,sstation,estation,sdate;
    private Button book;
    private Button update;
    private  Button guid;
    
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;

    StorageReference ref;

    FirebaseDatabase rootNode;
    DatabaseReference reference;
    ActivityHithachiBinding binding;
    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hithachi);
        binding = ActivityHithachiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        book = findViewById(R.id.button8);

       
        
        
        

        guid = findViewById(R.id.guid);

        guid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download();
            }
        });




        name = findViewById(R.id.name);

        nic = findViewById(R.id.nic);
        cnum = findViewById(R.id.cnum);
        sdate = findViewById(R.id.date);
        address =findViewById(R.id.address);
        sstation = findViewById(R.id.sstation);
        estation = findViewById(R.id.estation);
        book = findViewById(R.id.button8);
        update = findViewById(R.id.update);

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Hithachi");

                String Name = name.getText().toString().trim();
                String NIC = nic.getText().toString().trim().trim();
                String Connum = cnum.getText().toString().trim();
                String Address = address.getText().toString().trim();
                String Start = sstation.getText().toString().trim();
                String End = estation.getText().toString().trim();
                String Days = sdate.getText().toString().trim();
                //all the values





                    if (TextUtils.isEmpty(Name))  {
                        name.setError("Username is Required");
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
                    if (TextUtils.isEmpty(Address)) {
                        address.setError("Stay date is Required");
                        return;
                    }

                    if (TextUtils.isEmpty(Start)) {
                        sstation.setError("Password is Required");
                        return;
                    }
                    if (TextUtils.isEmpty(End)) {
                        estation.setError("Password is Required");
                        return;
                    }
                    else{

                        Uhelper uhelper = new Uhelper(Name, NIC, Connum, Address, Start, End, Days);
                        reference.child(NIC).setValue(uhelper);
                    }


                }

        });



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
                Toast.makeText(Hithachi.this, "CardPayment is Clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), Payment.class));
            }
        });
        paypalpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Hithachi.this, "Paypal payment is Clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), Paypal.class));
            }
        });
        googlepay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Hithachi.this, "Googlepay is Clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), Googlepay.class));
            }
        });


        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }

    private void updateData(String name, String nic, String cnum, String date, String address, String start, String end) {

        HashMap User = new HashMap();
        User.put("name",name);
        User.put("nic",nic);
        User.put("connum",cnum);
        User.put("days",date);
        User.put("start",start);
        User.put("end",end);
        User.put("address",address);

        reference = FirebaseDatabase.getInstance().getReference("Hithachi");
        reference.child(nic).updateChildren(User).addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                if(task.isSuccessful()){

                    binding.name.setText("");
                    binding.nic.setText("");
                    binding.cnum.setText("");
                    binding.date.setText("");
                    binding.address.setText("");
                    binding.sstation.setText("");
                    binding.estation.setText("");
                    Toast.makeText(Hithachi.this, "Successfuly updated", Toast.LENGTH_SHORT).show();


                }else{
                    Toast.makeText(Hithachi.this, "Failed to Update", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }
    public  void download(){
        storageReference = firebaseStorage.getInstance().getReference();
        ref = storageReference.child("hithachi.pdf");
        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {

                String url = uri.toString();
                downloadFile(Hithachi.this,"hithachi",".pdf",DIRECTORY_DOWNLOADS,url);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });

    }

    private void downloadFile(Context context, String fileName, String fileExtention, String destinationDirectory, String url) {
        DownloadManager downloadManager = (DownloadManager) context.
                getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, destinationDirectory,fileName+fileExtention);

        downloadManager.enqueue(request);



    }


}