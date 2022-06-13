package com.example.computingproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class Nuwaraeliya extends AppCompatActivity {
    SliderView sliderView;
    Button location;




    int[] images = {R.drawable.yy,
            R.drawable.nuwaraeliya,
            R.drawable.rt,
            R.drawable.p,
            R.drawable.nuwaraeliya,
            R.drawable.nuw,
            R.drawable.o};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuwaraeliya);

        sliderView = findViewById(R.id.image_slider);
        location = findViewById(R.id.nlocation);

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Location.class));
            }
        });





        TravelSliderAdapter sliderAdapter = new TravelSliderAdapter(images);

        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();



        // Inflate the layout for this fragment

    }
}