package com.example.shelleyd.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Joeb on 31/03/2017.
 */

public class MaterialsFragment extends Fragment {

    public static MaterialsFragment newInstance() {
        MaterialsFragment fragment = new MaterialsFragment();
        return fragment;
    }

    public MaterialsFragment() {
    }

    ListView lv;
    String[] tipsArray = {"Different Filament Types", "Inserting Filament"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_materials, container, false);
        lv = (ListView) rootView.findViewById(R.id.frag_materials);

        ArrayAdapter adapter = new ArrayAdapter<String>(getActivity(), R.layout.tips_listview, tipsArray);
        lv.setAdapter(adapter);

        return rootView;
    }
}
