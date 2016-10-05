package com.mx.atrium.androidatriumexample.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mx.atrium.androidatriumexample.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by robmontgomery on 10/5/16.
 */

public class SplashFragment extends Fragment {

    private Timer splashTimer;

    public SplashFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        splashTimer= new Timer();
        splashTimer.schedule(new TimerTask() {
                @Override
                public void run() {
//                    EmailLoginFragment fragment= new EmailLoginFragment();
//                    mListener.pushFragment(fragment, "Email");

                }
            }, 3000);
        View rootView =  inflater.inflate(R.layout.fragment_splash_screen,
                container, false);

        return rootView;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
