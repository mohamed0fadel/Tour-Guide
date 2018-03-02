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
 * Created by MohamedFadel on 1/24/2018.
 */

public class FragmentMosque extends Fragment {

    ArrayList<Attraction> arrayList;
    ListView listView;
    CustomAdapter customAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mosque_lyout, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        arrayList = fillAttractionArrayList();
        customAdapter = new CustomAdapter(getContext(), arrayList);
        listView = view.findViewById(R.id.mosque_list);
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
     * fills array list of all mosques attractions
     * @return attractions arraylist
     */
    private ArrayList<Attraction> fillAttractionArrayList() {
        ArrayList<Attraction> arrayList = new ArrayList<>();

        arrayList.add(new Attraction(getResources().getString(R.string.al_rifai_mosque),
                getResources().getString(R.string.al_rifai_mosque_description),
                R.drawable.al_rifai__mosque,
                new Location(getResources().getString(R.string.al_rifai_mosque_latitude),
                getResources().getString(R.string.al_rifai_mosque_Longitude))));
        arrayList.add(new Attraction(getResources().getString(R.string.al_hussein_mosque),
                getResources().getString(R.string.al_hussein_mosque_description),
                R.drawable.al_hussein_mosque,
                new Location(getResources().getString(R.string.al_hussein_mosque_latitude),
                getResources().getString(R.string.al_hussein_mosque_Longitude))));
        arrayList.add(new Attraction(getResources().getString(R.string.mosque_of_al_hakim),
                getResources().getString(R.string.mosque_of_al_hakim_description),
                R.drawable.mosque_of_al_hakim,
                new Location(getResources().getString(R.string.al_hussein_mosque_latitude),
                getResources().getString(R.string.mosque_of_al_hakim_Longitude))));

        return arrayList;
    }
}
