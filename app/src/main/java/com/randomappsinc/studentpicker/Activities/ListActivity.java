package com.randomappsinc.studentpicker.Activities;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.randomappsinc.studentpicker.Adapters.ListTabsAdapter;
import com.randomappsinc.studentpicker.R;
import com.randomappsinc.studentpicker.Views.SlidingTabLayout;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by alexanderchiou on 10/18/15.
 */
public class ListActivity extends StandardActivity {
    @Bind(R.id.viewpager) ViewPager mViewPager;
    @Bind(R.id.sliding_tabs) SlidingTabLayout mSlidingTabLayout;

    private ListTabsAdapter listTabsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ButterKnife.bind(this);
        String listName = getIntent().getStringExtra(MainActivity.LIST_NAME_KEY);
        setTitle(listName);

        listTabsAdapter = new ListTabsAdapter(getSupportFragmentManager(), this, listName);
        mViewPager.setAdapter(listTabsAdapter);
        mSlidingTabLayout.setCustomTabView(R.layout.custom_tab, R.id.tab_name);
        mSlidingTabLayout.setViewPager(mViewPager);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mSlidingTabLayout.setViewPager(mViewPager);
    }

    public ListTabsAdapter getListTabsAdapter() {
        return listTabsAdapter;
    }
}
