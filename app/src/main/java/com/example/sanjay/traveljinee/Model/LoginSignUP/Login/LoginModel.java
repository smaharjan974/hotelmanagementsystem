package com.example.sanjay.traveljinee.Model.LoginSignUP.Login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by SANJAY on 2/5/2018.
 */

public class LoginModel {
    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("UserName")
    @Expose
    private String userName;
    @SerializedName("Email")
    @Expose
    private String email;
    @SerializedName("EmailConfirmed")
    @Expose
    private Boolean emailConfirmed;
    @SerializedName("PasswordHash")
    @Expose
    private String passwordHash;
    @SerializedName("SecurityStamp")
    @Expose
    private String securityStamp;
    @SerializedName("ConcurrencyStamp")
    @Expose
    private String concurrencyStamp;
    @SerializedName("PhoneNumber")
    @Expose
    private Object phoneNumber;
    @SerializedName("PhoneNumberConfirmed")
    @Expose
    private Boolean phoneNumberConfirmed;
    @SerializedName("TwoFactorEnabled")
    @Expose
    private Boolean twoFactorEnabled;
    @SerializedName("LockoutEnd")
    @Expose
    private Object lockoutEnd;
    @SerializedName("LockoutEnabled")
    @Expose
    private Boolean lockoutEnabled;
    @SerializedName("AccessFailedCount")
    @Expose
    private Integer accessFailedCount;
    @SerializedName("Roles")
    @Expose
    private List<Object> roles = null;
    @SerializedName("Claims")
    @Expose
    private List<Object> claims = null;
    @SerializedName("Logins")
    @Expose
    private List<Object> logins = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEmailConfirmed() {
        return emailConfirmed;
    }

    public void setEmailConfirmed(Boolean emailConfirmed) {
        this.emailConfirmed = emailConfirmed;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getSecurityStamp() {
        return securityStamp;
    }

    public void setSecurityStamp(String securityStamp) {
        this.securityStamp = securityStamp;
    }

    public String getConcurrencyStamp() {
        return concurrencyStamp;
    }

    public void setConcurrencyStamp(String concurrencyStamp) {
        this.concurrencyStamp = concurrencyStamp;
    }

    public Object getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Object phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getPhoneNumberConfirmed() {
        return phoneNumberConfirmed;
    }

    public void setPhoneNumberConfirmed(Boolean phoneNumberConfirmed) {
        this.phoneNumberConfirmed = phoneNumberConfirmed;
    }

    public Boolean getTwoFactorEnabled() {
        return twoFactorEnabled;
    }

    public void setTwoFactorEnabled(Boolean twoFactorEnabled) {
        this.twoFactorEnabled = twoFactorEnabled;
    }

    public Object getLockoutEnd() {
        return lockoutEnd;
    }

    public void setLockoutEnd(Object lockoutEnd) {
        this.lockoutEnd = lockoutEnd;
    }

    public Boolean getLockoutEnabled() {
        return lockoutEnabled;
    }

    public void setLockoutEnabled(Boolean lockoutEnabled) {
        this.lockoutEnabled = lockoutEnabled;
    }

    public Integer getAccessFailedCount() {
        return accessFailedCount;
    }

    public void setAccessFailedCount(Integer accessFailedCount) {
        this.accessFailedCount = accessFailedCount;
    }

    public List<Object> getRoles() {
        return roles;
    }

    public void setRoles(List<Object> roles) {
        this.roles = roles;
    }

    public List<Object> getClaims() {
        return claims;
    }

    public void setClaims(List<Object> claims) {
        this.claims = claims;
    }

    public List<Object> getLogins() {
        return logins;
    }

    public void setLogins(List<Object> logins) {
        this.logins = logins;
    }
}
