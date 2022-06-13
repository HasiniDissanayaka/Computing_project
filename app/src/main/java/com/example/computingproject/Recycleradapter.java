package com.example.computingproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Recycleradapter extends RecyclerView.Adapter<Recycleradapter.RecyclerViewHolder> {
    private ArrayList<dataprovider> arrayList = new ArrayList<dataprovider>();

    public Recycleradapter(ArrayList<dataprovider>arrayList)
    {
        this.arrayList = arrayList;
    }



    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        dataprovider dataprovider = arrayList.get(position);
        holder.imageView.setImageResource(dataprovider.getImg_res());
        holder.F_name.setText(dataprovider.getF_name());
        holder.D_name.setText(dataprovider.getD_name());


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView F_name,D_name;

        public RecyclerViewHolder(View view)
        {
            super(view);
            imageView = (ImageView)view.findViewById(R.id.img);
            F_name = (TextView)view.findViewById(R.id.f_name);
            D_name = (TextView)view.findViewById(R.id.d_name);


        }
    }
}
