package com.example.sanjay.traveljinee.Model.Booking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by SANJAY on 2/4/2018.
 */

public class BookingMain {

    @SerializedName("Code")
    @Expose
    private Integer code;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("Data")
    @Expose
    private BookingModel data;

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

    public BookingModel getData() {
        return data;
    }

    public void setData(BookingModel data) {
        this.data = data;
    }
}
