package com.example.sony.training.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 11/05/17.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mListFragments = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mListFragments.get(position);
    }

    @Override
    public int getCount() {
        return mListFragments.size();
    }

    public void addFragment(Fragment fragment) {
        mListFragments.add(fragment);
    }
}
