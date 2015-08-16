package com.droibit.facedetection.model;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.Log;
import android.util.SparseArray;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;
import com.squareup.picasso.Transformation;

/**
 * @auther kumagai
 */
public class FaceTrimming implements Transformation {

    private static final String KEY = "face";
    private static final int MAX_SIDE = 256;

    private final FaceDetector mFaceDetector;

    public FaceTrimming(FaceDetector faceDetector) {
        mFaceDetector = faceDetector;
    }

    /** {@inheritDoc} */
    @Override
    public Bitmap transform(Bitmap source) {
        final Frame frame = new Frame.Builder()
                                     .setBitmap(source)
                                     .build();
        final SparseArray<Face> faces = mFaceDetector.detect(frame);
//        if (!mFaceDetector.isOperational()) {
//            return source;
//        }
        if (faces.size() == 0) {
            return source;
        }
        Log.d("FACE", String.format("detected faces: %d", faces.size()));

        RectF sourceRect = null;
        for (int i = 0, size = faces.size(); i < size; i++) {
            final Face face = faces.get(i);
            final PointF position = face.getPosition();
            final RectF faceRect = new RectF(position.x,
                                             position.y,
                                             position.x + face.getWidth(),
                                             position.y + face.getHeight());

            if (sourceRect == null) {
                sourceRect = faceRect;
            } else {
                sourceRect.union(faceRect);
            }
        }

        final float sourceMaxSide = Math.max(sourceRect.height(), sourceRect.width());
        final float destMaxSide = Math.max(sourceMaxSide, MAX_SIDE);
        final PointF point;
        if (sourceRect.height() >= sourceRect.width()) {
            final float offset = (destMaxSide - sourceRect.width()) * .5f;
            point = new PointF(sourceRect.left - offset, sourceRect.top);
        } else {
            final float offset = (destMaxSide - sourceRect.height()) * .5f;
            point = new PointF(sourceRect.left, sourceRect.top - offset);
        }
        Log.d("FACE", String.format("%f, %f, %f, %f", point.x, point.y, destMaxSide, destMaxSide));

        point.x = Math.max(point.x, 0);
        point.y = Math.max(point.y, 0);

        final Bitmap dest = Bitmap.createBitmap(source,
                                                (int) point.x,
                                                (int) point.y,
                                                (int) destMaxSide,
                                                (int) destMaxSide);
        source.recycle();
        return dest;
    }

    /** {@inheritDoc} */
    @Override
    public String key() {
        return KEY;
    }
}
