package com.example.sony.training.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sony.training.OnRecyclerViewItemListener;
import com.example.sony.training.R;
import com.example.sony.training.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ThanhThang on 21/11/2017.
 */

public class GithubUserAdapter extends RecyclerView.Adapter<GithubUserAdapter.GithubUserHolder>{

    private List<User> listItem = new ArrayList<>();
    private OnRecyclerViewItemListener mOnRecyclerViewItemListener;


    public GithubUserAdapter(List<User> users){
        listItem = users;
    }


    public void setOnRecyclerViewItemListener(OnRecyclerViewItemListener onRecyclerViewItemListener){
        mOnRecyclerViewItemListener = onRecyclerViewItemListener;
    }


    @Override
    public GithubUserHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemuser_layout, parent, false);
        return new GithubUserHolder(itemView, mOnRecyclerViewItemListener);
    }

    @Override
    public void onBindViewHolder(GithubUserHolder holder, int position) {
        holder.nameTextView.setText(listItem.get(position).getLogin());
        holder.name = listItem.get(position).getLogin();
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public class GithubUserHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private OnRecyclerViewItemListener mOnRecyclerViewItemListener;
        private String name;

        public GithubUserHolder(View itemView, OnRecyclerViewItemListener onRecyclerViewItemListener) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            mOnRecyclerViewItemListener = onRecyclerViewItemListener;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnRecyclerViewItemListener.onItemClick(name);
                }
            });
        }

    }
}
