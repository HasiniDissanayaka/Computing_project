package com.example.computingproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.computingproject.databinding.ActivityDeletefirestclzBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Deletefirestclz extends AppCompatActivity {

    ActivityDeletefirestclzBinding binding;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDeletefirestclzBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String contact = binding.id.getText().toString();
                if(!contact.isEmpty()){
                    deleteData(contact);
                }else{
                    Toast.makeText(Deletefirestclz.this, "Enter Contact Number", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void deleteData(String contact) {

        reference = FirebaseDatabase.getInstance().getReference("firestclass");
        reference.child(contact).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Deletefirestclz.this, "Successfuly Deleted", Toast.LENGTH_SHORT).show();
                    binding.id.setText("");
                }else{
                    Toast.makeText(Deletefirestclz.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}