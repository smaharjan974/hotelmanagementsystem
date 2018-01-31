package com.example.sanjay.traveljinee.Booking.Paypal.PayPalPaymentDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by SANJAY on 1/23/2018.
 */

public class ItemList {
    @SerializedName("items")
    @Expose
    private List<Object> items = null;
    @SerializedName("shipping_address")
    @Expose
    private ShippingAddress_ shippingAddress;

    public List<Object> getItems() {
        return items;
    }

    public void setItems(List<Object> items) {
        this.items = items;
    }

    public ShippingAddress_ getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress_ shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}
