package com.droibit.facedetection;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;

import com.droibit.facedetection.app.FaceApplication;
import com.droibit.facedetection.entity.Cosplayer;
import com.droibit.facedetection.view.CosplayerAdapter;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends ListFragment {

    private CosplayerAdapter mAdapter;

    public MainFragment() {
    }

    /** {@inheritDoc} */
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAdapter = new CosplayerAdapter(getActivity());
        setListAdapter(mAdapter);
        setListShown(true);
    }

    /** {@inheritDoc} */
    @Override
    public void onDestroy() {
        super.onDestroy();

        ((FaceApplication) getActivity().getApplication())
                .getFaceDetector().release();
    }

    /** {@inheritDoc} */
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        final Cosplayer item = mAdapter.getItem(position);
        final Intent intent = new Intent(getActivity(), DetailActivity.class)
                                    .putExtra(DetailActivity.ARG_ITEM, item);
        getActivity().startActivity(intent);
    }
}
