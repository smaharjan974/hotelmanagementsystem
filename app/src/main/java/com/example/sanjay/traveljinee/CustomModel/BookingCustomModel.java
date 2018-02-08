package com.example.sanjay.traveljinee.CustomModel;

/**
 * Created by SANJAY on 2/4/2018.
 */

public class BookingCustomModel {
    Integer hotelId;
    Integer RoomTypeId;
    String FirstName;
    String MiddleName;
    String LastName;
    String Email;
    String PhoneNumber;
    Integer NoOfGuests;
    Integer NoOfGuestChildrens;
    String ReservationDateFrom;
    String ReservationDateTo;
    String SpecialInstructions;
    Integer NoOfRoom;
    Double TotalAmount;
    Integer UserId;

    public BookingCustomModel(Integer hotelId, Integer roomTypeId, String firstName, String middleName, String lastName, String email, String phoneNumber, Integer noOfGuests, Integer noOfGuestChildrens, String reservationDateFrom, String reservationDateTo, String specialInstructions, Integer noOfRoom, Double totalAmount, Integer userId) {
        this.hotelId = hotelId;
        this.RoomTypeId = roomTypeId;
        this.FirstName = firstName;
        this.MiddleName = middleName;
        this.LastName = lastName;
        this.Email = email;
        this.PhoneNumber = phoneNumber;
        this.NoOfGuests = noOfGuests;
        this.NoOfGuestChildrens = noOfGuestChildrens;
        this.ReservationDateFrom = reservationDateFrom;
        this.ReservationDateTo = reservationDateTo;
        this.SpecialInstructions = specialInstructions;
        this.NoOfRoom = noOfRoom;
        this.TotalAmount = totalAmount;
        this.UserId = userId;
    }
}
