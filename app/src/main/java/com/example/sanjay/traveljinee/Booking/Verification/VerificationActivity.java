package com.example.sanjay.traveljinee.Booking.Verification;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sanjay.traveljinee.Booking.Paypal.PayPalPaymentDetails.DetailsMain;
import com.example.sanjay.traveljinee.CustomModel.BookingPaymentWithHotelDetails;
import com.example.sanjay.traveljinee.Main.MainActivity;
import com.example.sanjay.traveljinee.Model.BookingPayment.BookingPaymentModel;
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
        TextView transactionid = findViewById(R.id.transactionid);
        TextView checkindate = findViewById(R.id.checkindate);
        TextView checkoutdate = findViewById(R.id.checkoutdate);
        TextView totalprice = findViewById(R.id.totalprice);
        TextView hotelname = findViewById(R.id.hotelname);



        String model = getIntent().getStringExtra("verificationmodel");
        BookingPaymentWithHotelDetails mainmodel = new Gson().fromJson(model,BookingPaymentWithHotelDetails.class);

        Log.d("asdf", "onCreate: mennn "+new Gson().toJson(mainmodel));

        payid.setText(mainmodel.getBookingPaymentModel().getPayId());
        transactionid.setText(mainmodel.getBookingPaymentModel().getTransactionId());
        checkindate.setText(mainmodel.getBookingWithHotelDetails().getHotelDetailsWithModelRoomDeal().getHotelDetailsWithModel().getModel().getCheckindate());
        checkoutdate.setText(mainmodel.getBookingWithHotelDetails().getHotelDetailsWithModelRoomDeal().getHotelDetailsWithModel().getModel().getCheckoutdate());
        totalprice.setText(mainmodel.getBookingPaymentModel().getAmount().toString());
        hotelname.setText(mainmodel.getBookingWithHotelDetails().getHotelDetailsWithModelRoomDeal().getHotelDetailsWithModel().getDetails().getHotelname().toString());



    }

    boolean doubleBackToExitPressedOnce = false;
    @Override
    public void onBackPressed() {

        if (doubleBackToExitPressedOnce) {
           startActivity(new Intent(VerificationActivity.this, MainActivity.class));
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}
