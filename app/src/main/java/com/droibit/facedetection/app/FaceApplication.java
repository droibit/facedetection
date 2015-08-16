package com.droibit.facedetection.app;

import android.app.Application;

import com.google.android.gms.vision.face.FaceDetector;

/**
 * @auther kumagai
 */
public class FaceApplication extends Application {

    private FaceDetector mFaceDetector;

    /** {@inheritDoc} */
    @Override
    public void onCreate() {
        super.onCreate();

        mFaceDetector = new FaceDetector.Builder(this)
                                        .setTrackingEnabled(false)
//                                        .setMode(FaceDetector.FAST_MODE)
                                        .build();
    }

    public FaceDetector getFaceDetector() {
        return mFaceDetector;
    }
}
