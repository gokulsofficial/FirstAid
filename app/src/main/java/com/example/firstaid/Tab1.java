package com.example.firstaid;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Tab1 extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_tab1, container, false);
        Button heatattack = (Button) rootView.findViewById(R.id.heartattack);

        heatattack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ha = new Intent(getActivity().getApplication(), HeartAttack.class);
                startActivity(ha);
            }
        });

        return rootView;
    }
}
