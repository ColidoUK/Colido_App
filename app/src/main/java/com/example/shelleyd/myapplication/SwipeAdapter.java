package com.example.shelleyd.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


public class SwipeAdapter extends FragmentStatePagerAdapter {

    static final int NUM_ITEMS = 10;

    public SwipeAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = new PageFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("count", position + 1);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }
}
