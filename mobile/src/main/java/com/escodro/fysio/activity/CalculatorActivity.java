package com.escodro.fysio.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.escodro.fysio.R;
import com.escodro.fysio.adapter.CalculatorPagerAdapter;

/**
 * Main {@link AppCompatActivity} of the application.
 * <p/>
 * Created by IgorEscodro on 14/11/15.
 */
public class CalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        initComponents();
    }

    /**
     * Initialize all view components.
     */
    private void initComponents() {
        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.vpg_main);
        final CalculatorPagerAdapter pagerAdapter = new CalculatorPagerAdapter(
                getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
