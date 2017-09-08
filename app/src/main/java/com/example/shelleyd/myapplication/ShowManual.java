package com.example.shelleyd.myapplication;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ShowManual extends NavigationDrawer {

    final int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 0;
    ImageButton downloadBtn;
    ImageButton viewBtn;
    String filePath;
    String fileName;
    String MY_URL;
    String printerName;
    Integer printer;
    NotificationManager notificationManager;
    NotificationCompat.Builder builder;
    /*String[] mDrawerTitles;
    DrawerLayout mDrawerLayout;
    ListView mDrawerList;*/



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_show_manual);

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_show_manual, null, false);
        mDrawerLayout.addView(contentView, 0);

       /* mDrawerTitles = getResources().getStringArray(R.array.drawer_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, mDrawerTitles));*/

        if (savedInstanceState == null) {
            Bundle bundle = getIntent().getExtras();
            if(bundle == null) {
                printer = null;
            }
            else {
                printer = bundle.getInt("PRINTER");
            }
        }
        else {
            printer = (Integer) savedInstanceState.getSerializable("PRINTER");
        }

        getPrinter(savedInstanceState);

        Toast.makeText(getApplicationContext(), printerName, Toast.LENGTH_SHORT).show();
        //MY_URL = "https://www.colido.com/download/user_manual/CoLiDo_2.0_Plus_User_Manual_v1.2.pdf";
        //fileName = "manual.pdf";
        filePath = "/Android/data/com.example.shelleyd.myapplication/files/";
        downloadBtn = (ImageButton) findViewById(R.id.downloadBtn);
        viewBtn = (ImageButton) findViewById(R.id.viewBtn);

        //downloadBtn.setText("Download " + printerName + " Manual");
        //viewBtn.setText("View " + printerName + " Manual");

        //asks user if they wish to allow writing to external storage
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
        }

        downloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Manual Downloading", Toast.LENGTH_SHORT).show();
                notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                builder = new NotificationCompat.Builder(ShowManual.this);
                builder.setContentTitle(printerName + " User Manual")
                        .setContentText("Download in progress")
                        .setSmallIcon(R.drawable.ic_download_black);
                new AccessPDF().execute();
            }
        });

        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //File file = new File(Environment.getExternalStorageDirectory() + "/download/manual.pdf"); //file path does exist
                File file = new File(Environment.getExternalStorageDirectory() + filePath + fileName); //file path does exist
                if (file.exists()) {
                    Uri path = FileProvider.getUriForFile(ShowManual.this, ShowManual.this.getPackageName() + ".provider", file);
                    Intent intent1 = new Intent(Intent.ACTION_VIEW);
                    intent1.setType("application/pdf");
                    intent1.setDataAndType(path, "application/pdf");
                    intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent1.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(intent1);
                }
                else {
                    Toast.makeText(getApplicationContext(), "File Doesn't Exist", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void getPrinter(Bundle savedInstanceState) {

        if (savedInstanceState == null) {
            Bundle bundle = getIntent().getExtras();
            if(bundle == null) {
                printer = null;
            }
            else {
                printer = bundle.getInt("PRINTER");
            }
        }
        else {
            printer = (Integer) savedInstanceState.getSerializable("PRINTER");
        }

        switch (printer) {
            case 1:
                MY_URL = "https://www.colido.com/download/user_manual/CoLiDo_DIY_User_Manual_v1.4.pdf";
                fileName = "diy_manual.pdf";
                printerName = "DIY";
                break;
            case 2:
                MY_URL = "https://www.colido.com/download/user_manual/CoLiDo_Compact_User_Manual_v1.2.pdf";
                fileName = "compact_manual.pdf";
                printerName = "Compact";
                break;
            case 3:
                MY_URL = "http://cloud.prmhk.com:5000/fbsharing/fm9exXCI";
                fileName = "3_manual.pdf";
                printerName = "3";
                break;
            case 4:
                MY_URL = "https://www.colido.com/download/user_manual/CoLiDo_M2020_User_Manual_v1.1.pdf";
                fileName = "m2020_manual.pdf";
                printerName = "M2020";
                break;
            case 5:
                MY_URL = "https://www.colido.com/download/user_manual/CoLiDo_X3045_User_Manual_v1.5.pdf";
                fileName = "x3045_manual.pdf";
                printerName = "X3045";
                break;
            case 6:
                MY_URL = "http://cloud.prmhk.com:5000/fbsharing/d2xHPogG";
                fileName = "d1315_manual.pdf";
                printerName = "D1315";
                break;
        }
    }

    private class AccessPDF extends AsyncTask<Object, Integer, Object> {

        int id = 10;

       protected void onPreExecute() {
            super.onPreExecute();

            builder.setProgress(100, 0, true);
            notificationManager.notify(id, builder.build());
        }

        @Override
        protected void onProgressUpdate(Integer... values) {

            builder.setProgress(100, values[0], true);
            notificationManager.notify(id, builder.build());
            super.onProgressUpdate(values);
        }

        @Override
        protected Object doInBackground(Object[] objects) {

            try {
                URL url = new URL(MY_URL);
                HttpURLConnection c = (HttpURLConnection) url.openConnection();
                c.setRequestMethod("GET");
                c.connect();

                //String PATH = Environment.getExternalStorageDirectory() + "/download/";
                String PATH = Environment.getExternalStorageDirectory() + filePath;
                File file = new File(PATH);
                if (!file.exists()) {
                    file.mkdirs();
                }
                File outputFile = new File(file, fileName);
                FileOutputStream fos = new FileOutputStream(outputFile);
                InputStream is = c.getInputStream();
                byte[] buffer = new byte[1024];
                int len1 = 0;
                while ((len1 = is.read(buffer)) != -1) {
                    fos.write(buffer, 0, len1);
                }
                fos.flush();
                fos.close();
                is.close();

            } catch (IOException e) {
                Log.e("Joe", "Error: " + e);
            }

            return null;
        }



        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            Toast.makeText(getApplicationContext(), "Download Complete", Toast.LENGTH_SHORT).show();
            builder.setContentText("Download complete");
            builder.setProgress(0, 0, false);
            notificationManager.notify(id, builder.build());
        }
    }

}
