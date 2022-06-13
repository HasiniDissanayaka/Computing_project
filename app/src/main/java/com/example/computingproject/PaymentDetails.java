package com.example.computingproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class PaymentDetails extends AppCompatActivity {
    TextView txtId,txtAmount,txtStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);

        txtId = (TextView) findViewById(R.id.txtId);
        txtAmount = (TextView) findViewById(R.id.edtAmount);
        txtStatus = (TextView) findViewById(R.id.txtStatus);

        Intent intent = getIntent();
        try {
            JSONObject jsonObject = new JSONObject(intent.getStringExtra("Payment Details"));
            showDetails(jsonObject.getJSONObject("response"),intent.getStringExtra("Payment Amount"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("SetTextI18n")
    private void showDetails(JSONObject response, String payment_amount) {
        try {
            txtId.setText(response.getString("id"));
            txtStatus.setText(response.getString("STATE"));
            txtAmount.setText("LKR"+payment_amount);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}