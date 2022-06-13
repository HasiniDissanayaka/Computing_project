package com.example.computingproject;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class Kandy extends AppCompatActivity {
    SliderView sliderView;
    Button location;




    int[] images = {R.drawable.bt,
            R.drawable.dk,
            R.drawable.hm,
            R.drawable.ic,
            R.drawable.ir,
            R.drawable.kd,
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kandy);
        sliderView = findViewById(R.id.image_slider);






        TravelSliderAdapter sliderAdapter = new TravelSliderAdapter(images);

        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();

    }
}