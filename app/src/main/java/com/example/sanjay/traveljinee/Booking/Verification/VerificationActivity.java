package com.example.sanjay.traveljinee.Booking.Verification;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.sanjay.traveljinee.Booking.Paypal.PayPalPaymentDetails.DetailsMain;
import com.example.sanjay.traveljinee.R;
import com.example.sanjay.traveljinee.SearchHotel.SearchHotelActivity;
import com.google.gson.Gson;

public class VerificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        getSupportActionBar().setTitle("VERIFIED");

        TextView payid = findViewById(R.id.payid);

        String model = getIntent().getStringExtra("verificationmodel");
        DetailsMain mainmodel = new Gson().fromJson(model,DetailsMain.class);

        Log.d("asdf", "onCreate: mennn "+new Gson().toJson(mainmodel));

        payid.setText(mainmodel.getId());

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(VerificationActivity.this, SearchHotelActivity.class));
        super.onBackPressed();
    }
}
