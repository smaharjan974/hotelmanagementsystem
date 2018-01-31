package com.example.sanjay.traveljinee.CustomModel;

import java.util.List;

/**
 * Created by SANJAY on 1/19/2018.
 */

public class MainModel {
    String address;
    String checkindate;
    String checkoutdate;
    String roomno;
    String adultno;
    String childno;
    String roomtype;
    List<Integer> ratinglist;
    List<String> featureslist;
    String maxdistance;
    String maxprice;
    String hotelname;


    public MainModel(String address, String checkindate, String checkoutdate, String roomno, String adultno, String childno, String roomtype, List<Integer> ratinglist, List<String> featureslist, String maxdistance, String maxprice, String hotelname) {
        this.address = address;
        this.checkindate = checkindate;
        this.checkoutdate = checkoutdate;
        this.roomno = roomno;
        this.adultno = adultno;
        this.childno = childno;
        this.roomtype = roomtype;
        this.ratinglist = ratinglist;
        this.featureslist = featureslist;
        this.maxdistance = maxdistance;
        this.maxprice = maxprice;
        this.hotelname = hotelname;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }

    public List<Integer> getRatinglist() {
        return ratinglist;
    }

    public void setRatinglist(List<Integer> ratinglist) {
        this.ratinglist = ratinglist;
    }

    public List<String> getFeatureslist() {
        return featureslist;
    }

    public void setFeatureslist(List<String> featureslist) {
        this.featureslist = featureslist;
    }

    public String getMaxdistance() {
        return maxdistance;
    }

    public void setMaxdistance(String maxdistance) {
        this.maxdistance = maxdistance;
    }

    public String getMaxprice() {
        return maxprice;
    }

    public void setMaxprice(String maxprice) {
        this.maxprice = maxprice;
    }

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCheckindate() {
        return checkindate;
    }

    public void setCheckindate(String checkindate) {
        this.checkindate = checkindate;
    }

    public String getCheckoutdate() {
        return checkoutdate;
    }

    public void setCheckoutdate(String checkoutdate) {
        this.checkoutdate = checkoutdate;
    }

    public String getRoomno() {
        return roomno;
    }

    public void setRoomno(String roomno) {
        this.roomno = roomno;
    }

    public String getAdultno() {
        return adultno;
    }

    public void setAdultno(String adultno) {
        this.adultno = adultno;
    }

    public String getChildno() {
        return childno;
    }

    public void setChildno(String childno) {
        this.childno = childno;
    }
}
