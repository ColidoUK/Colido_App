package com.example.shelleyd.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

public class ChoosePrinter extends NavigationDrawer {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_choose_printer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_choose_printer, null, false);
        mDrawerLayout.addView(contentView, 0);

        GridView gridView = (GridView)findViewById(R.id.gridview);
        gridView.setAdapter(new MyGridAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Integer printer = null;

                switch (i) {
                    case 0:
                        printer = 1;
                        break;
                    case 1:
                        printer = 2;
                        break;
                    case 2:
                        printer = 3;
                        break;
                    case 3:
                        printer = 4;
                        break;
                    case 4:
                        printer = 5;
                        break;
                    case 5:
                        printer = 6;
                        break;
                }
                Intent intent = new Intent(getApplicationContext(), ShowManual.class);
                intent.putExtra("PRINTER", printer);
                startActivity(intent);
            }
        });
        //Initialise buttons
        /*ImageButton diyButton = (ImageButton) findViewById(R.id.diyImage);
        ImageButton compactButton = (ImageButton) findViewById(R.id.compactImage);
        ImageButton twoPlusButton = (ImageButton) findViewById(R.id.twoplusImage);
        ImageButton m2020Button = (ImageButton) findViewById(R.id.m2020Image);
        ImageButton x3045Button = (ImageButton) findViewById(R.id.x3045Image);

        //Set what happens when a user presses a button
        diyButton.setOnClickListener(printerOnClick);
        compactButton.setOnClickListener(printerOnClick);
        twoPlusButton.setOnClickListener(printerOnClick);
        m2020Button.setOnClickListener(printerOnClick);
        x3045Button.setOnClickListener(printerOnClick);*/

    }

    /*View.OnClickListener printerOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Integer printer = null;

            switch (view.getId()) {
                case R.id.diyImage:
                    printer = 1;
                    break;
                case R.id.compactImage:
                    printer = 2;
                    break;
                case R.id.twoplusImage:
                    printer = 3;
                    break;
                case R.id.m2020Image:
                    printer = 4;
                    break;
                case R.id.x3045Image:
                    printer = 5;
                    break;
            }
            Intent intent = new Intent(getApplicationContext(), ShowManual.class);
            intent.putExtra("PRINTER", printer);
            startActivity(intent);
        }
    };*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
