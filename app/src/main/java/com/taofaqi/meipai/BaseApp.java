package com.taofaqi.meipai;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by CrazyForUu on 2016/3/12.
 */
public class BaseApp extends Application {
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        Fresco.initialize(context);
    }

    public static Context getContext() {
        return context;
    }
}
