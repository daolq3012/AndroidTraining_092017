package com.example.sony.training.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.example.sony.training.OnItemRecyclerViewClick;
import com.example.sony.training.R;
import com.example.sony.training.roomdb.entity.User;
import java.util.List;

/**
 * Created by Administrator on 11/16/17.
 */

public class ListUserRecyclerViewAdapter
        extends RecyclerView.Adapter<ListUserRecyclerViewAdapter.RecyclerViewHolder> {
    private List<User> mUsers;
    private OnItemRecyclerViewClick mOnItemRecyclerViewClick;

    public ListUserRecyclerViewAdapter(List<User> users) {
        mUsers = users;
    }

    public void setOnItemRecyclerViewClick(OnItemRecyclerViewClick onItemRecyclerViewClick) {
        mOnItemRecyclerViewClick = onItemRecyclerViewClick;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_line_layout, parent, false);
        return new RecyclerViewHolder(v, mOnItemRecyclerViewClick);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.mTxtID.setText(mUsers.get(position).getId() + "");
        holder.mTxtName.setText(mUsers.get(position).getUserName());
        holder.mTxtAge.setText(mUsers.get(position).getAge() + "");
        holder.position = position;
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView mTxtID, mTxtName, mTxtAge;
        private OnItemRecyclerViewClick mOnItemRecyclerViewClick;
        private int position = 0;

        public RecyclerViewHolder(View itemView, final OnItemRecyclerViewClick onItemRecyclerViewClick) {
            super(itemView);
            mTxtID = itemView.findViewById(R.id.idTextView);
            mTxtName = itemView.findViewById(R.id.nameTextView);
            mTxtAge = itemView.findViewById(R.id.ageTextView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemRecyclerViewClick = onItemRecyclerViewClick;
                    mOnItemRecyclerViewClick.OnItemClick(position);
                }
            });
        }
    }
}
