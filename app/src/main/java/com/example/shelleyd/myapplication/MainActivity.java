package com.example.shelleyd.myapplication;

        import android.os.Bundle;
        import android.support.design.widget.FloatingActionButton;
        import android.support.design.widget.Snackbar;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.view.View;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView printerText = (TextView) findViewById(R.id.textView);

        String printerName;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                printerName = null;
            }
            else {
                printerName = extras.getString("PRINTER_NAME");
            }
        }
        else {
            printerName = (String) savedInstanceState.getSerializable("PRINTER_NAME");
        }

        printerText.setText(printerName);

    }

}
