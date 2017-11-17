package com.example.sony.training.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.sony.training.fragment.FirstFragment;
import com.example.sony.training.fragment.SecondFragment;

/**
 * Created by Administrator on 11/04/17.
 */

public class ViewPagerAdaper extends FragmentPagerAdapter{
    public ViewPagerAdaper(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return new FirstFragment();
        } else if (position == 1){
            return new SecondFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
