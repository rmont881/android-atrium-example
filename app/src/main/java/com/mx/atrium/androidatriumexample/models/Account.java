package com.mx.atrium.androidatriumexample.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by robmontgomery on 10/7/16.
 */

public class Account {

    @SerializedName("name")
    @Expose
    String name;

    @SerializedName("guid")
    @Expose
    String guid;

    @SerializedName("balance")
    @Expose
    Double amount;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }
}
