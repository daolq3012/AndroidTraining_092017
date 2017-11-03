package com.example.sony.training.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Administrator on 11/03/17.
 */

public class UnSwipeViewPager extends ViewPager {
    public UnSwipeViewPager(Context context) {
        super(context);
    }

    public UnSwipeViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    // 3 ham duoi la de khong cho swipe viewpager
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean canScrollHorizontally(int direction) {
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }

    // khong co hieu ung khi chuyen tab
    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item, false);
    }
}
