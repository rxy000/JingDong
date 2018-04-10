package com.bw.com.utils;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by ruixuyao on 2018/04/09.
 */

public class MyApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
