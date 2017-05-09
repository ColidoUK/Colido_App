package com.example.shelleyd.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;

/**
 * Created by Joeb on 31/03/2017.
 */

public class MaintenanceFragment extends Fragment{

    public static MaintenanceFragment newInstance() {
        MaintenanceFragment fragment = new MaintenanceFragment();
        return fragment;
    }

    public MaintenanceFragment() {
    }

    ListView lv;
    String[] tipsArray = {"Bed Calibration", "Fixing a clogged nozzle", "Taking apart the print head" };
    Integer selection = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_maintenance, container, false);
        lv = (ListView) rootView.findViewById(R.id.frag_maintenance);

        ArrayAdapter adapter = new ArrayAdapter<String>(getActivity(), R.layout.tips_listview, tipsArray);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0: //bed calibration
                        selection = 10;
                        break;
                    case 1: //clogged nozzle
                        selection = 11;
                        break;
                    case 2: //print head removal
                        selection = 12;
                        break;
                }
                Intent intent = new Intent (getContext(), ShowTips.class);
                intent.putExtra("SELECTION", selection);
                startActivity(intent);
            }
        });

        return rootView;
    }
}
