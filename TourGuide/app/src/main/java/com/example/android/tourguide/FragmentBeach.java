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

public class FragmentBeach extends Fragment {

    ArrayList<Attraction> arrayList;
    ListView listView;
    CustomAdapter customAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_beach_layout, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        arrayList = fillAttractionArrayList();
        customAdapter = new CustomAdapter(getContext(), arrayList);
        listView = view.findViewById(R.id.beach_list);
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
     * makes array list of all the beach attractions
     * @return atrractions arraylist
     */
    private ArrayList<Attraction> fillAttractionArrayList(){
        ArrayList<Attraction> arrayList = new ArrayList<>();

        arrayList.add(new Attraction(getResources().getString(R.string.alex),
                getResources().getString(R.string.alex_description),
                R.drawable.alex,
                new Location(getResources().getString(R.string.alex_latitude),
                getResources().getString(R.string.alex_Longitude))));
        arrayList.add(new Attraction(getResources().getString(R.string.sharm_el_sheikh),
                getResources().getString(R.string.sharm_el_sheikh_description),
                R.drawable.sharm_el_sheikh,
                new Location(getResources().getString(R.string.sharm_el_sheikh_latitude),
                getResources().getString(R.string.sharm_el_sheikh_Longitude))));
        arrayList.add(new Attraction(getResources().getString(R.string.red_sea),
                getResources().getString(R.string.red_sea_description),
                R.drawable.red_sea,
                new Location(getResources().getString(R.string.red_sea_latitude),
                getResources().getString(R.string.red_sea_Longitude))));

        return arrayList;
    }
}
