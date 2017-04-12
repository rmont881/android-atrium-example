package com.mx.atrium.androidatriumexample.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by robmontgomery on 10/7/16.
 */

public class Institutions {

    @SerializedName(value="institutions")
    public List<Institution> Institution;

    public void setAccounts(List<Institution> Institution) {
        this.Institution = Institution;

    }

    public List<Institution> getAccounts() {
        return Institution;
    }
}
