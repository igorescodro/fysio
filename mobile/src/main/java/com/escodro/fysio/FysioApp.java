package com.escodro.fysio;

import android.app.Application;
import android.content.Context;

/**
 * Created by IgorEscodro on 18/12/15.
 */
public class FysioApp extends Application {

    private static Context mContext;

    public static Context getContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this.getApplicationContext();
    }
}
