package com.example.android.tourguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by MohamedFadel on 1/25/2018.
 */

public class CustomAdapter extends ArrayAdapter<Attraction>{
    public CustomAdapter(Context context, ArrayList<Attraction> attractions) {
        super(context, 0, attractions);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Attraction currentAttraction = getItem(position);

        ImageView imageView = listItemView.findViewById(R.id.list_image);
        imageView.setImageResource(currentAttraction.getImage());

        TextView miwokTextView = listItemView.findViewById(R.id.list_text);
        miwokTextView.setText(currentAttraction.getName());

        return listItemView;
    }

}
