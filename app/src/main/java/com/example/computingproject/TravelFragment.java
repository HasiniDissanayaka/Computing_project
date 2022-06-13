package com.example.computingproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;


public class TravelFragment extends Fragment {
    GridLayout gridLayout;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    private ImageView nuwaraeliya,anuradhapura,kandy,galle,yala,polonnaruwa;



    public TravelFragment() {



    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_travel, container, false);

        ImageView nuwaraeliya = (ImageView) view.findViewById(R.id.nuwaraeliya);
        ImageView location = (ImageView)view.findViewById(R.id.location);
        ImageView anuradhapura = (ImageView)view.findViewById(R.id.anuradhapura);
        ImageView kandy = (ImageView)view.findViewById(R.id.kandy);
        ImageView galle = (ImageView)view.findViewById(R.id.galle);
        ImageView yala = (ImageView)view.findViewById(R.id.yala);
        ImageView polonnaruwa = (ImageView)view.findViewById(R.id.polonnaruwa);

        nuwaraeliya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TravelFragment.this.getActivity(), Nuwaraeliya.class);
                startActivity(intent);
            }
        });
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TravelFragment.this.getActivity(),Location.class);
                startActivity(intent);
            }
        });
        anuradhapura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TravelFragment.this.getActivity(),Anuradhapura.class);
                startActivity(intent);
            }
        });
        kandy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TravelFragment.this.getActivity(),Kandy.class);
                startActivity(intent);
            }
        });
        galle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TravelFragment.this.getActivity(),Gall.class);
                startActivity(intent);
            }
        });
        yala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TravelFragment.this.getActivity(),Yala.class);
                startActivity(intent);
            }
        });
        polonnaruwa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TravelFragment.this.getActivity(),Polonnaruwa.class);
                startActivity(intent);
            }
        });












        // Inflate the layout for this fragment
        return view;




    }







}