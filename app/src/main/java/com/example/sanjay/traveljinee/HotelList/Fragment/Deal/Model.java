package com.example.sanjay.traveljinee.HotelList.Fragment.Deal;

import java.util.List;

/**
 * Created by SANJAY on 12/31/2017.
 */

public class Model {
    String room;
    String sleeps;
    String bed;
    List<String> features;
    List<String> services;
    String message;
    String price;

    public Model(String room, String sleeps, String bed, List<String> features, List<String> services, String message, String price) {
        this.room = room;
        this.sleeps = sleeps;
        this.bed = bed;
        this.features = features;
        this.services = services;
        this.message = message;
        this.price = price;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
