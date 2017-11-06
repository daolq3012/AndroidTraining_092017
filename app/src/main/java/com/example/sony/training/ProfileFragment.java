package com.example.sony.training;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class ProfileFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private List<Infor> infor;

    public ProfileFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        mRecyclerView = (RecyclerView) v.findViewById(R.id.profileRecyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerViewAdapter = new RecyclerViewAdapter(createInfor());

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(recyclerViewAdapter);

        return v;
    }

    private List<Infor> createInfor(){
        infor = new ArrayList<>();
        infor.add(new Infor("Hinata Hyuga","Phu nhân Hokage VII"));
        infor.add(new Infor("Sasuke Uchiha","Gennin"));
        infor.add(new Infor("Sakura Haruno","Chunnin"));
        infor.add(new Infor("Neji Hyuga","Jonin"));
        infor.add(new Infor("Rock Lee","Chunnin"));
        infor.add(new Infor("Jiraiya","Sannin"));
        infor.add(new Infor("Minato Namikaze","Hokage IV"));
        infor.add(new Infor("Kakashi Hatake","Hokage VI"));
        infor.add(new Infor("Itachi Uchiha","Jonin"));
        infor.add(new Infor("Shisui Uchiha","Jonin"));

        return infor;
    }


}
