package com.mx.atrium.androidatriumexample.fragments;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.mx.atrium.androidatriumexample.R;
import com.mx.atrium.androidatriumexample.UserListArrayAdapter;
import com.mx.atrium.androidatriumexample.models.Accounts;
import com.mx.atrium.androidatriumexample.models.User;
import com.mx.atrium.androidatriumexample.utils.UserSession;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by robmontgomery on 10/7/16.
 */

public class UserListFragment extends ListFragment implements AdapterView.OnItemClickListener {

    private FragmentListener mListener;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mListener = (FragmentListener) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_accounts_screen, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        UserListArrayAdapter adapter = new UserListArrayAdapter(getActivity(), UserSession.getSession().getUsers());
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        User user = (User)parent.getItemAtPosition(position);
        UserSession.getSession().setUser(user);

        Call<Accounts> accounts = UserSession.getSession().getAtriumAPI().getAccounts(user.getGuid());
        try {
            accounts.enqueue(new Callback<Accounts>() {
                @Override
                public void onResponse(Call<Accounts> call, Response<Accounts> response) {
                    if(response.isSuccessful()) {
                        UserSession.getSession().setAccounts(response.body().getAccounts());
                        AccountsFragment fragment = new AccountsFragment();
                        mListener.pushFragment(fragment, "user_list");
                    } else {
                        Toast.makeText(getActivity(), "Error getting list of users.", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Accounts> call, Throwable t) {
                    Toast.makeText(getActivity(), "Error getting list of users.", Toast.LENGTH_SHORT).show();
                    t.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
