package com.example.sanjay.traveljinee.Model.Offers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by SANJAY on 1/30/2018.
 */

public class OffersModel {
    @SerializedName("ImageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("OfferId")
    @Expose
    private String offerId;
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("theme")
    @Expose
    private String theme;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
