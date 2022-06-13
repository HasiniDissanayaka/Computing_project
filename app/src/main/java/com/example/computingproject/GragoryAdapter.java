package com.example.computingproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.smarteist.autoimageslider.SliderViewAdapter;




    public class GragoryAdapter extends SliderViewAdapter<com.example.computingproject.GragoryAdapter.Holder> {
        int[] images;

        public GragoryAdapter(int[] images){

            this.images = images;

        }

        @Override
        public com.example.computingproject.GragoryAdapter.Holder onCreateViewHolder(ViewGroup parent) {

            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.travel_slider_item,parent,false);
            return new Holder(view);
        }

        @Override
        public void onBindViewHolder(com.example.computingproject.GragoryAdapter.Holder viewHolder, int position) {

            viewHolder.imageView.setImageResource(images[position]);

        }

        @Override
        public int getCount() {
            return images.length;
        }

        public class Holder extends  SliderViewAdapter.ViewHolder{

            ImageView imageView;

            public Holder(View itemView){
                super(itemView);
                imageView = itemView.findViewById(R.id.image_view);

            }
        }


    }
