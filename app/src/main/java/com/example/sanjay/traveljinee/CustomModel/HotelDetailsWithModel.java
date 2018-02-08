package com.example.sanjay.traveljinee.CustomModel;


import com.example.sanjay.traveljinee.Model.HotelDetails.HotelDetails;
import com.example.sanjay.traveljinee.Model.HotelList.HotelDetail;

/**
 * Created by SANJAY on 2/2/2018.
 */

public class HotelDetailsWithModel {
    MainModel model;
    HotelDetail detail;

    public HotelDetailsWithModel(MainModel model, HotelDetail detail) {
        this.model = model;
        this.detail = detail;
    }

    public MainModel getModel() {
        return model;
    }

    public void setModel(MainModel model) {
        this.model = model;
    }

    public HotelDetail getDetails() {
        return detail;
    }

    public void setDetails(HotelDetail detail) {
        this.detail = detail;
    }
}
