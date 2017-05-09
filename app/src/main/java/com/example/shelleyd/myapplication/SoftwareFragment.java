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

/**
 * Created by Joeb on 31/03/2017.
 */

public class SoftwareFragment extends Fragment {

    public static SoftwareFragment newInstance() {
        SoftwareFragment fragment = new SoftwareFragment();
        return fragment;
    }

    public SoftwareFragment() {
    }

    ListView lv;
    String[] tipsArray = {"Loading a File", "Slicing a File", "Using Object Placement Controls"};
    Integer selection = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_software, container, false);
        lv = (ListView) rootView.findViewById(R.id.frag_software);

        ArrayAdapter adapter = new ArrayAdapter<String>(getActivity(), R.layout.tips_listview, tipsArray);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0: //loading a file
                        selection = 20;
                        break;
                    case 1: //slicing a file
                        selection = 21;
                        break;
                    case 2: //using object placement controls
                        selection = 22;
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
