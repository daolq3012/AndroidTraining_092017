package com.example.sony.training;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;


public class TimeLinesFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerViewAdapterTimeLines recyclerViewAdapterTimeLines;
    private List<TimeLines> string;

    public TimeLinesFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_time_lines, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.timelinesRecyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerViewAdapterTimeLines = new RecyclerViewAdapterTimeLines(createTimeLines());

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(recyclerViewAdapterTimeLines);

        return view;

    }

    private List<TimeLines> createTimeLines() {
        string = new ArrayList<>();

        string.add(new TimeLines("R.drawable.hokage_1","Hokage I"));
        string.add(new TimeLines("R.drawable.hokage_2","Hokage II"));
        string.add(new TimeLines("R.drawable.hokage_3","Hokage III"));
        string.add(new TimeLines("R.drawable.hokage_4","Hokage VI"));
        string.add(new TimeLines("R.drawable.hokage_5","Hokage V"));
        string.add(new TimeLines("R.drawable.hokage_6","Hokage VI"));
        string.add(new TimeLines("R.drawable.hokage_7","Hokage VII"));

        return string;
    }
}
