package com.example.sony.training.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.sony.training.OnRecyclerViewItemClickListener;
import com.example.sony.training.R;
import com.example.sony.training.model.User;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by daolq on 11/8/17.
 */

public class GitHubUserAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private OnRecyclerViewItemClickListener mOnRecyclerViewItemClickListener;
    private List<User> mUsers = new ArrayList<>();

    public GitHubUserAdapter(Context context) {
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_recycler_github_user, parent, false);
        return new ItemNewFeedViewHolder(view, mOnRecyclerViewItemClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemNewFeedViewHolder itemNewFeedViewHolder = (ItemNewFeedViewHolder) holder;
        itemNewFeedViewHolder.fillData(mUsers.get(position));
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public void setOnRecyclerViewItemClickListener(
            OnRecyclerViewItemClickListener onRecyclerViewItemClickListener) {
        mOnRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
    }

    public void updateData(List<User> users) {
        if (users == null) {
            return;
        }
        mUsers.addAll(users);
        notifyDataSetChanged();
    }

    static class ItemNewFeedViewHolder extends RecyclerView.ViewHolder {

        private OnRecyclerViewItemClickListener mOnRecyclerViewItemClickListener;
        private User mUser;
        private TextView userIdTextView, userNameTextView;

        public ItemNewFeedViewHolder(View itemView,
                OnRecyclerViewItemClickListener onRecyclerViewItemClickListener) {
            super(itemView);
            mOnRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
            userIdTextView = (TextView) itemView.findViewById(R.id.userIdTextView);
            userNameTextView = (TextView) itemView.findViewById(R.id.userNameTextView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnRecyclerViewItemClickListener.onItemClick(mUser);
                }
            });
        }

        public void fillData(User user) {
            mUser = user;
            userIdTextView.setText(user.getId().toString());
            userNameTextView.setText(user.getLogin());
        }
    }
}
