package com.mx.atrium.androidatriumexample.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.mx.atrium.androidatriumexample.InstitutionArrayAdapter;
import com.mx.atrium.androidatriumexample.R;
import com.mx.atrium.androidatriumexample.models.Institution;
import com.mx.atrium.androidatriumexample.utils.UserSession;

/**
 * Created by robmontgomery on 10/7/16.
 */

public class CreateAccountFragment extends Fragment {

    private FragmentListener mListener;

    private Spinner institutionAutoComplete;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mListener = (FragmentListener) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_account_screen, container, false);
        institutionAutoComplete = (Spinner) view.findViewById(R.id.institution_spinner);
        InstitutionArrayAdapter arrayAdapter = new InstitutionArrayAdapter(getActivity(),R.layout.item_spinner, UserSession.getSession().getInstitutions(), getResources());
        institutionAutoComplete.setAdapter(arrayAdapter);
        institutionAutoComplete.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Log.v("item", ((Institution)parent.getItemAtPosition(position)).getName());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
        return view;
    }
}
