package com.example.computingproject;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class lgnpg extends AppCompatActivity {

    Button loging;
    EditText uname, pword,resetMail;
    ProgressBar pbar;
    TextView forpword;
    FirebaseAuth fAuth;
    ProgressDialog ProgressDialog;
    Dialog forgetp;
    Button logoutbt,no,yes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lgnpg);

        Button signbt = findViewById ( R.id.signbt );
        signbt.setOnClickListener ( v -> {
            Intent intent = new Intent ( this , signup.class );
            startActivity ( intent );

        } );

        uname = findViewById ( R.id.uname );
        pword = findViewById ( R.id.pword );
        forpword = findViewById ( R.id.forpword );
        pbar = findViewById ( R.id.pbar );
        loging = findViewById ( R.id.logbt );
        fAuth = FirebaseAuth.getInstance ( );
        forpword = findViewById ( R.id.forpword );



        forgetp = new Dialog( lgnpg.this );
        forgetp.setContentView ( R.layout.forgetpg );
        Objects.requireNonNull ( forgetp.getWindow ( ) ).setBackgroundDrawable ( getDrawable ( R.drawable.bg_logout ) );
        forgetp.getWindow ( ).setLayout ( ViewGroup.LayoutParams.MATCH_PARENT , ViewGroup.LayoutParams.WRAP_CONTENT );


        yes = forgetp.findViewById ( R.id.yes );
        no = forgetp.findViewById ( R.id.no );
        resetMail = forgetp.findViewById ( R.id.resetMail );

        no.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick ( View v ) {

                Toast.makeText ( com.example.computingproject.lgnpg.this , "Error! Reset Link is Not Sent" , Toast.LENGTH_SHORT ).show ( );
                forgetp.dismiss ( );
            }
        } );


        yes.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick ( View v ) {
                String mail = resetMail.getText ( ).toString ( );
                fAuth.sendPasswordResetEmail ( mail ).addOnSuccessListener ( new OnSuccessListener<Void>( ) {
                    @Override
                    public void onSuccess ( Void aVoid ) {
                        Toast.makeText ( lgnpg.this , "Reset Link Sent To Your Email." , Toast.LENGTH_SHORT ).show ( );

                    }
                } ).addOnFailureListener ( new OnFailureListener( ) {
                    @Override
                    public void onFailure ( @NonNull Exception e ) {
                        Toast.makeText ( lgnpg.this , "Error! Reset Link is Not Sent." + e.getMessage ( ) , Toast.LENGTH_SHORT ).show ( );
                    }
                } );

                forgetp.dismiss ( );
                startActivity ( new Intent ( getApplicationContext ( ) , lgnpg.class ) );
            }
        } );




        if (fAuth.getCurrentUser ( ) != null) {
            startActivity ( new Intent ( getApplicationContext ( ) , Dahmain.class ) );
            finish ( );
        }


        loging.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick ( View v ) {

                String username = uname.getText ( ).toString ( ).trim ( );
                String password = pword.getText ( ).toString ( ).trim ( );
                if (TextUtils.isEmpty ( username )) {
                    uname.setError ( "Email Is Required." );
                    return;
                }
                if (TextUtils.isEmpty ( password )) {
                    pword.setError ( "User Name Is Required." );
                    return;
                }


                ProgressDialog = new ProgressDialog(lgnpg.this);
                ProgressDialog.show();
                ProgressDialog.setContentView ( R.layout.loadpg );
                ProgressDialog.getWindow ().setBackgroundDrawableResource (
                        android.R.color.transparent
                );

                fAuth.signInWithEmailAndPassword ( username , password ).addOnCompleteListener ( new OnCompleteListener<AuthResult>( ) {
                    @Override
                    public void onComplete ( @NonNull Task<AuthResult> task ) {

                        if (task.isSuccessful ( )) {
                            Toast.makeText ( lgnpg.this , "Logged in Successfully " , Toast.LENGTH_SHORT ).show ( );
                            startActivity ( new Intent ( getApplicationContext ( ) , Dahmain.class ) );
                        } else {
                            Toast.makeText ( lgnpg.this , "Error ! " + task.getException ( ).getMessage ( ) , Toast.LENGTH_SHORT ).show ( );
                            ProgressDialog.dismiss ();
                        }
                    }
                } );


            }
        } );



    }


    public void onClick ( View view ) {
        forgetp.show ();
    }
}