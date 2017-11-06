package com.example.sony.training;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sony.training.adapter.TimelinesAdapter;
import com.example.sony.training.model.Data;
import com.example.sony.training.model.Timeline;


public class TimelinesFragment extends Fragment {

    private RecyclerView mRecyclerViewTimelines;
    private TimelinesAdapter timelinesAdapter;
    private View view;

    public TimelinesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_timelines, container, false);

        initViews();

        mRecyclerViewTimelines.setHasFixedSize(true);
        mRecyclerViewTimelines.setNestedScrollingEnabled(false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerViewTimelines.setLayoutManager(layoutManager);
        timelinesAdapter = new TimelinesAdapter(Data.getListTimeline(),getContext());
        mRecyclerViewTimelines.setAdapter(timelinesAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerViewTimelines.getContext(),
                DividerItemDecoration.VERTICAL);
        mRecyclerViewTimelines.addItemDecoration(dividerItemDecoration);
        return view;
    }

    private void initViews() {
        mRecyclerViewTimelines = (RecyclerView) view.findViewById(R.id.recyclerViewTimelines);
    }

}
