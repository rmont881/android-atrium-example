package com.mx.atrium.androidatriumexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mx.atrium.androidatriumexample.models.Account;

import java.util.List;

/**
 * Created by robmontgomery on 10/7/16.
 */

public class AccountArrayAdapter extends ArrayAdapter<Account> {
    public AccountArrayAdapter(Context context, List<Account> accounts) {
        super(context, 0, accounts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Account account = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_account_list, parent, false);
        }
        // Lookup view for data population
        TextView account_name = (TextView) convertView.findViewById(R.id.account_name);
        TextView account_amount = (TextView) convertView.findViewById(R.id.account_balance);
        // Populate the data into the template view using the data object
        account_name.setText(account.getName());
        account_amount.setText(account.getAmount().toString());
        // Return the completed view to render on screen
        return convertView;
    }
}
