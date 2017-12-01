package com.smile.mohamed.mvpexample.app;

import android.app.Application;

/**
 * Created by COMPUMAGIC on 04/11/2017.
 */

public class App extends Application {

    private static App instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
    }

    public static App getInstance() {

        return instance;
    }
}
