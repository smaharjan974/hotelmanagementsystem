package com.example.sanjay.traveljinee.Booking.Paypal.PayPalPaymentDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by SANJAY on 1/23/2018.
 */

public class Transaction {
    @SerializedName("amount")
    @Expose
    private Amount amount;
    @SerializedName("payee")
    @Expose
    private Payee payee;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("item_list")
    @Expose
    private ItemList itemList;
    @SerializedName("related_resources")
    @Expose
    private List<RelatedResource> relatedResources = null;

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public Payee getPayee() {
        return payee;
    }

    public void setPayee(Payee payee) {
        this.payee = payee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ItemList getItemList() {
        return itemList;
    }

    public void setItemList(ItemList itemList) {
        this.itemList = itemList;
    }

    public List<RelatedResource> getRelatedResources() {
        return relatedResources;
    }

    public void setRelatedResources(List<RelatedResource> relatedResources) {
        this.relatedResources = relatedResources;
    }
}
