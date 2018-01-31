package com.example.sanjay.traveljinee.Retrofit;

import com.example.sanjay.traveljinee.StringClass;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by SANJAY on 1/22/2018.
 */

public class APIPayPal {

    private static final String ROOT_URL= new StringClass().getPay_pay_Base_URL();
    private static Retrofit getRetrofitInstance() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        return new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

    }
    public static APIInterface getApiService()
    {
        return getRetrofitInstance().create(APIInterface.class);
    }
}
