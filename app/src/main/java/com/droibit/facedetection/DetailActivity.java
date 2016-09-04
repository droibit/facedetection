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
}
