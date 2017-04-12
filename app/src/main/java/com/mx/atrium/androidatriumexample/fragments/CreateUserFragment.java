package com.mx.atrium.androidatriumexample.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.mx.atrium.androidatriumexample.R;
import com.mx.atrium.androidatriumexample.api.Keys;
import com.mx.atrium.androidatriumexample.api.AtriumAPI;
import com.mx.atrium.androidatriumexample.models.User;
import com.mx.atrium.androidatriumexample.models.UserObject;
import com.mx.atrium.androidatriumexample.models.Users;
import com.mx.atrium.androidatriumexample.utils.UserSession;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by robmontgomery on 10/5/16.
 */

public class CreateUserFragment extends Fragment{

    private FragmentListener mListener;
    private EditText firstName;
    private EditText lastName;
    private EditText email;
    private Button submitButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mListener = (FragmentListener)getActivity();


        Call<Users> users = UserSession.getSession().getAtriumAPI().listUsers();
        try {
            users.enqueue(new Callback<Users>() {
                @Override
                public void onResponse(Call<Users> call, Response<Users> response) {
                    System.out.println(response.isSuccessful());
                }

                @Override
                public void onFailure(Call<Users> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_create_user_screen,
                container, false);

        firstName = (EditText)rootView.findViewById(R.id.firstName);
        lastName = (EditText)rootView.findViewById(R.id.lastName);
        email = (EditText)rootView.findViewById(R.id.email);
        submitButton = (Button)rootView.findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                User user = new User();
                user.setFirstName(firstName.getText().toString());
                user.setLastName(lastName.getText().toString());
                user.setEmail(email.getText().toString());

                UserObject userObj = new UserObject();
                userObj.setUser(user);

                Call<UserObject> createUser = UserSession.getSession().getAtriumAPI().createUser(userObj);
                try {
                    createUser.enqueue(new Callback<UserObject>() {
                        @Override
                        public void onResponse(Call<UserObject> call, Response<UserObject> response) {
                            if(response.isSuccessful()) {
                                UserSession.getSession().setUser(response.body().getUser());
                                AccountsFragment fragment = new AccountsFragment();
                                mListener.pushFragment(fragment, "accounts");
                            }
                        }

                        @Override
                        public void onFailure(Call<UserObject> call, Throwable t) {
                            t.printStackTrace();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });



        return rootView;
    }

}
