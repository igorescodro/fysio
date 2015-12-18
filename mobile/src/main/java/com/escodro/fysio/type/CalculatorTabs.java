package com.escodro.fysio.type;

import android.support.v4.app.Fragment;

import com.escodro.fysio.FysioApp;
import com.escodro.fysio.R;
import com.escodro.fysio.fragment.UltrasoundFragment;

/**
 * Created by IgorEscodro on 18/12/15.
 */
public enum CalculatorTabs {

    ULTRASOUND(R.string.calculator_tab_ultrasound, UltrasoundFragment.newInstance()),

    FORMULA2(R.string.calculator_tab_formula2, UltrasoundFragment.newInstance());

    private int mTitleId;

    private Fragment mFragment;

    CalculatorTabs(int titleId, Fragment fragment) {
        mTitleId = titleId;
        mFragment = fragment;
    }

    public String getTabTitle() {
        return FysioApp.getContext().getString(mTitleId);
    }

    public Fragment getTabFragment() {
        return mFragment;
    }
}
