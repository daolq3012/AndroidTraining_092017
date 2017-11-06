package com.example.sony.training;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Administrator on 11/05/17.
 */

public class TestPagerAdapter extends FragmentStatePagerAdapter {


    public TestPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 8;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new Fragmentlogin();
        } else if (position == 1) {
            return new Fragmentrigester();
        }
        return null;
    }
}
