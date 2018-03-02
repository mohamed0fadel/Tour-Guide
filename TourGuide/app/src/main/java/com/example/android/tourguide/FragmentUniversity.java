package com.example.android.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by MohamedFadel on 1/25/2018.
 */

public class FragmentUniversity extends Fragment {

    ArrayList<Attraction> arrayList;
    ListView listView;
    CustomAdapter customAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_university_layout, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        arrayList = fillAttractionArrayList();
        customAdapter = new CustomAdapter(getContext(), arrayList);
        listView = view.findViewById(R.id.university_list);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), ActivityDetails.class);
                intent.putExtra("atrraction", arrayList.get(i));
                startActivity(intent);
            }
        });

    }

    /**
     * fills array list of all university attractions
     * @return attractions arraylist
     */
    private ArrayList<Attraction> fillAttractionArrayList(){
        ArrayList<Attraction> arrayList = new ArrayList<>();

        arrayList.add(new Attraction(getResources().getString(R.string.cairo),
                getResources().getString(R.string.cairo_description),
                R.drawable.cairo,
                new Location(getResources().getString(R.string.cairo_latitude),
                getResources().getString(R.string.cairo_Longitude))));
        arrayList.add(new Attraction(getResources().getString(R.string.benha),
                getResources().getString(R.string.benha_description),
                R.drawable.benha,
                new Location(getResources().getString(R.string.benha_latitude),
                getResources().getString(R.string.benha_Longitude))));
        arrayList.add(new Attraction(getResources().getString(R.string.ain_shams),
                getResources().getString(R.string.ain_shams_description),
                R.drawable.ain_shams_university,
                new Location(getResources().getString(R.string.ain_shams_latitude),
                getResources().getString(R.string.ain_shams_Longitude))));

        return arrayList;
    }
}
