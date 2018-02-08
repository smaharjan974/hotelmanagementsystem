package com.example.sanjay.traveljinee.CustomModel;

import com.example.sanjay.traveljinee.Model.BookingPayment.BookingPaymentModel;

/**
 * Created by SANJAY on 2/6/2018.
 */

public class BookingPaymentWithHotelDetails {
    BookingWithHotelDetails bookingWithHotelDetails;
    BookingPaymentModel bookingPaymentModel;

    public BookingPaymentWithHotelDetails(BookingWithHotelDetails bookingWithHotelDetails, BookingPaymentModel bookingPaymentModel) {
        this.bookingWithHotelDetails = bookingWithHotelDetails;
        this.bookingPaymentModel = bookingPaymentModel;
    }

    public BookingWithHotelDetails getBookingWithHotelDetails() {
        return bookingWithHotelDetails;
    }

    public void setBookingWithHotelDetails(BookingWithHotelDetails bookingWithHotelDetails) {
        this.bookingWithHotelDetails = bookingWithHotelDetails;
    }

    public BookingPaymentModel getBookingPaymentModel() {
        return bookingPaymentModel;
    }

    public void setBookingPaymentModel(BookingPaymentModel bookingPaymentModel) {
        this.bookingPaymentModel = bookingPaymentModel;
    }
}
