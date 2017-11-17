package com.example.sony.training.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sony.training.ItemTimeLine;
import com.example.sony.training.R;
import com.example.sony.training.adapter.TimelineRecyclerViewAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    private TimelineRecyclerViewAdapter mTimelineRecyclerViewAdapter;
    private RecyclerView mRvTimeline;
    private List<ItemTimeLine> mList;

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_first, container, false);
        mRvTimeline = (RecyclerView) v.findViewById(R.id.timelineRecyclerView);

        mTimelineRecyclerViewAdapter = new TimelineRecyclerViewAdapter(createTimelineData());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRvTimeline.setLayoutManager(layoutManager);
        mRvTimeline.setAdapter(mTimelineRecyclerViewAdapter);
        return v;
    }

    private List<ItemTimeLine> createTimelineData() {
        mList = new ArrayList<>();
        mList.add(new ItemTimeLine(R.drawable.splash_icon,"Chuong"));
        mList.add(new ItemTimeLine(R.drawable.splash_icon,"Truyen"));
        mList.add(new ItemTimeLine(R.drawable.splash_icon,"Nguyen"));
        mList.add(new ItemTimeLine(R.drawable.splash_icon,"Trung"));
        mList.add(new ItemTimeLine(R.drawable.splash_icon,"Phuc"));
        mList.add(new ItemTimeLine(R.drawable.splash_icon,"Son"));
        mList.add(new ItemTimeLine(R.drawable.splash_icon,"Du"));
        mList.add(new ItemTimeLine(R.drawable.splash_icon,"Huy"));
        return mList;
    }
}
