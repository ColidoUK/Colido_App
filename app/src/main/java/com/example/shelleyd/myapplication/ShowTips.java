package com.example.shelleyd.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class ShowTips extends NavigationDrawer {

    Integer selection;
    TextView tipText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_show_tips);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_show_tips, null, false);
        mDrawerLayout.addView(contentView, 0);

        TextView tipText = (TextView) findViewById(R.id.compactCalibration);

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
                tipText.setText(R.string.bed_calibration);
                break;
            case 11: //clogged nozzle
                tipText.setText(R.string.clogged_nozzle);
                break;
            case 12: //print head removal
                tipText.setText(R.string.print_head_removal);
                break;
            case 20:
                tipText.setText(R.string.load_file);
                break;
            case 21:
                tipText.setText(R.string.slice_file);
                break;
            case 22:
                tipText.setText(R.string.object_controls);
                break;
            case 30:
                tipText.setText("Different Filament Types");
                break;
            case 31:
                tipText.setText(R.string.inserting_filament);
                break;
            case 40:
                tipText.setText(R.string.recommended_temps);
                break;
            case 41:
                tipText.setText(R.string.sd_print);
                break;
        }

        //selectTip();
    }

    void selectTip ()
    {
        switch (selection) {
            case 0: //bed calibration
                tipText.setText(R.string.bed_calibration);
                break;
            case 1: //clogged nozzle
                tipText.setText(R.string.clogged_nozzle);
                break;
            case 2: //print head removal
                tipText.setText(R.string.print_head_removal);
                break;
        }
    }

}
