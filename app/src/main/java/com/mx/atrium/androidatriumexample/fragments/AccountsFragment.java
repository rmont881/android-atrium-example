package com.mx.atrium.androidatriumexample.fragments;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import com.mx.atrium.androidatriumexample.AccountArrayAdapter;
import com.mx.atrium.androidatriumexample.R;
import com.mx.atrium.androidatriumexample.models.Institutions;
import com.mx.atrium.androidatriumexample.utils.UserSession;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by robmontgomery on 10/6/16.
 */

public class AccountsFragment extends ListFragment implements AdapterView.OnItemClickListener {

    private FragmentListener mListener;

    private Button createAccountButton;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mListener = (FragmentListener) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_accounts_screen, container, false);
        createAccountButton = (Button)view.findViewById(R.id.create_account_button);
        createAccountButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Call<Institutions> institutions = UserSession.getSession().getAtriumAPI().listInstitutions();
                try {
                    institutions.enqueue(new Callback<Institutions>() {
                        @Override
                        public void onResponse(Call<Institutions> call, Response<Institutions> response) {
                            if(response.isSuccessful()) {
                                UserSession.getSession().setInstitutions(response.body().getAccounts());
                                CreateAccountFragment fragment = new CreateAccountFragment();
                                mListener.pushFragment(fragment, "create_account");
                            } else {
                                Toast.makeText(getActivity(), "Error getting list of institutions.", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Institutions> call, Throwable t) {
                            Toast.makeText(getActivity(), "Error getting list of institutions.", Toast.LENGTH_SHORT).show();
                            t.printStackTrace();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        AccountArrayAdapter adapter = new AccountArrayAdapter(getActivity(), UserSession.getSession().getAccounts());
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();
    }
}
