package com.example.shelleyd.myapplication;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;


final class MyGridAdapter extends BaseAdapter{

    private final List<Item> mItems = new ArrayList<>();
    private final LayoutInflater mInflater;

    @TargetApi(16)
    public MyGridAdapter(Context context) {
        mInflater = LayoutInflater.from(context);

        mItems.add(new Item(R.drawable.diy_logo));
        mItems.add(new Item(R.drawable.compact));
        mItems.add(new Item(R.drawable.three));
        mItems.add(new Item(R.drawable.m2020_logo));
        mItems.add(new Item(R.drawable.x3045_logo));
        mItems.add(new Item(R.drawable.d1315));

    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Item getItem(int i) {
        return mItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mItems.get(i).drawableId;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View v = view;
        ImageView picture;

        if (v == null) {
            v = mInflater.inflate(R.layout.grid_item, viewGroup, false);
            v.setTag(R.id.picture, v.findViewById(R.id.picture));
        }

        picture = (ImageView) v.getTag(R.id.picture);

        Item item = getItem(i);

        picture.setImageResource(item.drawableId);

        return v;
    }

    private static class Item {
        public final int drawableId;

        Item(int drawableId) {
            this.drawableId = drawableId;
        }
    }
}
