package com.example.android.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by MohamedFadel on 1/24/2018.
 */

public class FragmentMonuments extends Fragment {

    ArrayList<Attraction> arrayList;
    ListView listView;
    CustomAdapter customAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_monuments_layout, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        arrayList = fillAttractionArrayList();
        customAdapter = new CustomAdapter(getContext(), arrayList);
        listView = view.findViewById(R.id.monument_list);
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
     * fills array list of all monuments attractions
     * @return attractions arraylist
     */
    private ArrayList<Attraction> fillAttractionArrayList(){
        ArrayList<Attraction> arrayList = new ArrayList<>();

        arrayList.add(new Attraction(getResources().getString(R.string.citadel_of_qaitbay),
                getResources().getString(R.string.citadel_of_qaitbay_description),
                R.drawable.citadel_of_qaitbay,
                new Location(getResources().getString(R.string.citadel_of_qaitbay_latitude),
                getResources().getString(R.string.citadel_of_qaitbay_Longitude))));


        arrayList.add(new Attraction(getResources().getString(R.string.tutankhamun),
                getResources().getString(R.string.tut_description),
                R.drawable.tutankhamun_,
                new Location(getResources().getString(R.string.tut_latitude),
                getResources().getString(R.string.tut_Longitude))));
        arrayList.add(new Attraction(getResources().getString(R.string.karnak),
                getResources().getString(R.string.karnak_description),
                R.drawable.karnak,
                new Location(getResources().getString(R.string.karnak_latitude),
                getResources().getString(R.string.karnak_Longitude))));
        arrayList.add(new Attraction(getResources().getString(R.string.abu_smbel),
                getResources().getString(R.string.abu_smbel_description),
                R.drawable.abu_smbel,
                new Location(getResources().getString(R.string.abu_smbel_latitude),
                getResources().getString(R.string.abu_smbel_Longitude))));

        return arrayList;
    }

}
