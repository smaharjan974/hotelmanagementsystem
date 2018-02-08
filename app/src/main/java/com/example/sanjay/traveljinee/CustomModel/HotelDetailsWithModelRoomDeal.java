package com.example.sanjay.traveljinee.CustomModel;

/**
 * Created by SANJAY on 2/4/2018.
 */

public class HotelDetailsWithModelRoomDeal {
    HotelDetailsWithModel hotelDetailsWithModel;
    RoomDealModel roomDealModel;

    public HotelDetailsWithModelRoomDeal(HotelDetailsWithModel hotelDetailsWithModel, RoomDealModel roomDealModel) {
        this.hotelDetailsWithModel = hotelDetailsWithModel;
        this.roomDealModel = roomDealModel;
    }

    public HotelDetailsWithModel getHotelDetailsWithModel() {
        return hotelDetailsWithModel;
    }

    public void setHotelDetailsWithModel(HotelDetailsWithModel hotelDetailsWithModel) {
        this.hotelDetailsWithModel = hotelDetailsWithModel;
    }

    public RoomDealModel getRoomDealModel() {
        return roomDealModel;
    }

    public void setRoomDealModel(RoomDealModel roomDealModel) {
        this.roomDealModel = roomDealModel;
    }
}
