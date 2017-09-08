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

public class MainActivity extends NavigationDrawer {

    int[]images={R.drawable.user_manual,R.drawable.tips_tricks, R.drawable.troubleshooting};
    ListView myListView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_main, null, false);
        mDrawerLayout.addView(contentView, 0);

        myListView = (ListView) findViewById(R.id.myList);
        MyAdapter adapter = new MyAdapter (MainActivity.this, images);
        myListView.setAdapter(adapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch (position) {
                    case 0:
                        intent = new Intent(getApplicationContext(), ChoosePrinter.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(getApplicationContext(), TipsTricks.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(getApplicationContext(), Troubleshooting.class);
                        startActivity(intent);
                        break;
                }
            }
        });
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
