package com.example.computingproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TimeAdapter extends RecyclerView.Adapter<TimeAdapter.MyViewHolder> implements Filterable {


    Context context;
    ArrayList<Time> list;
    ArrayList<Time> listfull;


    public TimeAdapter(Context context, ArrayList<Time> list) {
        this.context = context;
        this.listfull = list;
        this.list = new ArrayList<>(listfull);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.time_view, parent, false);

        return new MyViewHolder(v);
    }

    @Override


    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Time time = list.get(position);
        holder.Time.setText(time.getTime());
        holder.Start.setText(time.getStart());
        holder.End.setText(time.getEnd());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    @Override
    public Filter getFilter() {

        return timefilter;
    }
     private final Filter timefilter = new Filter() {
         @Override
         protected FilterResults performFiltering(CharSequence constraint) {
             ArrayList<Time> filterdtimelist = new ArrayList<>();
             if (constraint == null || constraint.length() == 0) {
                 filterdtimelist.addAll(listfull);
             } else {
                 String filterPattern = constraint.toString().toLowerCase().trim();
                 for (Time time : listfull) {
                     if (time.time.toLowerCase().contains(filterPattern))
                         listfull.add(time);
                 }
             }
             FilterResults results = new FilterResults();
             results.values = listfull;
             results.count = filterdtimelist.size();
             return results;
         }

         @Override
         protected void publishResults(CharSequence constraint, FilterResults results) {


             list.clear();
             list.addAll((ArrayList)results.values);
             notifyDataSetChanged();


         }
     };

    public static  class MyViewHolder extends  RecyclerView.ViewHolder{

        TextView Time;
        TextView Start;
        TextView End;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            Time = itemView.findViewById(R.id.time);
            Start = itemView.findViewById(R.id.start);
            End = itemView.findViewById(R.id.end);
        }
    }
}
