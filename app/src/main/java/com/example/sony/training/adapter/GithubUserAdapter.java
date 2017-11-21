package com.example.sony.training.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.sony.training.OnRecyclerViewItemListener;
import com.example.sony.training.R;
import com.example.sony.training.model.User;
import java.util.List;

/**
 * Created by Admin on 11/17/17.
 */

public class GithubUserAdapter extends RecyclerView.Adapter<GithubUserAdapter.GithubUserHolder> {

    private List<User> listItems;
    private OnRecyclerViewItemListener mOnRecyclerViewItemListener;
    private Context mContext;

    public GithubUserAdapter(List<User> listItems,Context context) {
        this.listItems = listItems;
        mContext = context;
    }

    public void setOnRecyclerViewItemListener(OnRecyclerViewItemListener onRecyclerViewItemListener) {
        mOnRecyclerViewItemListener = onRecyclerViewItemListener;
    }

    @Override
    public GithubUserHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.user_item,parent,false);
        return new GithubUserHolder(itemView,mOnRecyclerViewItemListener);
    }

    @Override
    public void onBindViewHolder(GithubUserHolder holder, int position) {
        User user = listItems.get(position);
        holder.fillData(user);
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    static class GithubUserHolder extends RecyclerView.ViewHolder {

        private User mUser;
        private TextView mTxtUsername, mTxtUrl;
        private OnRecyclerViewItemListener mOnRecyclerViewItemListener;

        public GithubUserHolder(View itemView,OnRecyclerViewItemListener onRecyclerViewItemListener) {
            super(itemView);
            mTxtUsername = itemView.findViewById(R.id.txtUsername);
            mTxtUrl = itemView.findViewById(R.id.txtUrl);
            mOnRecyclerViewItemListener = onRecyclerViewItemListener;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnRecyclerViewItemListener.onItemClick(mUser);
                }
            });
        }

        public void fillData(User user) {
            mUser = user;
            mTxtUsername.setText(user.getLogin());
            mTxtUrl.setText(user.getHtmlUrl());
        }
    }
}
