package com.mx.atrium.androidatriumexample;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mx.atrium.androidatriumexample.fragments.FragmentListener;
import com.mx.atrium.androidatriumexample.fragments.LoginFlowFragment;
import com.mx.atrium.androidatriumexample.fragments.SplashFragment;
import com.mx.atrium.androidatriumexample.utils.UserSession;

public class MainActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener, FragmentListener {

    public static final String PREFS_NAME = "MXPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null) {
            SplashFragment splash = new SplashFragment();
            getFragmentManager().beginTransaction()
                    .replace(R.id.containerLayout, splash).commit();
            getFragmentManager().addOnBackStackChangedListener(this);
        }
    }

    @Override
    public void onBackStackChanged() {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void pushFragment(Fragment newFragment, String breadcrumb) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if(newFragment instanceof LoginFlowFragment) {
            ft.setCustomAnimations(R.anim.fade_in,
                    R.anim.fade_out,R.anim.fade_in, R.anim.fade_out);
        } else {
            ft.setCustomAnimations(R.anim.slide_left,
                    R.anim.slide_right,R.anim.slide_left_in, R.anim.slide_right_in);
            ft.addToBackStack(breadcrumb);
        }
        ft.replace(R.id.containerLayout, newFragment, breadcrumb);
        ft.commit();
    }

    @Override
    public void popFragment() {

    }

    @Override
    public void saveUserGuid() {
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("user_guid", UserSession.getSession().getUser().getGuid());
    }
}
