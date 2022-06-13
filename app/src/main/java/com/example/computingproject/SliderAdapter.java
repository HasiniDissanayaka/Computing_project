package com.example.computingproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class SliderAdapter extends SliderViewAdapter <SliderAdapter.Holder>{
    int[] image;

    public SliderAdapter(int[] image){
        this.image = image;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.slider_item,parent,false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder viewHolder, int position) {
        viewHolder.imageView.setImageResource(image[position]);

    }

    @Override
    public int getCount() {
        return image.length;
    }

    public class Holder extends SliderViewAdapter.ViewHolder{

        ImageView imageView;
        public Holder(View itemView)
        {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);


        }

    }

}
