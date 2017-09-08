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

public class MaterialsFragment extends Fragment {

    public static MaterialsFragment newInstance() {
        MaterialsFragment fragment = new MaterialsFragment();
        return fragment;
    }

    public MaterialsFragment() {
    }

    ListView lv;
    String[] tipsArray = {"Different Filament Types", "Inserting Filament"};
    Integer selection = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_materials, container, false);
        lv = (ListView) rootView.findViewById(R.id.frag_materials);

        ArrayAdapter adapter = new ArrayAdapter<>(getActivity(), R.layout.tips_listview, tipsArray);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0: //different filament types
                        selection = 30;
                        break;
                    case 1: //inserting filament
                        selection = 31;
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
