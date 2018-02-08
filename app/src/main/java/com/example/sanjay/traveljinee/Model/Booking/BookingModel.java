package com.example.sanjay.traveljinee.Model.Booking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by SANJAY on 2/4/2018.
 */

public class BookingModel {
    @SerializedName("BookingId")
    @Expose
    private Integer bookingId;
    @SerializedName("HotelId")
    @Expose
    private Integer hotelId;
    @SerializedName("RoomTypeId")
    @Expose
    private Integer roomTypeId;
    @SerializedName("FirstName")
    @Expose
    private String firstName;
    @SerializedName("MiddleName")
    @Expose
    private String middleName;
    @SerializedName("LastName")
    @Expose
    private String lastName;
    @SerializedName("Email")
    @Expose
    private Object email;
    @SerializedName("PhoneNumber")
    @Expose
    private String phoneNumber;
    @SerializedName("NoOfGuests")
    @Expose
    private Integer noOfGuests;
    @SerializedName("NoOfGuestChildrens")
    @Expose
    private Integer noOfGuestChildrens;
    @SerializedName("ReservationDateFrom")
    @Expose
    private String reservationDateFrom;
    @SerializedName("ReservationDateTo")
    @Expose
    private String reservationDateTo;
    @SerializedName("SpecialInstructions")
    @Expose
    private Object specialInstructions;
    @SerializedName("Status")
    @Expose
    private Integer status;
    @SerializedName("IsActive")
    @Expose
    private Boolean isActive;
    @SerializedName("NoOfRoom")
    @Expose
    private Integer NoOfRoom;
    @SerializedName("TotalAmount")
    @Expose
    private Double TotalAmount;
    @SerializedName("UserId")
    @Expose
    private Integer UserId;

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Integer roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Object getEmail() {
        return email;
    }

    public void setEmail(Object email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getNoOfGuests() {
        return noOfGuests;
    }

    public void setNoOfGuests(Integer noOfGuests) {
        this.noOfGuests = noOfGuests;
    }

    public Integer getNoOfGuestChildrens() {
        return noOfGuestChildrens;
    }

    public void setNoOfGuestChildrens(Integer noOfGuestChildrens) {
        this.noOfGuestChildrens = noOfGuestChildrens;
    }

    public String getReservationDateFrom() {
        return reservationDateFrom;
    }

    public void setReservationDateFrom(String reservationDateFrom) {
        this.reservationDateFrom = reservationDateFrom;
    }

    public String getReservationDateTo() {
        return reservationDateTo;
    }

    public void setReservationDateTo(String reservationDateTo) {
        this.reservationDateTo = reservationDateTo;
    }

    public Object getSpecialInstructions() {
        return specialInstructions;
    }

    public void setSpecialInstructions(Object specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Integer getNoOfRoom() {
        return NoOfRoom;
    }

    public void setNoOfRoom(Integer noOfRoom) {
        NoOfRoom = noOfRoom;
    }

    public Double getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        TotalAmount = totalAmount;
    }

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }
}
