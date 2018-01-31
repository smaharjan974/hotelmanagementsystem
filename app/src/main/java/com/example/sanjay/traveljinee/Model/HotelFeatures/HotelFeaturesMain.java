package com.example.sanjay.traveljinee.Model.HotelFeatures;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by SANJAY on 1/30/2018.
 */

public class HotelFeaturesMain {
    @SerializedName("Code")
    @Expose
    private Integer code;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("Data")
    @Expose
    private List<HotelFeatures> data = null;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<HotelFeatures> getData() {
        return data;
    }

    public void setData(List<HotelFeatures> data) {
        this.data = data;
    }
}
