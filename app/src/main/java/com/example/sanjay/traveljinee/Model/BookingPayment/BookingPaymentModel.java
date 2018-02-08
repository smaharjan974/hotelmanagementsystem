package com.example.sanjay.traveljinee.Model.BookingPayment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by SANJAY on 2/5/2018.
 */

public class BookingPaymentModel {

    @SerializedName("BookingPaymentId")
    @Expose
    private Integer bookingPaymentId;
    @SerializedName("BookingId")
    @Expose
    private Integer bookingId;
    @SerializedName("Amount")
    @Expose
    private Integer amount;
    @SerializedName("IsAdvance")
    @Expose
    private Boolean isAdvance;
    @SerializedName("PaymentGatewayId")
    @Expose
    private Integer paymentGatewayId;
    @SerializedName("PayId")
    @Expose
    private String payId;
    @SerializedName("TransactionId")
    @Expose
    private String transactionId;
    @SerializedName("Status")
    @Expose
    private Integer status;
    @SerializedName("IsActive")
    @Expose
    private Boolean isActive;
    @SerializedName("Remarks")
    @Expose
    private String remarks;

    public Integer getBookingPaymentId() {
        return bookingPaymentId;
    }

    public void setBookingPaymentId(Integer bookingPaymentId) {
        this.bookingPaymentId = bookingPaymentId;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Boolean getIsAdvance() {
        return isAdvance;
    }

    public void setIsAdvance(Boolean isAdvance) {
        this.isAdvance = isAdvance;
    }

    public Integer getPaymentGatewayId() {
        return paymentGatewayId;
    }

    public void setPaymentGatewayId(Integer paymentGatewayId) {
        this.paymentGatewayId = paymentGatewayId;
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
