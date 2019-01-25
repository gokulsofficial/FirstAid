package com.example.firstaid;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Tab1 extends Fragment {

    String items[] = new String[]{"Cut and wounds", "Heart Attack", "poisoning", "Heart Stroke", "Nose Bleed", "Sprain", "Shock", "Un-Consious", "Sun Burn"};

    ArrayAdapter<String> mArrayAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_tab1, container, false);
        //Button heatattack = (Button) rootView.findViewById(R.id.heartattack);

//        heatattack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent ha = new Intent(getActivity().getApplication(), HeartAttack.class);
//                startActivity(ha);
//            }
//        });

        final ListView listView = (ListView) rootView.findViewById(R.id.listView);
        mArrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items);
        listView.setAdapter(mArrayAdapter);
        //listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()    {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (position == 0) {
                    Intent myIntent = new Intent(view.getContext(), MapsActivity.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 1) {
                    Intent myIntent = new Intent(view.getContext(), Attack.class);
                    startActivityForResult(myIntent, 0);
                }
//
//                if (position == 2) {
//                    Intent myIntent = new Intent(view.getContext(), ListItemActivity1.class);
//                    startActivityForResult(myIntent, 0);
//                }
//
//                if (position == 3) {
//                    Intent myIntent = new Intent(view.getContext(), ListItemActivity2.class);
//                    startActivityForResult(myIntent, 0);
//                }
//
//                if (position == 4) {
//                    Intent myIntent = new Intent(view.getContext(), ListItemActivity1.class);
//                    startActivityForResult(myIntent, 0);
//                }
//
//                if (position == 5) {
//                    Intent myIntent = new Intent(view.getContext(), ListItemActivity2.class);
//                    startActivityForResult(myIntent, 0);
//                }
//
//                if (position == 6) {
//                    Intent myIntent = new Intent(view.getContext(), ListItemActivity1.class);
//                    startActivityForResult(myIntent, 0);
//                }
//
//                if (position == 7) {
//                    Intent myIntent = new Intent(view.getContext(), ListItemActivity2.class);
//                    startActivityForResult(myIntent, 0);
//                }


                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value
                String itemValue = (String) listView.getItemAtPosition(position);

                // Show Alert

                Toast.makeText(getContext().getApplicationContext(),  itemValue, Toast.LENGTH_LONG).show();

            }

        });

        return rootView;
    }
}
