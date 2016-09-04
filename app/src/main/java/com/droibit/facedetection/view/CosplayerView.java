package com.droibit.facedetection.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.droibit.facedetection.R;
import com.droibit.facedetection.app.FaceApplication;
import com.droibit.facedetection.entity.Cosplayer;
import com.droibit.facedetection.model.FaceTrimming;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

/**
 * @author kumagai
 */
public class CosplayerView extends RelativeLayout {

    private ImageView iconView;
    private TextView titleView;
    private TextView subTitleView;

    public CosplayerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /** {@inheritDoc} */
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        iconView = ((ImageView) findViewById(R.id.icon));
        titleView = ((TextView) findViewById(android.R.id.text1));
        subTitleView = ((TextView) findViewById(android.R.id.text2));
    }

    public void bind(Cosplayer item) {
        titleView.setText(item.name);
        subTitleView.setText(item.option);

        final FaceApplication application = (FaceApplication) getContext().getApplicationContext();
        Picasso.with(getContext())
               .load(item.url)
               .transform(new FaceTrimming(application.getFaceDetector()))
               .memoryPolicy(MemoryPolicy.NO_STORE)
               .into(iconView);
    }
}
