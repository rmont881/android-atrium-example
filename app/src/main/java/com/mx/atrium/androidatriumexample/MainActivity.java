package com.mx.atrium.androidatriumexample;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mx.atrium.androidatriumexample.fragments.SplashFragment;

public class MainActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState == null) {
            SplashFragment splash = new SplashFragment();
            getFragmentManager().beginTransaction()
                    .replace(R.id.containerLayout, splash).commit();
            getFragmentManager().addOnBackStackChangedListener(this);
        }
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackStackChanged() {

    }
}
