package com.example.sanjay.traveljinee.Model.HotelRating.UserRating;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by SANJAY on 1/30/2018.
 */

public class UserRating {
    @SerializedName("HotelId")
    @Expose
    private Integer hotelId;
    @SerializedName("Rating")
    @Expose
    private Integer rating;
    @SerializedName("ReviewMessage")
    @Expose
    private String reviewMessage;
    @SerializedName("UserName")
    @Expose
    private String userName;
    @SerializedName("ReviewedDate")
    @Expose
    private String reviewedDate;

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getReviewMessage() {
        return reviewMessage;
    }

    public void setReviewMessage(String reviewMessage) {
        this.reviewMessage = reviewMessage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getReviewedDate() {
        return reviewedDate;
    }

    public void setReviewedDate(String reviewedDate) {
        this.reviewedDate = reviewedDate;
    }
}
