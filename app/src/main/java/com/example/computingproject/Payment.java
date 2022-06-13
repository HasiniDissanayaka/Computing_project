package com.example.computingproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.computingproject.UniqueUserHelperClass.Pay;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Payment extends AppCompatActivity {
    private EditText Amount,Cnum,Expire,CVC;
    private Button Pay;

    private FirebaseAuth fAuth;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    //initialize variable



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment3);

        Amount = findViewById(R.id.amount);
        Cnum = findViewById(R.id.card);
        Expire = findViewById(R.id.exp);
        CVC =findViewById(R.id.cvc);
        Pay = findViewById(R.id.pa);

        fAuth = FirebaseAuth.getInstance();

        Pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Payment");

                String amount = Amount.getText().toString().trim();
                String card = Cnum.getText().toString().trim();
                String expire = Expire.getText().toString().trim();
                String cvc = CVC.getText().toString().trim();

                com.example.computingproject.UniqueUserHelperClass.Pay payclass = new Pay(amount,card,expire,cvc);
                reference.child(card).setValue(payclass);









            }
        });


        //Assign variable


    }


}