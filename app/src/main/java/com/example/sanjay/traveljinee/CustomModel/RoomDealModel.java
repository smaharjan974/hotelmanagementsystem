package com.example.sanjay.traveljinee.CustomModel;

import java.util.List;

/**
 * Created by SANJAY on 2/2/2018.
 */

public class RoomDealModel {
    Integer hotelId;
    Integer roomId;
    String room;
    String sleeps;
    String bed;
    List<String> features;
    List<String> services;

    String price;

    public RoomDealModel(Integer hotelId,Integer roomId, String room, String sleeps, String bed, List<String> features, List<String> services, String price) {
        this.hotelId = hotelId;
        this.roomId = roomId;
        this.room = room;
        this.sleeps = sleeps;
        this.bed = bed;
        this.features = features;
        this.services = services;
        this.price = price;

    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getSleeps() {
        return sleeps;
    }

    public void setSleeps(String sleeps) {
        this.sleeps = sleeps;
    }

    public String getBed() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }

    public List<String> getServices() {
        return services;
    }

    public void setServices(List<String> services) {
        this.services = services;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
