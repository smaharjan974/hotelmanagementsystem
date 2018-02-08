package com.example.sanjay.traveljinee.Model.BookingPayment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by SANJAY on 2/5/2018.
 */

public class BookingPaymentMain {
    @SerializedName("Code")
    @Expose
    private Integer code;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("Data")
    @Expose
    private BookingPaymentModel data;

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

    public BookingPaymentModel getData() {
        return data;
    }

    public void setData(BookingPaymentModel data) {
        this.data = data;
    }
}
