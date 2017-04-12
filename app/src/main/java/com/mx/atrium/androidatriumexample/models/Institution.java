package com.mx.atrium.androidatriumexample.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by robmontgomery on 10/7/16.
 */

public class Institution {
    @SerializedName("name")
    @Expose
    String name;

    @SerializedName("guid")
    @Expose
    String guid;

    @SerializedName("url")
    @Expose
    String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
