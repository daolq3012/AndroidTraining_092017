package com.example.sony.training.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.sony.training.Item;
import com.example.sony.training.OnRecyclerViewItemClickListener;
import com.example.sony.training.R;
import java.util.List;

/**
 * Created by Admin on 11/08/17.
 */

public class GithubUserAdapter extends RecyclerView.Adapter {

    private List<Item> listItems;
    private OnRecyclerViewItemClickListener mOnRecyclerViewItemClickListener;

    public GithubUserAdapter(List<Item> listItems) {
        this.listItems = listItems;
    }

    @Override
    public GithubUserHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.github_user_item, parent, false);

        return new GithubUserHolder(view,mOnRecyclerViewItemClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        GithubUserHolder githubUserHolder = (GithubUserHolder) holder;
        githubUserHolder.fillData(listItems.get(position));
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public void setOnRecyclerViewItemClickListener(
            OnRecyclerViewItemClickListener onRecyclerViewItemClickListener) {
        mOnRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
    }

    static class GithubUserHolder extends RecyclerView.ViewHolder {
        private OnRecyclerViewItemClickListener mOnRecyclerViewItemClickListener;
        private Item mItem;
        private TextView mTxtId;
        private TextView mTxtUsername;

        public GithubUserHolder(final View itemView,OnRecyclerViewItemClickListener onRecyclerViewItemClickListener) {
            super(itemView);
            mOnRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
            mTxtId = (TextView) itemView.findViewById(R.id.txtId);
            mTxtUsername = (TextView) itemView.findViewById(R.id.txtUsername);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnRecyclerViewItemClickListener.OnItemClick(mItem);
                }
            });
        }

        public void fillData(Item item) {
            mItem = item;
            mTxtId.setText(item.getLogin());
            mTxtUsername.setText(item.getHtmlUrl());
        }
    }
}
