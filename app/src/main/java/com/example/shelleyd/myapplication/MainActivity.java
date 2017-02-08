package com.example.shelleyd.myapplication;

        import android.content.Context;
        import android.content.Intent;
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
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.ImageButton;
        import android.widget.ImageView;
        import android.widget.ListView;
        import android.widget.ScrollView;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int[]images={R.drawable.user_manual,R.drawable.tips_tricks, R.drawable.troubleshooting};
    Integer printer;
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

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), ShowManual.class);
                startActivity(intent);
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
