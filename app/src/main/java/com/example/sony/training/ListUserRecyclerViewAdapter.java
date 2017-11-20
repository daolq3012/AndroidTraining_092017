package com.example.sony.training;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by phong on 11/18/17.
 */

public class ListUserRecyclerViewAdapter extends RecyclerView.Adapter<ListUserRecyclerViewAdapter.RecyclerViewHolder> {

    private List<User> mUsers = new ArrayList<>();
    private OnRecyclerViewItemClickListener mOnItemRecyclerViewClick;

    public ListUserRecyclerViewAdapter(List<User> users) {
        mUsers = users;
    }

    public void setOnItemRecyclerViewClick(OnRecyclerViewItemClickListener onItemRecyclerViewClick) {
        mOnItemRecyclerViewClick = onItemRecyclerViewClick;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_user, parent , false);
        return new RecyclerViewHolder(v, mOnItemRecyclerViewClick);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.mUserNameView.setText(mUsers.get(position).getLogin());
        holder.username = mUsers.get(position).getLogin();
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView mUserNameView;
        private OnRecyclerViewItemClickListener mOnItemRecyclerViewClick;
        private String username;
        public RecyclerViewHolder(View itemView, OnRecyclerViewItemClickListener onItemRecyclerViewClick) {
            super(itemView);
            mUserNameView = itemView.findViewById(R.id.userNameView);
            mOnItemRecyclerViewClick = onItemRecyclerViewClick;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemRecyclerViewClick.onUserClick(username);
                }
            });
        }
    }
}