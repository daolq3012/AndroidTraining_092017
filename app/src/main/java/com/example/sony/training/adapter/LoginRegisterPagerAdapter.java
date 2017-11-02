package com.example.sony.training.adapter;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.widget.Toast;

import com.example.sony.training.FirstFragment;
import com.example.sony.training.FirstFragmentEventListener;
import com.example.sony.training.LoginSuccessFragment;
import com.example.sony.training.MainActivity;
import com.example.sony.training.SecondFragment;

/**
 * Created by Administrator on 11/01/17.
 */

public class LoginRegisterPagerAdapter extends FragmentPagerAdapter  {

    public LoginRegisterPagerAdapter(FragmentManager fm) {
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
