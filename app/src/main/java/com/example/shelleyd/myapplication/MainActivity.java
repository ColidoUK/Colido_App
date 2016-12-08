package com.example.shelleyd.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Initialise buttons
        ImageButton diyButton = (ImageButton) findViewById(R.id.diyImage);
        ImageButton compactButton = (ImageButton) findViewById(R.id.compactImage);
        ImageButton twoPlusButton = (ImageButton) findViewById(R.id.twoplusImage);
        ImageButton m2020Button = (ImageButton) findViewById(R.id.m2020Image);
        ImageButton x3045Button = (ImageButton) findViewById(R.id.x3045Image);

        //Set what happens when a user presses a button
        diyButton.setOnClickListener(diyOnClick);
        compactButton.setOnClickListener(compactOnClick);
        twoPlusButton.setOnClickListener(twoPlusOnClick);
        m2020Button.setOnClickListener(m2020OnClick);
        x3045Button.setOnClickListener(x3045OnClick);
    }

    View.OnClickListener diyOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(getApplicationContext(), "DIY Button Pressed", Toast.LENGTH_SHORT).show();
        }
    };

    View.OnClickListener compactOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(getApplicationContext(), "Compact Button Pressed", Toast.LENGTH_SHORT).show();
        }
    };

    View.OnClickListener twoPlusOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(getApplicationContext(), "2+ Button Pressed", Toast.LENGTH_SHORT).show();
        }
    };

    View.OnClickListener m2020OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(getApplicationContext(), "M2020 Button Pressed", Toast.LENGTH_SHORT).show();
        }
    };

    View.OnClickListener x3045OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(getApplicationContext(), "X3045 Button Pressed", Toast.LENGTH_SHORT).show();
        }
    };

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

        return super.onOptionsItemSelected(item);
    }
}
