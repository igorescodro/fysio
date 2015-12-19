package com.escodro.fysio.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.escodro.fysio.type.CalculatorTabs;

/**
 * {@link FragmentPagerAdapter} to handle the main {@link ViewPager} of the application. All the
 * {@link Fragment} with the formulas will be displayed in it.
 * <p/>
 * Created by IgorEscodro on 18/12/15.
 */
public class CalculatorPagerAdapter extends FragmentPagerAdapter {

    /**
     * Constant to represent to total number of tabs in the {@link ViewPager}.
     */
    private static final int NUMBER_OF_TABS = 2;

    /**
     * Creates a new instance of {@link CalculatorPagerAdapter}.
     *
     * @param fm {@link FragmentManager} reference
     */
    public CalculatorPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return CalculatorTabs.values()[position].getTabFragment();
    }

    @Override
    public int getCount() {
        return NUMBER_OF_TABS;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return CalculatorTabs.values()[position].getTabTitle();
    }
}
