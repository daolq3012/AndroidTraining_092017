package com.example.sony.training;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 11/05/17.
 */

public class ProfileRecyclerViewAdapter extends RecyclerView.Adapter<ProfileRecyclerViewAdapter.RecyclerViewHolder> {
    private List<User> users =  new ArrayList<>();

    public ProfileRecyclerViewAdapter(List<User> users) {
        this.users = users;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_layout,parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.mTxtName.setText(users.get(position).getName());
        holder.mTxtHello.setText(users.get(position).getHello());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private TextView mTxtName, mTxtHello;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            mTxtName = (TextView) itemView.findViewById(R.id.nameTextView);
            mTxtHello = (TextView) itemView.findViewById(R.id.helloTextView);
        }
    }

}
