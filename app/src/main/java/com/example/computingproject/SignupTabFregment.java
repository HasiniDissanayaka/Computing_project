package com.example.computingproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignupTabFregment extends Fragment {
    public static final String TAG = "TAG";
    private EditText email, name, password, contactnumber;
    private Button signup;
    private float v;
    private String userID;
    private FirebaseFirestore fStore;

    private FirebaseAuth fAuth;
    private Object intent;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            saveInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_tab_frgment, container, false);


        email = root.findViewById(R.id.email);
        password = root.findViewById(R.id.password);
        signup = root.findViewById(R.id.signup);
        name = root.findViewById(R.id.name);
        contactnumber = root.findViewById(R.id.contact);
        fStore = FirebaseFirestore.getInstance();

        email.setTranslationX(800);
        password.setTranslationX(800);
        signup.setTranslationX(800);
        name.setTranslationX(800);
        contactnumber.setTranslationX(800);


        email.setAlpha(v);
        password.setAlpha(v);
        signup.setAlpha(v);
        contactnumber.setAlpha(v);
        name.setAlpha(v);


        email.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        password.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        signup.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        contactnumber.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        name.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(400).start();

        return root;

    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//
//
//
//
//        fAuth = FirebaseAuth.getInstance();
//        if (fAuth.getCurrentUser() != null) {
//            Intent intent = new Intent(getActivity(), MainActivity.class);
//            ((MainActivity) getActivity()).startActivity(intent);
//            try {
//                finalize();
//            } catch (Throwable throwable) {
//                throwable.printStackTrace();
//            }
//
//        }
//
//
//
//        signup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String Email = email.getText().toString().trim();
//                String Password = password.getText().toString().trim();
//                String Name = name.getText().toString();
//                String Contact = contactnumber.getText().toString();
//
//                if (TextUtils.isEmpty(Email)) {
//                    email.setError("Email is Required");
//                    return;
//                }
//
//                if (TextUtils.isEmpty(Name)) {
//
//                    name.setError("name is Required");
//                    return;
//                }
//                if (TextUtils.isEmpty(Contact)) {
//                    contactnumber.setError("Contactnumber is Required");
//                    return;
//                }
//                if (TextUtils.isEmpty(Password)) {
//                    password.setError("Password is Required");
//                    return;
//                }
//                if (Password.length() < 6) {
//                    password.setError("Password Must be>=6 6 Characters");
//                    return;
//                }
//
//                fAuth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//
//                            //send verification link
//
//                            FirebaseUser fuser = fAuth.getCurrentUser();
//                            fuser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
//
//                                @Override
//                                public void onSuccess(Void unused) {
//                                    Toast.makeText(getActivity(), "Verification email", Toast.LENGTH_SHORT).show();
//                                }
//                            }).addOnFailureListener(new OnFailureListener() {
//                                @Override
//                                public void onFailure(@NonNull Exception e) {
//                                    Log.d(TAG, "onFailure:E mail not sent" + e.getMessage());
//
//                                }
//                            });
//                            Toast.makeText(getActivity(), "User Created!", Toast.LENGTH_SHORT).show();
//                            userID = fAuth.getCurrentUser().getUid();
//                            DocumentReference documentReference = fStore.collection("users").document(userID);
//                            Intent intent = new Intent(getActivity(), SignupTabFregment.class);
//                            startActivity(intent);
//                            Map<String, Object> user = new HashMap<>();
//                            user.put("fname", name);
//                            user.put("email", email);
//                            user.put("cnumber", contactnumber);
//                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
//                                @Override
//                                public void onSuccess(Void aVoid) {
//                                    Log.d(TAG, "onSuccess:user profile is created" + userID);
//                                }
//                            });
//                            startActivity(new Intent(getActivity(), LoginTabFregment.class));
//                        } else {
//
//                            Toast.makeText(getActivity(), "Error!", Toast.LENGTH_SHORT).show();
//
//                        }
//
//                    }
//                });
//            }
//        });
//        signup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getActivity(), LoginTabFregment.class));
//
//            }
//        });
//
//
//    }
}




