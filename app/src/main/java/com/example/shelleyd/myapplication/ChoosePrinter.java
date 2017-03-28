package com.example.shelleyd.myapplication;

import android.content.Intent;
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

public class ChoosePrinter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_printer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Initialise buttons
        ImageButton diyButton = (ImageButton) findViewById(R.id.diyImage);
        ImageButton compactButton = (ImageButton) findViewById(R.id.compactImage);
        ImageButton twoPlusButton = (ImageButton) findViewById(R.id.twoplusImage);
        ImageButton m2020Button = (ImageButton) findViewById(R.id.m2020Image);
        ImageButton x3045Button = (ImageButton) findViewById(R.id.x3045Image);

        //Set what happens when a user presses a button
        diyButton.setOnClickListener(printerOnClick);
        compactButton.setOnClickListener(printerOnClick);
        twoPlusButton.setOnClickListener(printerOnClick);
        m2020Button.setOnClickListener(printerOnClick);
        x3045Button.setOnClickListener(printerOnClick);
    }

    View.OnClickListener printerOnClick = new View.OnClickListener() {
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
