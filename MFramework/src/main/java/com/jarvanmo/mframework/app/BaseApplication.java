package com.jarvanmo.mframework.app;

import android.app.Application;

import com.jarvanmo.mframework.util.MToast;

/**
 * base application
 */
public class BaseApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        MToast.init(this);
    }
}
