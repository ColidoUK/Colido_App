package com.example.shelleyd.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Troubleshooting extends NavigationDrawer {

    int[]images={0/*R.drawable.overheating,R.drawable.not_sticking, R.drawable.stringing, R.drawable.under_extrusion, R.drawable.warping*/};
    String[]text={"Overheating", "Prints Not Sticking", "Stringing", "Under Extrusion", "Warping"};
    ListView myListView;
    Integer image = null;
    Integer description = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_troubleshooting);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_troubleshooting, null, false);
        mDrawerLayout.addView(contentView, 0);

        myListView = (ListView) findViewById(R.id.myComboList);
        //myListView.setAdapter(new ArrayAdapter<String>(this, R.layout.combo_list, R.id.comboTextView, text));
        MyAdapter adapter = new MyAdapter (Troubleshooting.this, images, text);
        myListView.setAdapter(adapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        image = R.drawable.overheating;
                        description = R.string.overheating;
                        break;
                    case 1:
                        image = R.drawable.not_sticking;
                        description = R.string.bed_adhesion;
                        break;
                    case 2:
                        image = R.drawable.stringing;
                        description = R.string.stringing;
                        break;
                    case 3:
                        image = R.drawable.under_extrusion;
                        description = R.string.u_extrusion;
                        break;
                    case 4:
                        image = R.drawable.warping;
                        description = R.string.warping;
                        break;
                }

                Intent intent = new Intent(Troubleshooting.this, ShowTroubleshooting.class);
                intent.putExtra("IMAGEFILE", image);
                intent.putExtra("DESCRIPTION", description);
                startActivity(intent);
            }
        });
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        int[]images;
        String[]text;
        int count = 0;

        public  MyAdapter(Context context, int imgs[], String txt[]) {
            super(Troubleshooting.this, R.layout.combo_list);
            this.context = Troubleshooting.this;
            this.images = imgs;
            this.text = txt;
        }

        @Override
        public int getCount() {
            return text.length;
        }

        class ViewHolder {

            private ImageView myImage;
            private TextView myText;
        }
        @Override
        @NonNull
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder myViewHolder;

            if (convertView == null) {

                myViewHolder = new ViewHolder();

                LayoutInflater myInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = myInflater.inflate(R.layout.combo_list, parent, false);
                myViewHolder.myImage = (ImageView) convertView.findViewById(R.id.comboImageView);
                myViewHolder.myText = (TextView) convertView.findViewById(R.id.comboTextView);
                convertView.setTag(myViewHolder);
            }
            else {
                myViewHolder = (ViewHolder) convertView.getTag();
            }
            Log.d("Plates", "Count: " + count++);

            myViewHolder.myImage.setImageResource(images[/*position*/0]);
            myViewHolder.myText.setText(text[position]);

            return convertView;
        }

    }
}
