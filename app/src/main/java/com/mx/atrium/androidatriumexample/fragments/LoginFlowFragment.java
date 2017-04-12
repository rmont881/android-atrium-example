package com.mx.atrium.androidatriumexample.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.mx.atrium.androidatriumexample.R;
import com.mx.atrium.androidatriumexample.models.User;
import com.mx.atrium.androidatriumexample.models.Users;
import com.mx.atrium.androidatriumexample.utils.UserSession;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by robmontgomery on 10/5/16.
 */

public class LoginFlowFragment extends Fragment {

    private FragmentListener mListener;
    private TextView mxAtriumYes;
    private TextView mxAtriumNo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mListener = (FragmentListener)getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_login_flow_screen,
                container, false);

        mxAtriumYes = (TextView)rootView.findViewById(R.id.mxAtriumYes);
        mxAtriumNo = (TextView)rootView.findViewById(R.id.mxAtriumNo);

        mxAtriumYes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(UserSession.getSession().getUsers() == null) {
                    Call<Users> users = UserSession.getSession().getAtriumAPI().listUsers();
                    try {
                        users.enqueue(new Callback<Users>() {
                            @Override
                            public void onResponse(Call<Users> call, Response<Users> response) {
                                if(response.isSuccessful()) {
                                    UserSession.getSession().setUsers(new ArrayList<User>(response.body().getUsers()));
                                    UserListFragment fragment = new UserListFragment();
                                    mListener.pushFragment(fragment, "user_list");
                                } else {
                                    Toast.makeText(getActivity(), "Error getting list of users.", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<Users> call, Throwable t) {
                                Toast.makeText(getActivity(), "Error getting list of users.", Toast.LENGTH_SHORT).show();
                                t.printStackTrace();
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    UserListFragment fragment = new UserListFragment();
                    mListener.pushFragment(fragment, "user_list");
                }
            }
        });
        mxAtriumNo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CreateUserFragment fragment = new CreateUserFragment();
                mListener.pushFragment(fragment, "create_user");
            }
        });

        return rootView;
    }

}
