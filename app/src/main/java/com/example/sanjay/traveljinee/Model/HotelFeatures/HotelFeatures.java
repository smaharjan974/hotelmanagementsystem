package com.example.sanjay.traveljinee.Model.HotelFeatures;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by SANJAY on 1/30/2018.
 */

public class HotelFeatures {
    @SerializedName("FeaturesId")
    @Expose
    private Integer featuresId;
    @SerializedName("HotelId")
    @Expose
    private Integer hotelId;
    @SerializedName("FeatureName")
    @Expose
    private String featureName;
    @SerializedName("Description")
    @Expose
    private String description;
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
    @SerializedName("Status")
    @Expose
    private Integer status;
    @SerializedName("IsActive")
    @Expose
    private Boolean isActive;

    public Integer getFeaturesId() {
        return featuresId;
    }

    public void setFeaturesId(Integer featuresId) {
        this.featuresId = featuresId;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
