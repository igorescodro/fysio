package com.escodro.fysio.type;

import android.support.v4.app.Fragment;

import com.escodro.fysio.FysioApp;
import com.escodro.fysio.R;
import com.escodro.fysio.fragment.UltrasoundFragment;

/**
 * Enum to store the respective {@link Fragment} with its name.
 * <p/>
 * Created by IgorEscodro on 18/12/15.
 */
public enum CalculatorTabs {

    /**
     * Representation of {@link UltrasoundFragment}.
     */
    ULTRASOUND(R.string.calculator_tab_ultrasound, UltrasoundFragment.newInstance()),

    /**
     * Representation of {@link UltrasoundFragment}.
     */
    FORMULA2(R.string.calculator_tab_formula2, UltrasoundFragment.newInstance());

    /**
     * {@link Fragment} title reference.
     */
    private int mTitleId;

    /**
     * {@link Fragment} reference.
     */
    private Fragment mFragment;

    /**
     * Default constructor.
     *
     * @param titleId  {@link Fragment} resource id title
     * @param fragment {@link Fragment} reference
     */
    CalculatorTabs(int titleId, Fragment fragment) {
        mTitleId = titleId;
        mFragment = fragment;
    }

    /**
     * Gets the {@link Fragment} title.
     *
     * @return respective {@link Fragment} title
     */
    public String getTabTitle() {
        return FysioApp.getContext().getString(mTitleId);
    }

    /**
     * Gets the {@link Fragment}.
     *
     * @return respective {@link Fragment}
     */
    public Fragment getTabFragment() {
        return mFragment;
    }
}
