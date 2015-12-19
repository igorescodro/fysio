package com.escodro.fysio;

import android.app.Application;
import android.content.Context;

/**
 * {@link Application} class with app Singletons.
 * <p/>
 * Created by IgorEscodro on 18/12/15.
 */
public class FysioApp extends Application {

    /**
     * {@link Context} reference.
     */
    private static Context mContext;

    /**
     * Gets {@link FysioApp} context.
     *
     * @return {@link FysioApp} context
     */
    public static Context getContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this.getApplicationContext();
    }
}
