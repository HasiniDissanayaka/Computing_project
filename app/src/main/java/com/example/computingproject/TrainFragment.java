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

import com.smarteist.autoimageslider.SliderView;


public class TrainFragment extends Fragment {

    private ImageButton book;
    SliderView sliderView;




    int[] images = {R.drawable.yy,
            R.drawable.bn,
            R.drawable.fir,
            R.drawable.op,
            R.drawable.nuwaraeliya,
            R.drawable.nuw,
            R.drawable.o};



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_train, container, false);
        ImageView imageView1 = (ImageView) view.findViewById(R.id.bookbtn);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.timebtn) ;
        ImageView imageButton2 =(ImageView) view.findViewById(R.id.profile);
        ImageView Imageview =(ImageView) view.findViewById(R.id.resort);
        ImageView imageButton4 = (ImageView) view.findViewById(R.id.compartment);
        ImageView hithachi = (ImageView) view.findViewById(R.id.hithachi);
        ImageView traking = (ImageView)view.findViewById(R.id.tracking);
        ImageView trainshedule = (ImageView)view.findViewById(R.id.shedule);

        SliderView sliderView = (SliderView)view.findViewById (R.id.image_slider);






        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDialog();
            }



        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDailyshedile();

            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProfile();
            }

            private void openProfile() {
                Intent intent = new Intent(TrainFragment.this.getActivity(),ofeditpro.class);
                startActivity(intent);
            }
        });
        Imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOtherservices();
            }
            private void openOtherservices() {
                Intent intent = new Intent(TrainFragment.this.getActivity(),Resorts.class);
                startActivity(intent);

            }


        });
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUpdatefirstclz();
            }

            private void openUpdatefirstclz() {
                Intent intent = new Intent(TrainFragment.this.getActivity(),Hithachi.class);
                startActivity(intent);
            }
        });
        hithachi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHithachi();
            }

            private void openHithachi() {
                Intent intent = new Intent(TrainFragment.this.getActivity(),Hithachi.class);
                startActivity(intent);

            }
        });
        traking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTrakingtrain();
            }

            private void openTrakingtrain() {
                Intent intent = new Intent(TrainFragment.this.getActivity(),Tr.class);
                startActivity(intent);

            }
        });
        trainshedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTrainshedule();
            }

            private void openTrainshedule() {
                Intent intent = new Intent(TrainFragment.this.getActivity(),TrainSchedule.class);
                startActivity(intent);

            }
        });




        // nflate the layout for this fragment
        return view;


    }

    private void showDialog() {


        final Dialog dialog = new Dialog(TrainFragment.this.getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottomsheetclz);

        LinearLayout cardpay = dialog.findViewById(R.id.card);
        LinearLayout paypalpay = dialog.findViewById(R.id.paypal);
        LinearLayout thiredclz = dialog.findViewById(R.id.thirdclz);

        cardpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TrainFragment.this.getActivity(), "First Class is Clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getContext(), Ticketbooking.class));
            }
        });
        paypalpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TrainFragment.this.getActivity(), "Second Class  is Clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getContext(), secondclz.class));
            }
        });
        thiredclz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TrainFragment.this.getActivity(), "Thired Class  is Clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getContext(), thiredclz.class));
            }
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }

    private void openDailyshedile() {
        Intent intent = new Intent(TrainFragment.this.getActivity(), Timetablesearch.class);
        startActivity(intent);

    }

    public void openTicketbooking(){
        Intent intent = new Intent(TrainFragment.this.getActivity(), Ticketbooking.class);
        startActivity(intent);

    }

    }




