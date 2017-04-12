package com.mx.atrium.androidatriumexample.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by robmontgomery on 10/6/16.
 */

public class Users {

    @SerializedName(value="users")
    public List<User> users;

    public void setUsers(List<User> users) {
        this.users = users;

    }

    public List<User> getUsers() {
        return users;
    }
}
