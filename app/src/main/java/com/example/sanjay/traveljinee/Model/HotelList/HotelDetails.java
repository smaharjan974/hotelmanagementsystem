package com.example.sanjay.traveljinee.Model.HotelList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by SANJAY on 1/29/2018.
 */

public class HotelDetails {
    @SerializedName("HotelId")
    @Expose
    private Integer hotelId;
    @SerializedName("Hotelname")
    @Expose
    private String hotelname;
    @SerializedName("HotelAddress")
    @Expose
    private String hotelAddress;
    @SerializedName("Rating")
    @Expose
    private Integer rating;
    @SerializedName("ImagePath")
    @Expose
    private String imagePath;
    @SerializedName("UserView")
    @Expose
    private Integer userView;
    @SerializedName("Description")
    @Expose
    private String description;

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Integer getUserView() {
        return userView;
    }

    public void setUserView(Integer userView) {
        this.userView = userView;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
