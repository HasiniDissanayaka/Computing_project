package com.example.computingproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Editprofile extends AppCompatActivity {

    public static final String TAG = "TAG";
    EditText profilename,profileemail,profilephone;
    ImageView profileimg;
    Button save;
    FirebaseAuth fAuth;
    FirebaseFirestore fStrore;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);

        Intent data = getIntent();
        String name = data.getStringExtra("name");
        String email = data.getStringExtra("email");
        String number = data.getStringExtra("phone");

        fAuth = FirebaseAuth.getInstance();
        fStrore = FirebaseFirestore.getInstance();
        user = fAuth.getCurrentUser();

        profilename = findViewById(R.id.name);
        profileemail = findViewById(R.id.email);
        profilephone = findViewById(R.id.contactnum);

        save = findViewById(R.id.edit);



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(profilename.getText().toString().isEmpty() || profilename.getText().toString().isEmpty() || profilephone.getText().toString().isEmpty() )
                    Toast.makeText(Editprofile.this, "One or Many field are empty", Toast.LENGTH_SHORT).show();
                return;
            }
            final String email = profileemail.getText().toString();

            public String getEmail() {
                user.updateEmail(email).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        DocumentReference documentReference = fStrore.collection("users").document(user.getUid());
                        Map<String,Object> edited = new HashMap<>();
                        edited.put("email",email);
                        edited.put("fname",profilename.getText().toString());
                        edited.put("cnumber",profilephone.getText().toString());
                        documentReference.update(edited).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(Editprofile.this, "Profile updated", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),Profile.class));
                                finish();
                            }
                        });

                        Toast.makeText(Editprofile.this, "Email is Changed", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Editprofile.this, "Email is not changed", Toast.LENGTH_SHORT).show();

                    }
                });

                return email;
            }
        });

        profileemail.setText(email);
        profilename.setText(name);
        profilephone.setText(number);


        Log.d(TAG,"onCreate:"+name+""+email+""+number);
    }
}