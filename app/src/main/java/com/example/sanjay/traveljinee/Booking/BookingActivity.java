package com.example.sanjay.traveljinee.Booking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.sanjay.traveljinee.Model.CountryListModel;
import com.example.sanjay.traveljinee.R;
import com.example.sanjay.traveljinee.Retrofit.APIInterface;
import com.example.sanjay.traveljinee.Retrofit.APiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookingActivity extends AppCompatActivity {

    AutoCompleteTextView country;
    List<String> countrylist;
    ArrayAdapter<String> adapter;

    LinearLayout booking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        country = findViewById(R.id.country);
        booking = findViewById(R.id.booking);

        APIInterface api = APiClient.getApiService();
        Call<List<CountryListModel>> call = api.getcountrylist();

        call.enqueue(new Callback<List<CountryListModel>>() {
            @Override
            public void onResponse(Call<List<CountryListModel>> call, Response<List<CountryListModel>> response) {
                if(response.isSuccessful()){
                    countrylist = new ArrayList<>();
                    for(int i=0;i<response.body().size();i++){
                        countrylist.add(response.body().get(i).getName());
                    }
                    adapter = new ArrayAdapter<String>(BookingActivity.this,android.R.layout.simple_list_item_1,countrylist);
                    country.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<CountryListModel>> call, Throwable t) {

            }
        });

        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BookingActivity.this,BookingPaymentActivity.class));
            }
        });




    }
}
