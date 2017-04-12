package com.mx.atrium.androidatriumexample.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by robmontgomery on 10/18/16.
 */

public class UserOverview {

    @SerializedName("identifier")
    @Expose
    String identifier;

    public String getIdentifier() {
        return identifier;
    }

    public void setUser(String identifier) {
        this.identifier = identifier;
    }


    @SerializedName("metadata")
    @Expose
    User metadata;

    public User getMetadata() {
        return metadata;
    }

    public void setMetadata(User metadata) {
        this.metadata = metadata;
    }
}
