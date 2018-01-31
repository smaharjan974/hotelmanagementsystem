package com.example.sanjay.traveljinee.HotelList.Fragment.Details;

/**
 * Created by SANJAY on 1/5/2018.
 */

public class DetailsModel {
    int image;
    String imagename;

    public DetailsModel(int image, String imagename) {
        this.image = image;
        this.imagename = imagename;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getImagename() {
        return imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
    }
}
