package com.example.sanjay.traveljinee.HotelList.Fragment.ReviewFragment;

/**
 * Created by SANJAY on 1/11/2018.
 */

public class ReviewModel {
    float rate;
    String name;
    String date;
    String title;
    String description;

    public ReviewModel(float rate, String name, String date, String title, String description) {
        this.rate = rate;
        this.name = name;
        this.date = date;
        this.title = title;
        this.description = description;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
