package com.example.sanjay.traveljinee.CustomModel;

import com.example.sanjay.traveljinee.Model.Booking.BookingModel;
import com.example.sanjay.traveljinee.Model.BookingPayment.BookingPaymentModel;

/**
 * Created by SANJAY on 2/5/2018.
 */

public class BookingWithHotelDetails {
    BookingModel bookingPaymentModel;
    HotelDetailsWithModelRoomDeal hotelDetailsWithModelRoomDeal;

    public BookingWithHotelDetails(BookingModel bookingPaymentModel, HotelDetailsWithModelRoomDeal hotelDetailsWithModelRoomDeal) {
        this.bookingPaymentModel = bookingPaymentModel;
        this.hotelDetailsWithModelRoomDeal = hotelDetailsWithModelRoomDeal;
    }

    public BookingModel getBookingPaymentModel() {
        return bookingPaymentModel;
    }

    public void setBookingPaymentModel(BookingModel bookingPaymentModel) {
        this.bookingPaymentModel = bookingPaymentModel;
    }

    public HotelDetailsWithModelRoomDeal getHotelDetailsWithModelRoomDeal() {
        return hotelDetailsWithModelRoomDeal;
    }

    public void setHotelDetailsWithModelRoomDeal(HotelDetailsWithModelRoomDeal hotelDetailsWithModelRoomDeal) {
        this.hotelDetailsWithModelRoomDeal = hotelDetailsWithModelRoomDeal;
    }
}
