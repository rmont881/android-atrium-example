package com.mx.atrium.androidatriumexample.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by robmontgomery on 10/6/16.
 */

public class UserObject {
    @SerializedName("user")
    @Expose
    UserOverview user;

    public UserOverview getUser() {
        return user;
    }

    public void setUser(UserOverview user) {
        this.user = user;
    }
}
