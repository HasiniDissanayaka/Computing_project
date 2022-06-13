package com.example.computingproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    Context context;
    ArrayList<User> list;

    public UserAdapter(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }



        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View v = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false);

            return new MyViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            User users = list.get(position);


            holder.Train.setText(users.getTrain());
            holder.Price.setText(users.getPrice());
            holder.Date.setText(users.getDate());
            holder.Month.setText(users.getMonth());
            holder.Time.setText(users.getTime());
            holder.Amount.setText(users.getAmount());
            holder.Name.setText(users.getName());
            holder.Contact.setText(users.getContact());
            holder.Email.setText(users.getEmail());

        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public static class MyViewHolder extends RecyclerView.ViewHolder {
            TextView Train;
            TextView Price;
            TextView Date;
            TextView Month;
            TextView Time;
            TextView Amount;
            TextView Name;
            TextView Contact;
            TextView Email;


            public MyViewHolder(@NonNull View itemView) {
                super(itemView);

                Train = itemView.findViewById(R.id.train);
                Price = itemView.findViewById(R.id.price);
                Date = itemView.findViewById(R.id.date);
                Month = itemView.findViewById(R.id.month);
                Time = itemView.findViewById(R.id.time);
                Amount = itemView.findViewById(R.id.amount);
                Name = itemView.findViewById(R.id.name);
                Contact = itemView.findViewById(R.id.contact);
                Email = itemView.findViewById(R.id.email);
            }
        }
    }

