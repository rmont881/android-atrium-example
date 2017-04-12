package com.mx.atrium.androidatriumexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mx.atrium.androidatriumexample.models.User;

import java.util.List;

/**
 * Created by robmontgomery on 10/7/16.
 */

public class UserListArrayAdapter extends ArrayAdapter<User> {
    public UserListArrayAdapter(Context context, List<User> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        User user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user_list, parent, false);
        }
        // Lookup view for data population
        TextView first_name = (TextView) convertView.findViewById(R.id.user_first_name);
        TextView last_name = (TextView) convertView.findViewById(R.id.user_last_name);
        // Populate the data into the template view using the data object
        first_name.setText(user.getFirstName());
        last_name.setText(user.getLastName().toString());
        // Return the completed view to render on screen
        return convertView;
    }
}
