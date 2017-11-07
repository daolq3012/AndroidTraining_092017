package com.example.sony.training.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sony.training.adapter.ProfileRecyclerViewAdapter;
import com.example.sony.training.R;
import com.example.sony.training.User;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {

    private RecyclerView mRvProfile;
    private ProfileRecyclerViewAdapter profileRecyclerViewAdapter;
    private List<User> users;

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_second, container, false);

        mRvProfile = (RecyclerView) v.findViewById(R.id.profileRecyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        profileRecyclerViewAdapter = new ProfileRecyclerViewAdapter(createData());

        mRvProfile.setLayoutManager(manager);
        mRvProfile.setAdapter(profileRecyclerViewAdapter);

        return v;
    }

    private List<User> createData(){
        users = new ArrayList<>();
        users.add(new User("ITEM_TYPE_HEADER",""));
        users.add(new User("Chuong","Hello"));
        users.add(new User("Truyen","Hello"));
        users.add(new User("Nguyen","Hi"));
        users.add(new User("Trung","Bonsour"));
        users.add(new User("Nhac","Xin chao"));
        users.add(new User("Phuc","Hello"));
        return users;
    }

}
