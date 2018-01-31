package com.example.sanjay.traveljinee.Retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by SANJAY on 1/22/2018.
 */

public class PayPalPostParams {

    public PayPalPostParams(String grant_type) {
        this.grant_type = grant_type;
    }

    @SerializedName("grant_type")
    @Expose
    String grant_type;


}
