package com.example.shelleyd.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_maintenance, container, false);
        lv = (ListView) rootView.findViewById(R.id.frag_maintenance);

        ArrayAdapter adapter = new ArrayAdapter<String>(getActivity(), R.layout.tips_listview, tipsArray);
        lv.setAdapter(adapter);

        return rootView;
    }
}
