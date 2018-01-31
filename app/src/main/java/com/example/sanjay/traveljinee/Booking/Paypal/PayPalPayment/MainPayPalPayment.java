package com.example.sanjay.traveljinee.Booking.Paypal.PayPalPayment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by SANJAY on 1/23/2018.
 */

public class MainPayPalPayment {
    @SerializedName("client")
    @Expose
    private Client client;
    @SerializedName("response")
    @Expose
    private Response response;
    @SerializedName("response_type")
    @Expose
    private String responseType;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }
}
