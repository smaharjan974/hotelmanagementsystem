package com.example.sanjay.traveljinee.Booking.Paypal.PayPalPayment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by SANJAY on 1/23/2018.
 */

public class Client {
    @SerializedName("environment")
    @Expose
    private String environment;
    @SerializedName("paypal_sdk_version")
    @Expose
    private String paypalSdkVersion;
    @SerializedName("platform")
    @Expose
    private String platform;
    @SerializedName("product_name")
    @Expose
    private String productName;

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getPaypalSdkVersion() {
        return paypalSdkVersion;
    }

    public void setPaypalSdkVersion(String paypalSdkVersion) {
        this.paypalSdkVersion = paypalSdkVersion;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
