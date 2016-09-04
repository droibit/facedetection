package com.droibit.facedetection.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.droibit.facedetection.R;
import com.droibit.facedetection.entity.Contents;
import com.droibit.facedetection.entity.Cosplayer;

/**
 * @author kumagai
 */
public class CosplayerAdapter extends ArrayAdapter<Cosplayer> {


    public CosplayerAdapter(Context context) {
        super(context, R.layout.item_cosplayer, Contents.ITEMS);
    }

    /** {@inheritDoc} */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final CosplayerView view;
        if (convertView == null) {
            view = (CosplayerView) LayoutInflater.from(getContext()).inflate(R.layout.item_cosplayer, parent, false);
        } else {
            view = (CosplayerView) convertView;
        }

        final Cosplayer item = getItem(position);
        view.bind(item);

        return view;
    }
}
