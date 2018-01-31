package com.example.sanjay.traveljinee.Model.HotelRating;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by SANJAY on 1/30/2018.
 */

public class RatingModel {
    @SerializedName("Rating")
    @Expose
    private Float rating;
    @SerializedName("HotelId")
    @Expose
    private Integer hotelId;
    @SerializedName("HotelRatingHeadName")
    @Expose
    private String hotelRatingHeadName;
    @SerializedName("RatingHeadId")
    @Expose
    private Integer ratingHeadId;
    @SerializedName("TotalRating")
    @Expose
    private Double totalRating;
    @SerializedName("CountUsers")
    @Expose
    private Integer countUsers;

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelRatingHeadName() {
        return hotelRatingHeadName;
    }

    public void setHotelRatingHeadName(String hotelRatingHeadName) {
        this.hotelRatingHeadName = hotelRatingHeadName;
    }

    public Integer getRatingHeadId() {
        return ratingHeadId;
    }

    public void setRatingHeadId(Integer ratingHeadId) {
        this.ratingHeadId = ratingHeadId;
    }

    public Double getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(Double totalRating) {
        this.totalRating = totalRating;
    }

    public Integer getCountUsers() {
        return countUsers;
    }

    public void setCountUsers(Integer countUsers) {
        this.countUsers = countUsers;
    }
}
