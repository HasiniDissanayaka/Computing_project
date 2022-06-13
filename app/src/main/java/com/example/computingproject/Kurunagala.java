package com.example.computingproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Kurunagala extends AppCompatActivity {

    private RecyclerView mRecycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kurunagala);
        mRecycleView = (RecyclerView) findViewById(R.id.recycle_view);
        new FirebaseDatabaseHelper().shedule(new FirebaseDatabaseHelper.DataStatus() {


            @Override
            public void DataLoaded(List<KShedule> books, List<String> keys) {

            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });
    }
}


