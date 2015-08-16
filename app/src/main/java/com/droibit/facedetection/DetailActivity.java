package com.droibit.facedetection;

import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.droibit.facedetection.entity.Cosplayer;
import com.droibit.facedetection.model.FaceTrimming;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    public static final String ARG_ITEM = "item";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        final Cosplayer cosplayer = (Cosplayer) getIntent().getSerializableExtra(ARG_ITEM);
        ((TextView) findViewById(android.R.id.text1))
                .setText(cosplayer.name);
        ((TextView) findViewById(android.R.id.text2))
                .setText(cosplayer.option);
        ((TextView) findViewById(R.id.license))
                .setText(cosplayer.license.url);

        final ImageView imageView = ((ImageView) findViewById(R.id.image));
        Picasso.with(this).invalidate(cosplayer.url);
        Picasso.with(this)
                .load(cosplayer.url)
                .memoryPolicy(MemoryPolicy.NO_STORE)
                .into(imageView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
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
