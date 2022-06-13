package com.example.computingproject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginTabFregment extends Fragment {
    EditText email, password,Email, mpassword;
    TextView forgotpss;
    Button login;
    float v;
    FirebaseAuth fAuth;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_fragment, container, false);

        email = root.findViewById(R.id.email);
        password = root.findViewById(R.id.password);
        login = root.findViewById(R.id.login);
        forgotpss = root.findViewById(R.id.forgot);


        email.setTranslationX(800);
        password.setTranslationX(800);
        login.setTranslationX(800);
        forgotpss.setTranslationX(800);

        email.setAlpha(v);
        password.setAlpha(v);
        login.setAlpha(v);
        forgotpss.setAlpha(v);

        email.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        password.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        login.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        forgotpss.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(400).start();


        return root;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Email =  email.findViewById(R.id.email);
//        mpassword =  password.findViewById(R.id.password);
//        login =  login.findViewById(R.id.login);
//        forgotpss =  forgotpss.findViewById(R.id.forgot);
        fAuth = FirebaseAuth.getInstance();


        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String email = Email.getText().toString().trim();
                String password = mpassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Email.setError("Email is Required");
                    return;
                }
                if (TextUtils.isEmpty(email)) {
                    mpassword.setError("Password is Required");
                    return;
                }
                if (password.length() < 6) {
                    mpassword.setError("Password Must be>=6 6 Characters");
                    return;
                }

                fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
//                            Toast.makeText(Login.this, "Loged in Successfully", Toast.LENGTH_SHORT).show();
//                            startActivities(new Intent[]{new Intent(getApplicationContext(), Dahmain.class)});
                            Toast.makeText(getActivity(), "Run wenawa", Toast.LENGTH_SHORT).show();
                        } else {
//                            Toast.makeText(Login.this, "Error..!!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(getActivity(), "hari", Toast.LENGTH_SHORT).show();
                        }
                    }

                });
            }
        });

        forgotpss.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final EditText resetMail = new EditText(v.getContext());
                final AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(v.getContext());
                passwordResetDialog.setTitle("Reset password?");
                passwordResetDialog.setMessage("Enter your email to recived reset link");
                passwordResetDialog.setView(resetMail);

                passwordResetDialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String mail = resetMail.getText().toString();


                        fAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(getActivity(), "Reset link sent to your email", Toast.LENGTH_SHORT).show();


                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getActivity(), "Error! reset link is not sent", Toast.LENGTH_SHORT).show();

                            }
                        });

                        //extract the email and reset link
                    }

                });

                passwordResetDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //close the dialog

                    }
                });


                passwordResetDialog.create().show();

            }
        });


    }
}
