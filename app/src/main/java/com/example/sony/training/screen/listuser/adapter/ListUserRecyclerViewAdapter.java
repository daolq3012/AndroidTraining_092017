package com.example.sony.training.screen.listuser.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.sony.training.screen.listuser.OnItemRecyclerViewClick;
import com.example.sony.training.R;
import com.example.sony.training.model.User;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 11/17/17.
 */

public class ListUserRecyclerViewAdapter
        extends RecyclerView.Adapter<ListUserRecyclerViewAdapter.RecyclerViewHolder> {

    private List<User> mUsers = new ArrayList<>();
    private OnItemRecyclerViewClick mOnItemRecyclerViewClick;
    private Context mContext;

    public ListUserRecyclerViewAdapter(Context context) {
        mContext = context;
    }

    public void updateData(List<User> users) {
        mUsers = users;
        notifyDataSetChanged();
    }

    public void setOnItemRecyclerViewClick(OnItemRecyclerViewClick onItemRecyclerViewClick) {
        mOnItemRecyclerViewClick = onItemRecyclerViewClick;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.line_user_layout, parent, false);
        return new RecyclerViewHolder(v, mOnItemRecyclerViewClick);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.mTxtUserName.setText(mUsers.get(position).getLogin());
        holder.username = mUsers.get(position).getLogin();
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView mTxtUserName;
        private OnItemRecyclerViewClick mOnItemRecyclerViewClick;
        private String username;

        public RecyclerViewHolder(View itemView, OnItemRecyclerViewClick onItemRecyclerViewClick) {
            super(itemView);
            mTxtUserName = itemView.findViewById(R.id.userNameTextView);
            mOnItemRecyclerViewClick = onItemRecyclerViewClick;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemRecyclerViewClick.OnItemClick(username);
                }
            });
        }
    }
}
