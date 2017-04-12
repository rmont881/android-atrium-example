package com.mx.atrium.androidatriumexample.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by robmontgomery on 10/6/16.
 */

public class User {
    @SerializedName("birthday")
    @Expose(serialize = false)
    String birthday = null;

    @SerializedName("credit_score")
    @Expose(serialize = false)
    Integer creditScore = null;

    @SerializedName("email")
    @Expose
    String email = null;

    @SerializedName("first_name")
    @Expose
    String firstName = null;

    @SerializedName("last_name")
    @Expose
    String lastName = null;

    @SerializedName("guid")
    @Expose(serialize = false)
    String guid = null;

    @SerializedName("is_disabled")
    @Expose(serialize = false)
    boolean isDisabled = false;

    @SerializedName("logged_in_at")
    @Expose(serialize = false)
    Long loggedInAt = null;

    @SerializedName("zip_code")
    @Expose(serialize = false)
    String zipCode = null;

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public boolean isDisabled() {
        return isDisabled;
    }

    public void setDisabled(boolean disabled) {
        isDisabled = disabled;
    }

    public long getLoggedInAt() {
        return loggedInAt;
    }

    public void setLoggedInAt(long loggedInAt) {
        this.loggedInAt = loggedInAt;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

}
