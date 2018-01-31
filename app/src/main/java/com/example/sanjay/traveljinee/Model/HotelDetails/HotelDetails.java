package com.example.sanjay.traveljinee.Model.HotelDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by SANJAY on 1/29/2018.
 */

public class HotelDetails {
    @SerializedName("HotelId")
    @Expose
    private Integer hotelId;
    @SerializedName("HotelTypeId")
    @Expose
    private Integer hotelTypeId;
    @SerializedName("HotelName")
    @Expose
    private String hotelName;
    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("HotelAddress")
    @Expose
    private String hotelAddress;
    @SerializedName("Longitude")
    @Expose
    private Double longitude;
    @SerializedName("Latitude")
    @Expose
    private Double latitude;
    @SerializedName("ContactEmail")
    @Expose
    private String contactEmail;
    @SerializedName("ContactPersonName")
    @Expose
    private String contactPersonName;
    @SerializedName("ContactPersonEmail")
    @Expose
    private String contactPersonEmail;
    @SerializedName("ContactPersonPhone")
    @Expose
    private String contactPersonPhone;
    @SerializedName("HotelWebUrl")
    @Expose
    private String hotelWebUrl;
    @SerializedName("VATNumber")
    @Expose
    private String vATNumber;
    @SerializedName("HotelPhoneNumber")
    @Expose
    private String hotelPhoneNumber;
    @SerializedName("EstdDate")
    @Expose
    private String estdDate;
    @SerializedName("Status")
    @Expose
    private Integer status;
    @SerializedName("CountryId")
    @Expose
    private Integer countryId;
    @SerializedName("StateId")
    @Expose
    private Integer stateId;
    @SerializedName("CityId")
    @Expose
    private Integer cityId;
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
    private String modifiedBy;
    @SerializedName("DeletedOn")
    @Expose
    private String deletedOn;
    @SerializedName("DeletedBy")
    @Expose
    private Object deletedBy;
    @SerializedName("IsActive")
    @Expose
    private Boolean isActive;

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getHotelTypeId() {
        return hotelTypeId;
    }

    public void setHotelTypeId(Integer hotelTypeId) {
        this.hotelTypeId = hotelTypeId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public String getContactPersonEmail() {
        return contactPersonEmail;
    }

    public void setContactPersonEmail(String contactPersonEmail) {
        this.contactPersonEmail = contactPersonEmail;
    }

    public String getContactPersonPhone() {
        return contactPersonPhone;
    }

    public void setContactPersonPhone(String contactPersonPhone) {
        this.contactPersonPhone = contactPersonPhone;
    }

    public String getHotelWebUrl() {
        return hotelWebUrl;
    }

    public void setHotelWebUrl(String hotelWebUrl) {
        this.hotelWebUrl = hotelWebUrl;
    }

    public String getVATNumber() {
        return vATNumber;
    }

    public void setVATNumber(String vATNumber) {
        this.vATNumber = vATNumber;
    }

    public String getHotelPhoneNumber() {
        return hotelPhoneNumber;
    }

    public void setHotelPhoneNumber(String hotelPhoneNumber) {
        this.hotelPhoneNumber = hotelPhoneNumber;
    }

    public String getEstdDate() {
        return estdDate;
    }

    public void setEstdDate(String estdDate) {
        this.estdDate = estdDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
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

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
