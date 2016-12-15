package com.example.shelleyd.myapplication;

        import android.content.Context;
        import android.media.Image;
        import android.os.Bundle;
        import android.support.annotation.NonNull;
        import android.support.annotation.Nullable;
        import android.support.design.widget.FloatingActionButton;
        import android.support.design.widget.Snackbar;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.ImageView;
        import android.widget.ListView;
        import android.widget.ScrollView;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int[]images={R.drawable.high_res_image,/*R.drawable.compactfront,R.drawable.front2plus,R.drawable.m2020,R.drawable.x3045*/ R.drawable.high_res_image, R.drawable.high_res_image};

    ListView myListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myListView = (ListView) findViewById(R.id.myList);
        MyAdapter adapter = new MyAdapter (MainActivity.this, images);
        myListView.setAdapter(adapter);

    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        int[]images;
        int count = 0;

        public  MyAdapter(Context context, int imgs[]) {
            super(MainActivity.this, R.layout.image_list_row);
            this.context = MainActivity.this;
            this.images = imgs;
        }

        @Override
        public int getCount() {
            return images.length;
        }

        class ViewHolder {

            private ImageView myImage;
        }
        @Override
        @NonNull
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder myViewHolder;

            if (convertView == null) {

                myViewHolder = new ViewHolder();

                LayoutInflater myInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = myInflater.inflate(R.layout.image_list_row, parent, false);
                myViewHolder.myImage = (ImageView) convertView.findViewById(R.id.listImage);
                convertView.setTag(myViewHolder);
            }
            else {
                myViewHolder = (ViewHolder) convertView.getTag();
            }
            Log.d("Plates", "Count: " + count++);

            myViewHolder.myImage.setImageResource(images[position]);

            return convertView;
        }
    }

}
