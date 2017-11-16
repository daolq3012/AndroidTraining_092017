package com.example.sony.training.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.sony.training.OnRecyclerViewItemClickListener;
import com.example.sony.training.R;
import com.example.sony.training.database.entity.UserEntity;
import java.util.List;

/**
 * Created by Admin on 11/17/17.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {

    List<UserEntity> listItems;
    private OnRecyclerViewItemClickListener mOnRecyclerViewItemClickListener;

    public UserAdapter(List<UserEntity> listItems) {
        this.listItems = listItems;
    }

    @Override
    public UserHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.user_item, parent, false);

        return new UserHolder(view,mOnRecyclerViewItemClickListener);
    }

    @Override
    public void onBindViewHolder(UserHolder holder, int position) {
        holder.fillData(listItems.get(position));
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public void setOnRecyclerViewItemClickListener(OnRecyclerViewItemClickListener onRecyclerViewItemClickListener) {
        mOnRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
    }

    class UserHolder extends RecyclerView.ViewHolder {
        private OnRecyclerViewItemClickListener mOnRecyclerViewItemClickListener;
        private UserEntity mUser;
        private TextView mTxtUsername;
        private TextView mTxtAge;

        public UserHolder(View itemView,OnRecyclerViewItemClickListener onRecyclerViewItemClickListener) {
            super(itemView);
            mOnRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
            mTxtUsername = (TextView) itemView.findViewById(R.id.txtUsernameItem);
            mTxtAge = (TextView) itemView.findViewById(R.id.txtAgeItem);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnRecyclerViewItemClickListener.onItemClick(mUser);
                }
            });
        }

        public void fillData(UserEntity user) {
            mUser = user;
            mTxtUsername.setText(user.getUserName());
            mTxtAge.setText("Age: "+String.valueOf(user.getAge()));
        }
    }
}
