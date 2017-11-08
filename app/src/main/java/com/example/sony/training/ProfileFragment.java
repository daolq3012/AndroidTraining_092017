package com.example.sony.training;


import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sony.training.adapter.ProfileAdapter;
import com.example.sony.training.adapter.TimelinesAdapter;
import com.example.sony.training.model.Data;


public class ProfileFragment extends Fragment {
    private RecyclerView mRecyclerViewProfile;
    private ProfileAdapter profileAdapter;
    private View view;

    public ProfileFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_profile, container, false);

        initViews();
        mRecyclerViewProfile.setHasFixedSize(true);
        mRecyclerViewProfile.setNestedScrollingEnabled(false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerViewProfile.setLayoutManager(layoutManager);
        profileAdapter = new ProfileAdapter(Data.getListItem(),getContext());
        mRecyclerViewProfile.setAdapter(profileAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerViewProfile.getContext(),
                DividerItemDecoration.VERTICAL);
        mRecyclerViewProfile.addItemDecoration(dividerItemDecoration);

        return view;
    }

    private void initViews() {
        mRecyclerViewProfile = (RecyclerView) view.findViewById(R.id.recyclerViewProfile);
    }

}
