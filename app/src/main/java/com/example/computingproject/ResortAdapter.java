package com.example.computingproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.computingproject.UniqueUserHelperClass.Resorthelper;

import java.util.ArrayList;



public class ResortAdapter extends RecyclerView.Adapter<ResortAdapter.MyViewHolder>{



    Context context;
    ArrayList<Resorthelper> list;

    public ResortAdapter(Context context, ArrayList<Resorthelper> list) {
        this.context = context;
        this.list = list;
    }



    @NonNull
    @Override
    public ResortAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.resort_view, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Arrival;
        TextView Connum;
        TextView Days;
        TextView Departure;
        TextView Name;
        TextView NIC;
        TextView Resort;



        public MyViewHolder(@NonNull View resort_view) {
            super(resort_view);

            Arrival = itemView.findViewById(R.id.arrival);
            Connum = itemView.findViewById(R.id.con);
            Days = itemView.findViewById(R.id.days);
            Departure = itemView.findViewById(R.id.departure);
            Name = itemView.findViewById(R.id.name);
            NIC = itemView.findViewById(R.id.nic);
            Resort = itemView.findViewById(R.id.resort);

        }
    }
}
