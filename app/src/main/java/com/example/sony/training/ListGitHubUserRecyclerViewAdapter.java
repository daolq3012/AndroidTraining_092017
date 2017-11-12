package com.example.sony.training;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 11/08/17.
 */

public class ListGitHubUserRecyclerViewAdapter extends RecyclerView.Adapter<ListGitHubUserRecyclerViewAdapter.RecyclerViewHolder>{
    private ArrayList<Item> mList = new ArrayList<>();
    private OnRecyclerViewItemClickListener mOnRecyclerViewItemClickListener;

    public ListGitHubUserRecyclerViewAdapter(ArrayList<Item> list) {
        mList = list;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_github_layout, parent, false);
        return new RecyclerViewHolder(v, mOnRecyclerViewItemClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        if (mList.isEmpty()){
            return;
        }
        holder.mTxtID.setText(mList.get(position).getLogin());
        holder.mTxtUserName.setText(mList.get(position).getHtmlUrl());
        holder.user = mList.get(position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setOnRecyclerViewItemClickListener(OnRecyclerViewItemClickListener onRecyclerViewItemClickListener){
        mOnRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private OnRecyclerViewItemClickListener mOnRecyclerViewItemClickListener;
        private TextView mTxtID, mTxtUserName;
        private Item user ;
        public RecyclerViewHolder(final View itemView, OnRecyclerViewItemClickListener onRecyclerViewItemClickListener) {
            super(itemView);
            mOnRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
            mTxtUserName = (TextView) itemView.findViewById(R.id.userNameTextView);
            mTxtID = (TextView) itemView.findViewById(R.id.idTextView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnRecyclerViewItemClickListener.OnItemClick(user);
                }
            });
        }
    }
}
