package com.example.shelleyd.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class ShowTips extends NavigationDrawer {

    Integer selection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_show_tips, null, false);
        mDrawerLayout.addView(contentView, 0);

        TextView tipText = (TextView) findViewById(R.id.compactCalibration);
        TextView tipTitle = (TextView) findViewById(R.id.compactTitle);

        if (savedInstanceState == null) {
            Bundle bundle = getIntent().getExtras();
            if(bundle == null) {
                selection = null;
            }
            else {
                selection = bundle.getInt("SELECTION");
            }
        }
        else {
            selection = (Integer) savedInstanceState.getSerializable("SELECTION");
        }

        switch (selection) {
            case 10: //bed calibration
                tipTitle.setText(R.string.bed_calibration_title);
                tipText.setText(R.string.bed_calibration);
                break;
            case 11: //clogged nozzle
                tipTitle.setText(R.string.clogged_nozzle_title);
                tipText.setText(R.string.clogged_nozzle);
                break;
            case 12: //print head removal
                tipTitle.setText(R.string.print_head_removal_title);
                tipText.setText(R.string.print_head_removal);
                break;
            case 20:
                tipTitle.setText(R.string.load_file_title);
                tipText.setText(R.string.load_file);
                break;
            case 21:
                tipTitle.setText(R.string.slice_file_title);
                tipText.setText(R.string.slice_file);
                break;
            case 22:
                tipTitle.setText(R.string.object_controls_title);
                tipText.setText(R.string.object_controls);
                break;
            case 30:
                tipTitle.setText(R.string.filament_types_title);
                tipText.setText(R.string.different_filament);
                break;
            case 31:
                tipTitle.setText(R.string.instering_filament_title);
                tipText.setText(R.string.inserting_filament);
                break;
            case 40:
                tipTitle.setText(R.string.recommended_temps_title);
                tipText.setText(R.string.recommended_temps);
                break;
            case 41:
                tipTitle.setText(R.string.sd_print_title);
                tipText.setText(R.string.sd_print);
                break;
        }
    }
}
