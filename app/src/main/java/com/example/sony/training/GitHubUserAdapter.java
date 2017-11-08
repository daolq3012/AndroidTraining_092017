package com.example.sony.training;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ThanhThang on 08/11/2017.
 */

public class GitHubUserAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private OnRecyclerViewItemClickListener mOnRecyclerViewItemClickListener;
    private List<Item> mItem = new ArrayList<>();

    public GitHubUserAdapter(Context context) {
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.itemlayout, parent, false);
        return new ItemNewFeedViewHolder(view, mOnRecyclerViewItemClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemNewFeedViewHolder itemNewFeedViewHolder = (ItemNewFeedViewHolder) holder;
        itemNewFeedViewHolder.fillData(mItem.get(position));

    }

    @Override
    public int getItemCount() {
        return mItem.size();
    }

    public void setOnRecyclerViewItemClickListener(OnRecyclerViewItemClickListener onRecyclerViewItemClickListener){
        mOnRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
    }

    public void updateData(List<Item> items){
        if (items == null){
            return;
        }
        mItem.addAll(items);
        notifyDataSetChanged();
    }

    static class ItemNewFeedViewHolder extends RecyclerView.ViewHolder {
        private OnRecyclerViewItemClickListener mOnRecyclerViewItemClickListener;
        private Item mItem;
        private TextView userID, userName;

        public ItemNewFeedViewHolder(View itemView, OnRecyclerViewItemClickListener onRecyclerViewItemClickListener) {
            super(itemView);
            mOnRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
            userID = (TextView) itemView.findViewById(R.id.idUser);
            userName = (TextView) itemView.findViewById(R.id.userName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnRecyclerViewItemClickListener.onItemClick(mItem);
                }
            });

        }

        public void fillData(Item item){
            mItem = item;
            userID.setText(item.getId().toString());
            userName.setText(item.getLogin());
        }
    }
}
