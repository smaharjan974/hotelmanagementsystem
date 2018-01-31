package com.example.sanjay.traveljinee.SearchHotel;

/**
 * Created by SANJAY on 1/7/2018.
 */

public class HotelModel {
    String hotelname;
    String address;
    String rating;

    public HotelModel(String hotelname, String address, String rating) {
        this.hotelname = hotelname;
        this.address = address;
        this.rating = rating;
    }

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }


}
