package com.example.computingproject;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class ofeditpro extends AppCompatActivity {

    EditText compass, unic, phnumber, pemail, laname, faname, pass;
    FloatingActionButton savemenu;
    FirebaseDatabase database;
    DatabaseReference userRef;
    FirebaseAuth fAuth;
    FirebaseUser user;
    FirebaseFirestore fstore;
    private static final String USER = "user";
    String currentUserNIC;
    ProgressDialog ProgressDialog;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    Dialog sure;
    Button yes,no;

    String saveUserEmail, ConfirmPassword, saveUserPassword,
            saveUserFName , saveUserLName, saveUserPhone, saveUserNIC;


    @Override
    protected void onStart ( ) {

        super.onStart ( );
        ProgressDialog = new ProgressDialog (ofeditpro.this);
        ProgressDialog.show();
        ProgressDialog.setContentView ( R.layout.loadpg );
        ProgressDialog.getWindow ().setBackgroundDrawableResource (
                android.R.color.transparent
        );

    }


    void getCurrentUserUUID ( ) {

        FirebaseUser user = FirebaseAuth.getInstance ( ).getCurrentUser ( );
        if (user != null) {
            currentUserNIC = user.getUid ( );
        } else {
                startActivity ( new Intent ( getApplicationContext ( ) , lgnpg.class ) );
                finish ( );
            currentUserNIC = "UserID";
        }
        Toast.makeText ( this , currentUserNIC.toString ( ) , Toast.LENGTH_SHORT ).show ( );

    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_ofeditpro );

        Intent intent = getIntent ( );
        String email = intent.getStringExtra ( "email" );

        pass = findViewById ( R.id.pass );
        compass = findViewById ( R.id.compass);
        unic = findViewById ( R.id.nic );
        phnumber = findViewById ( R.id.phnumber );
        pemail = findViewById ( R.id.email );
        laname = findViewById ( R.id.laname );
        faname = findViewById ( R.id.faname );
        savemenu = findViewById ( R.id.savemenu );
        fAuth = FirebaseAuth.getInstance ();




        sure = new Dialog (ofeditpro.this);
        sure .setContentView ( R.layout.sure );
        sure .getWindow ().setBackgroundDrawable ( getDrawable ( R.drawable.bg_logout) );
        sure .getWindow ().setLayout ( ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT );


        yes = sure .findViewById ( R.id.yes);
        no = sure .findViewById ( R.id.no);

        no.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick ( View v ) {
                Toast.makeText ( ofeditpro.this , "save Canceled" , Toast.LENGTH_SHORT ).show ( );
                sure.dismiss ();
            }
        } );

        yes.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick ( View v ) {
                saveUserEmail = pemail.getText ().toString ().trim ();
                ConfirmPassword = compass.getText ().toString ().trim ();
                saveUserPassword = pass.getText ().toString ().trim ();
                saveUserFName = faname.getText ().toString ().trim ();
                saveUserLName = laname.getText  ().toString ().trim ();
                saveUserPhone = phnumber.getText ().toString ().trim ();
                saveUserNIC = unic.getText ().toString ().trim ();

                sure.dismiss ( );
                startActivity ( new Intent ( getApplicationContext (),Dahmain.class  ) );
                ProgressDialog = new ProgressDialog (ofeditpro.this);
                ProgressDialog.show();
                ProgressDialog.setContentView ( R.layout.loadpg );
                ProgressDialog.getWindow ().setBackgroundDrawableResource (
                        android.R.color.transparent
                );


                try {
                    HashMap userMap = new HashMap<>();
                    userMap.put("Password", saveUserPassword);
                    userMap.put("Firs Name", saveUserFName);
                    userMap.put("Last Name", saveUserLName);
                    userMap.put("Phone", saveUserPhone);


                    FirebaseUser current_user = FirebaseAuth.getInstance().getCurrentUser();
                    String uid = current_user.getUid();

                    FirebaseDatabase.getInstance ( ).getReference ( "Users" ).child ( currentUserNIC ).updateChildren ( userMap );

                    ProgressDialog.dismiss ();
                    Toast.makeText ( ofeditpro.this , "Your Profile Updated ", Toast.LENGTH_SHORT ).show ( );

                } catch (Exception e) {

                    Toast.makeText ( ofeditpro.this , e.getMessage ( ) , Toast.LENGTH_SHORT ).show ( );
                    ProgressDialog.dismiss ();
                }
                    }
                } );


        database = FirebaseDatabase.getInstance ( );
        userRef = database.getReference ( USER );

        FirebaseUser user = FirebaseAuth.getInstance ( ).getCurrentUser ( );
        if (user != null) {
            currentUserNIC = user.getUid ( );
        } else {
               startActivity ( new Intent ( getApplicationContext ( ) , lgnpg.class ) );
                finish ( );
            currentUserNIC = "UserID";
        }


        DatabaseReference databaseReference = FirebaseDatabase.getInstance ( ).getReference ( "Users" );
        Query checkUser = databaseReference.orderByChild (currentUserNIC );

        checkUser.addListenerForSingleValueEvent ( new ValueEventListener ( ) {
            @Override
            public void onDataChange ( @NonNull DataSnapshot datasnapshot ) {
                if (datasnapshot.child ( currentUserNIC ).exists ( )) {
                    String firstName = datasnapshot.child ( currentUserNIC ).child ( "Firs Name" ).getValue ( String.class );
                    String lastName = datasnapshot.child ( currentUserNIC ).child ( "Last Name" ).getValue ( String.class );
                    String email = datasnapshot.child ( currentUserNIC ).child ( "Email" ).getValue ( String.class );
                    String phone = datasnapshot.child ( currentUserNIC ).child ( "Phone" ).getValue ( String.class );
                    String nic = datasnapshot.child ( currentUserNIC ).child ( "NIC" ).getValue ( String.class );
                    String password = datasnapshot.child ( currentUserNIC ).child ( "Password" ).getValue ( String.class );
                    ProgressDialog.dismiss ();


                    try {
                        faname.setText ( firstName );
                        laname.setText ( lastName );
                        pemail.setText ( email );
                        phnumber.setText ( phone );
                        unic.setText ( nic );
                        pass.setText ( password );

                    } catch (Exception e) {
                        Toast.makeText ( ofeditpro.this , e.getMessage ( ) , Toast.LENGTH_SHORT ).show ( );
                    }

                }
            }

            @Override
            public void onCancelled ( @NonNull DatabaseError error ) {

            }
        } );

        savemenu.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick ( View v ) {
                sure.show ();
            }
        } );
    }


}