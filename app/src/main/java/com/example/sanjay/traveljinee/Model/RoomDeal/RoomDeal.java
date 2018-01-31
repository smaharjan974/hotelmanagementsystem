package com.example.sanjay.traveljinee.Model.RoomDeal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by SANJAY on 1/29/2018.
 */

public class RoomDeal {
    @SerializedName("roomId")
    @Expose
    private Integer roomId;
    @SerializedName("RoomName")
    @Expose
    private String roomName;
    @SerializedName("RoomTypeName")
    @Expose
    private String roomTypeName;
    @SerializedName("RoomTypeId")
    @Expose
    private Integer roomTypeId;
    @SerializedName("noOfBed")
    @Expose
    private Integer noOfBed;
    @SerializedName("MaxOccupancy")
    @Expose
    private Integer maxOccupancy;
    @SerializedName("MaxChildOccupancy")
    @Expose
    private Integer maxChildOccupancy;
    @SerializedName("PricePerday")
    @Expose
    private Integer pricePerday;
    @SerializedName("FacilityId")
    @Expose
    private Integer facilityId;
    @SerializedName("FacilityName")
    @Expose
    private String facilityName;
    @SerializedName("Cost")
    @Expose
    private Integer cost;

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    public Integer getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Integer roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public Integer getNoOfBed() {
        return noOfBed;
    }

    public void setNoOfBed(Integer noOfBed) {
        this.noOfBed = noOfBed;
    }

    public Integer getMaxOccupancy() {
        return maxOccupancy;
    }

    public void setMaxOccupancy(Integer maxOccupancy) {
        this.maxOccupancy = maxOccupancy;
    }

    public Integer getMaxChildOccupancy() {
        return maxChildOccupancy;
    }

    public void setMaxChildOccupancy(Integer maxChildOccupancy) {
        this.maxChildOccupancy = maxChildOccupancy;
    }

    public Integer getPricePerday() {
        return pricePerday;
    }

    public void setPricePerday(Integer pricePerday) {
        this.pricePerday = pricePerday;
    }

    public Integer getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Integer facilityId) {
        this.facilityId = facilityId;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

}
