package com.example.sanjay.traveljinee.Booking.Paypal.PayPalPaymentDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by SANJAY on 1/23/2018.
 */

public class Amount_ {

    @SerializedName("total")
    @Expose
    private String total;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("details")
    @Expose
    private Details_ details;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Details_ getDetails() {
        return details;
    }

    public void setDetails(Details_ details) {
        this.details = details;
    }
}
