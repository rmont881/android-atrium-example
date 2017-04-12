package com.mx.atrium.androidatriumexample.api;

import com.mx.atrium.androidatriumexample.models.Accounts;
import com.mx.atrium.androidatriumexample.models.Institutions;
import com.mx.atrium.androidatriumexample.models.UserObject;
import com.mx.atrium.androidatriumexample.models.Users;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by robmontgomery on 10/6/16.
 */

public interface AtriumAPI {
    @Headers({
            "Accept: application/vnd.mx.atrium.v1+json",
            "MX-API-KEY: " + Keys.MX_API_KEY,
            "MX-CLIENT-ID: " + Keys.MX_CLIENT_ID
    })
    @GET("users")
    Call<Users> listUsers();

    @Headers({
            "Accept: application/vnd.mx.atrium.v1+json",
            "MX-API-KEY: " + Keys.MX_API_KEY,
            "MX-CLIENT-ID: " + Keys.MX_CLIENT_ID
    })
    @POST("users")
    Call<UserObject> createUser(@Body UserObject user);

    @Headers({
            "Accept: application/vnd.mx.atrium.v1+json",
            "MX-API-KEY: " + Keys.MX_API_KEY,
            "MX-CLIENT-ID: " + Keys.MX_CLIENT_ID
    })
    @GET("users/{user}/accounts")
    Call<Accounts> getAccounts(@Path("user") String user);

    @Headers({
            "Accept: application/vnd.mx.atrium.v1+json",
            "MX-API-KEY: " + Keys.MX_API_KEY,
            "MX-CLIENT-ID: " + Keys.MX_CLIENT_ID
    })
    @GET("institutions")
    Call<Institutions> listInstitutions();
}
