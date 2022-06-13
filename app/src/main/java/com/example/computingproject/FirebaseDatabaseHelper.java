package com.example.computingproject;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelper {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReference;
    private List<KShedule> shedules = new ArrayList<>();

    public  interface DataStatus{
        void DataLoaded(List<KShedule>books,List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public FirebaseDatabaseHelper() {
        this.mDatabase = mDatabase;
        mDatabase = FirebaseDatabase.getInstance();
        mReference = mDatabase.getReference("Kurunagala");




    }
    public void shedule(final DataStatus dataStatus){
        mReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                shedules.clear();
                List<String> keys = new ArrayList<>();

                for(DataSnapshot keyNode : datasnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    KShedule shedule = keyNode.getValue(KShedule.class);
                    shedules.add(shedule);

                }
                dataStatus.DataLoaded(shedules,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseerror) {

            }
        });
    }
}
