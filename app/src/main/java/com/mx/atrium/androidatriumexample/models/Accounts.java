package com.mx.atrium.androidatriumexample.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by robmontgomery on 10/7/16.
 */

public class Accounts {
    @SerializedName(value="accounts")
    public List<Account> accounts;

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;

    }

    public List<Account> getAccounts() {
        return accounts;
    }
}
