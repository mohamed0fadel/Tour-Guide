package com.example.android.tourguide;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by MohamedFadel on 1/25/2018.
 */

public class FragmentHome extends Fragment {

    Location location;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home_layout, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        location = new Location(getResources().getString(R.string.egypt_latitude),
                getResources().getString(R.string.egypt_Longitude));

        view.findViewById(R.id.home_btn_location).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMap(location.getUri());
            }
        });

        view.findViewById(R.id.home_btn_read_more).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWebPage(getResources().getString(R.string.egypt_site));
            }
        });
    }

    /**
     * opens the location in maps
     * @param geoLocation location Uri
     */
    private void showMap(Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * opens a web site to show more details
     * @param url the details site
     */
    private void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
