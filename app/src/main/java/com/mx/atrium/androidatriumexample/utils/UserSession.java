package com.mx.atrium.androidatriumexample.utils;

import com.mx.atrium.androidatriumexample.api.AtriumAPI;
import com.mx.atrium.androidatriumexample.api.Keys;
import com.mx.atrium.androidatriumexample.models.Account;
import com.mx.atrium.androidatriumexample.models.Institution;
import com.mx.atrium.androidatriumexample.models.User;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by robmontgomery on 10/6/16.
 */

public class UserSession {

    private static UserSession session;
    private User user;
    private AtriumAPI atriumAPI;

    private List<Institution> institutions;
    private List<User> users;
    private List<Account> accounts;

    public static UserSession getSession() {
        if(session == null) {
            session = new UserSession();
        }
        return session;
    }

    public AtriumAPI getAtriumAPI() {
        if(atriumAPI == null) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(logging);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Keys.MX_API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();

            atriumAPI = retrofit.create(AtriumAPI.class);
        }
        return atriumAPI;
    }

    public void setUser(User newUser) {
        user = newUser;
    }

    public User getUser() {
        return user;
    }

    public void setUsers(List<User> userList) {
        users = userList;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Account> getAccounts() {
        return accounts;
    }
    public void setAccounts(List<Account> accountList) {
        this.accounts = accountList;
    }

    public List<Institution> getInstitutions() {
        return institutions;
    }
    public void setInstitutions(List<Institution> institutionList) {
        this.institutions = institutionList;
    }

}
