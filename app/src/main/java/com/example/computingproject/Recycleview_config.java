package com.example.computingproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Recycleview_config {

    private sheduleAdapter mSheduleAdapter;
    public void setConfig(RecyclerView recyclerView,Context context,List<KShedule> shedules,List<String> keys){
        mContext = context;
        mSheduleAdapter = new sheduleAdapter(shedules, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mSheduleAdapter);
    }
    private Context mContext;

    class shedulelist extends RecyclerView.ViewHolder {
        private TextView start;
        private TextView End;
        private TextView Arrival;
        private TextView Leave;

        private  String key;



        public shedulelist(@NonNull ViewGroup itemView) {

            super(LayoutInflater.from(mContext).
                    inflate(R.layout.shedule_list, itemView, false));
             start = (TextView) itemView.findViewById(R.id.titleshedule);
             End =  (TextView) itemView.findViewById(R.id.end);
             Arrival = (TextView) itemView.findViewById(R.id.arrival);
             Leave = (TextView) itemView.findViewById(R.id.leave);


        }
        public void bind(KShedule sheduele,String key){
            start.setText(sheduele.getStartstation());
            End.setText(sheduele.getEndstation());
            Arrival.setText(sheduele.getArrival());
            Leave.setText(sheduele.getLeave());
            this.key = key;

        }
    }

    class sheduleAdapter extends RecyclerView.Adapter<shedulelist>{
        private List<KShedule> mShedulelist;
        private List<String> mKeys;

        public sheduleAdapter(List<KShedule> mShedulelist, List<String> mKeys) {
            this.mShedulelist = mShedulelist;
            this.mKeys = mKeys;
        }


        @NonNull
        @Override
        public shedulelist onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            return new shedulelist(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull shedulelist holder, int position) {
            holder.bind(mShedulelist.get(position),mKeys.get(position));

        }

        @Override
        public int getItemCount() {
            return mShedulelist.size();
        }
    }

}
