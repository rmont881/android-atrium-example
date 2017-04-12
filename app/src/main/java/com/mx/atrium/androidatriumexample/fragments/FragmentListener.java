package com.mx.atrium.androidatriumexample.fragments;

/**
 * Created by robmontgomery on 10/5/16.
 */

import android.app.Fragment;
import android.net.Uri;

public interface FragmentListener {
    public void onFragmentInteraction(Uri uri);
    public void pushFragment(Fragment newFragment, String breadcrumb);
    public void popFragment();
    public void saveUserGuid();

}
