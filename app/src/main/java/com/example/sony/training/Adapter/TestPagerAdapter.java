package com.example.sony.training.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.sony.training.ProfileFragment;
import com.example.sony.training.TimeLinesFragment;

/**
 * Created by ThanhThang on 06/11/2017.
 */

public class TestPagerAdapter extends FragmentPagerAdapter {
    public TestPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new TimeLinesFragment();
        } else if (position == 1) {
            return new ProfileFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
