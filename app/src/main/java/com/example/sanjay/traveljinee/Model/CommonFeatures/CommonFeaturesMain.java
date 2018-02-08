package com.example.sanjay.traveljinee.Model.CommonFeatures;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by SANJAY on 2/6/2018.
 */

public class CommonFeaturesMain {
    @SerializedName("Code")
    @Expose
    private Integer code;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("Data")
    @Expose
    private List<CommonFeaturesModel> data = null;

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

    public List<CommonFeaturesModel> getData() {
        return data;
    }

    public void setData(List<CommonFeaturesModel> data) {
        this.data = data;
    }
}
