package com.example.sanjay.traveljinee.Model;

import java.util.List;

/**
 * Created by SANJAY on 1/25/2018.
 */

public class HotelDetailsModel {
    String hotelname;
    String hoteladdress;
    String roomtype;
    String sleep;
    String bed;
    List<String> features;
    List<String> services;
    String specialoffer;
    String price;
    String hoteldescription;


    public HotelDetailsModel(String hotelname, String hoteladdress, String roomtype, String sleep, String bed, List<String> features, List<String> services, String specialoffer, String price, String hoteldescription) {
        this.hotelname = hotelname;
        this.hoteladdress = hoteladdress;
        this.roomtype = roomtype;
        this.sleep = sleep;
        this.bed = bed;
        this.features = features;
        this.services = services;
        this.specialoffer = specialoffer;
        this.price = price;
        this.hoteldescription = hoteldescription;

    }

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }

    public String getHoteladdress() {
        return hoteladdress;
    }

    public void setHoteladdress(String hoteladdress) {
        this.hoteladdress = hoteladdress;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }

    public String getSleep() {
        return sleep;
    }

    public void setSleep(String sleep) {
        this.sleep = sleep;
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

    public String getSpecialoffer() {
        return specialoffer;
    }

    public void setSpecialoffer(String specialoffer) {
        this.specialoffer = specialoffer;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getHoteldescription() {
        return hoteldescription;
    }

    public void setHoteldescription(String hoteldescription) {
        this.hoteldescription = hoteldescription;
    }

}
