package com.example.sony.training.adapter;

import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sony.training.OnItemClickListener;
import com.example.sony.training.R;
import com.example.sony.training.entity.UserEntity;

import java.util.List;


/**
 * Created by ThanhThang on 17/11/2017.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.RecyclerViewHolder> {
    private List<UserEntity> mUserEntity;
    private OnItemClickListener mOnItemClickListener;

    public UserAdapter(List<UserEntity> userEntities){
        mUserEntity = userEntities;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        mOnItemClickListener = onItemClickListener;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new RecyclerViewHolder(v, mOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.nameTextView.setText(mUserEntity.get(position).getUserName());
        holder.ageTextView.setText(mUserEntity.get(position).getAge()+"");
        holder.position = position;
    }

    @Override
    public int getItemCount() {
        return mUserEntity.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTextView, ageTextView;
        private int position = 0;
        private OnItemClickListener mOnItemClickListener;

        public RecyclerViewHolder(View itemView, final OnItemClickListener onItemClickListener) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.nameTextView);
            ageTextView = itemView.findViewById(R.id.ageTextView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnItemClickListener = onItemClickListener;
                    mOnItemClickListener.onItemClicked(position);
                }
            });
        }
    }
}
