package com.mx.atrium.androidatriumexample;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mx.atrium.androidatriumexample.models.Institution;

import java.util.List;

public class InstitutionArrayAdapter extends ArrayAdapter<Institution> {

    private Context context;
    private List<Institution> statuses;
    public Resources res;
    Institution currRowVal = null;
    LayoutInflater inflater;

    public InstitutionArrayAdapter(Context context,
                         int textViewResourceId, List<Institution> statuses,
                         Resources resLocal) {
        super(context, textViewResourceId, statuses);
        this.context = context;
        this.statuses = statuses;
        this.res = resLocal;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, View convertView, ViewGroup parent) {
        View row = inflater.inflate(R.layout.item_spinner, parent, false);
        currRowVal = null;
        currRowVal = statuses.get(position);
        TextView label = (TextView) row.findViewById(R.id.spinnerItem);
        label.setText(currRowVal.getName());

        return row;
    }
}