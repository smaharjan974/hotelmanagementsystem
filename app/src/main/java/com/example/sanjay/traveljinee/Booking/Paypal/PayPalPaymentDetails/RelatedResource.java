package com.example.sanjay.traveljinee.Booking.Paypal.PayPalPaymentDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by SANJAY on 1/23/2018.
 */

public class RelatedResource {
    @SerializedName("sale")
    @Expose
    private Sale sale;

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }
}
