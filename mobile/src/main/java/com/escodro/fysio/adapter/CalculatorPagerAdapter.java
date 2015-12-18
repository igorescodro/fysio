package com.escodro.fysio.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.escodro.fysio.type.CalculatorTabs;

/**
 * Created by IgorEscodro on 18/12/15.
 */
public class CalculatorPagerAdapter extends FragmentPagerAdapter {

    private static final int NUMBER_OF_TABS = 2;

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
