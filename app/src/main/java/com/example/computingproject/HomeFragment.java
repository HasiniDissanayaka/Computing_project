package com.example.computingproject;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class HomeFragment extends Fragment {
    ImageButton contactus, editpro, norification,delteticket,logout;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;


    public HomeFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home2, container, false);
        ImageView contactus = (ImageView) view.findViewById(R.id.contactimg);
        ImageView editpro = (ImageView) view.findViewById(R.id.proimg);

        ImageView delteticket = (ImageView) view.findViewById(R.id.deleteselection);
        ImageView update = (ImageView)view.findViewById(R.id.updatebtn);

        ImageView logout = (ImageView) view.findViewById(R.id.logoutbtn);

        firebaseAuth=FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference().child("data");
        if(firebaseAuth.getCurrentUser()==null)
        {
            Intent intent = new Intent(HomeFragment.this.getActivity(), lgnpg.class);
            startActivity(intent);
        }
        FirebaseUser user=firebaseAuth.getCurrentUser();

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openContact();
            }

            private void openContact() {
                Intent intent = new Intent(HomeFragment.this.getActivity(), lgnpg.class);
                firebaseAuth.signOut();
                startActivity(intent);
            }
        });







        delteticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }

            private void showDialog() {
                final Dialog dialog = new Dialog(HomeFragment.this.getActivity());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.bottomdelete);

                LinearLayout cardpay = dialog.findViewById(R.id.card);
                LinearLayout paypalpay = dialog.findViewById(R.id.paypal);

                cardpay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(HomeFragment.this.getActivity(), "Ticket Booking Delete", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getContext(), Deletefirestclz.class));
                    }
                });
                paypalpay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(HomeFragment.this.getActivity(), "Resort Booking Delete", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getContext(), Deleteresortbook.class));
                    }
                });
                dialog.show();
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                dialog.getWindow().setGravity(Gravity.BOTTOM);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }

            private void showDialog() {
                final Dialog dialog = new Dialog(HomeFragment.this.getActivity());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.bottomupdate);

                LinearLayout cardpay = dialog.findViewById(R.id.card);
                LinearLayout paypalpay = dialog.findViewById(R.id.paypal);

                cardpay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(HomeFragment.this.getActivity(), "Resort Booking Update", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getContext(), UpdateRasort.class));
                    }
                });
                paypalpay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(HomeFragment.this.getActivity(), "Hithachi and Compartment Update", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getContext(), UpdateHithachi.class));
                    }
                });
                dialog.show();
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                dialog.getWindow().setGravity(Gravity.BOTTOM);
            }
        });

        contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openContact();
            }

            private void openContact() {
                Intent intent = new Intent(HomeFragment.this.getActivity(), Contact.class);
                startActivity(intent);
            }
        });

        editpro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }

            private void showDialog() {
                final Dialog dialog = new Dialog(HomeFragment.this.getActivity());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.bottombooking);

                LinearLayout cardpay = dialog.findViewById(R.id.card);
                LinearLayout paypalpay = dialog.findViewById(R.id.paypal);

                cardpay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(HomeFragment.this.getActivity(), " Your Resort Booking Details", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getContext(), ResortBookingRecycle.class));
                    }
                });
                paypalpay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(HomeFragment.this.getActivity(), "Your Train Ticket Booking Details", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getContext(), Firestclzrecycle.class));
                    }
                });
                dialog.show();
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                dialog.getWindow().setGravity(Gravity.BOTTOM);
            }
        });





        return view;
    }
}












        // Inflate the layout for this fragment











