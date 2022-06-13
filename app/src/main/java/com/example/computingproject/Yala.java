package com.example.computingproject;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class Yala extends AppCompatActivity {
    SliderView sliderView;
    Button location;




    int[] images = {R.drawable.urt,
            R.drawable.fhg,
            R.drawable.ire,
            R.drawable.jdf,
            R.drawable.odf,
            R.drawable.pui,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yala);
        sliderView = findViewById(R.id.image_slider);






        TravelSliderAdapter sliderAdapter = new TravelSliderAdapter(images);

        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();
    }
    }
