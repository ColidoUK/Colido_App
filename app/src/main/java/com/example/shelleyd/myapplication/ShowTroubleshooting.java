package com.example.shelleyd.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowTroubleshooting extends NavigationDrawer {

    Integer imageFile;
    Integer description;
    ImageView myImage;
    TextView myText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_show_troubleshooting, null, false);
        mDrawerLayout.addView(contentView, 0);

        myImage = (ImageView) findViewById(R.id.troubleshootingImage);
        myText = (TextView) findViewById(R.id.troubleshootingText);

        if (savedInstanceState == null) {
            Bundle bundle = getIntent().getExtras();
            if(bundle == null) {
                imageFile = null;
                description = null;
            }
            else {
                imageFile = bundle.getInt("IMAGEFILE");
                description = bundle.getInt("DESCRIPTION");
            }
        }
        else {
            imageFile = (Integer) savedInstanceState.getSerializable("IMAGEFILE");
            description = (Integer) savedInstanceState.getSerializable("DESCRIPTION");
        }

        myImage.setImageResource(imageFile);
        myText.setText(description);
    }

}
