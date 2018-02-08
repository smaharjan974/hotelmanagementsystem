package com.example.sanjay.traveljinee.Model.CommonFeatures;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by SANJAY on 2/6/2018.
 */

public class CommonFeaturesModel {
    @SerializedName("FacilityId")
    @Expose
    private Integer facilityId;
    @SerializedName("FacilityName")
    @Expose
    private String facilityName;
    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("IsFree")
    @Expose
    private Boolean isFree;
    @SerializedName("Cost")
    @Expose
    private Integer cost;
    @SerializedName("IsRoomType")
    @Expose
    private Boolean isRoomType;
    @SerializedName("HotelId")
    @Expose
    private Integer hotelId;
    @SerializedName("Status")
    @Expose
    private Integer status;
    @SerializedName("IsActive")
    @Expose
    private Boolean isActive;
    @SerializedName("Addedon")
    @Expose
    private String addedon;
    @SerializedName("AddedBy")
    @Expose
    private String addedBy;
    @SerializedName("ModifiedOn")
    @Expose
    private String modifiedOn;
    @SerializedName("ModifiedBy")
    @Expose
    private Object modifiedBy;
    @SerializedName("DeletedOn")
    @Expose
    private String deletedOn;
    @SerializedName("DeletedBy")
    @Expose
    private Object deletedBy;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsFree() {
        return isFree;
    }

    public void setIsFree(Boolean isFree) {
        this.isFree = isFree;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Boolean getIsRoomType() {
        return isRoomType;
    }

    public void setIsRoomType(Boolean isRoomType) {
        this.isRoomType = isRoomType;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getAddedon() {
        return addedon;
    }

    public void setAddedon(String addedon) {
        this.addedon = addedon;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    public String getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(String modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public Object getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Object modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getDeletedOn() {
        return deletedOn;
    }

    public void setDeletedOn(String deletedOn) {
        this.deletedOn = deletedOn;
    }

    public Object getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(Object deletedBy) {
        this.deletedBy = deletedBy;
    }
}
