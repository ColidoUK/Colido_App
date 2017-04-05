package com.example.shelleyd.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Joeb on 05/04/2017.
 */

public class PrintingFragment extends Fragment {

    public static PrintingFragment newInstance() {
        PrintingFragment fragment = new PrintingFragment();
        return fragment;
    }

    public PrintingFragment() {
    }

    ListView lv;
    String[] tipsArray = {"Recommended Temperatures"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_printing, container, false);
        lv = (ListView) rootView.findViewById(R.id.frag_printing);

        ArrayAdapter adapter = new ArrayAdapter<String>(getActivity(), R.layout.tips_listview, tipsArray);
        lv.setAdapter(adapter);

        return rootView;
    }
}