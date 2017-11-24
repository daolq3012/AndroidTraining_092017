package com.example.sony.training.screen.listuser;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sony.training.R;
import com.example.sony.training.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ThanhThang on 23/11/2017.
 */

public class ListUserAdapter extends RecyclerView.Adapter<ListUserAdapter.GithubHolder> {

    private List<User> listItems = new ArrayList<>();
    private OnRecyclerViewItemClick mOnRecyclerViewItemClick;
    private Context mContext;

    public ListUserAdapter (Context context){
        mContext = context;
    }


    public void setOnRecyclerViewItemClick(OnRecyclerViewItemClick onRecyclerViewItemClick) {
        mOnRecyclerViewItemClick = onRecyclerViewItemClick;
    }

    @Override
    public GithubHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_user_layout, parent, false);
        return new GithubHolder(itemView, mOnRecyclerViewItemClick);
    }

    @Override
    public void onBindViewHolder(GithubHolder holder, int position) {
        holder.nameTextView.setText(listItems.get(position).getLogin());
        holder.name = listItems.get(position).getLogin();
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class GithubHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private OnRecyclerViewItemClick mOnRecyclerViewItemClick;
        private String name;

        public GithubHolder(View itemView, OnRecyclerViewItemClick onRecyclerViewItemClick) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            mOnRecyclerViewItemClick = onRecyclerViewItemClick;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnRecyclerViewItemClick.onItemClick(name);
                }
            });
        }
    }

    public void updateData(List<User> users){
        listItems = users;
    }
}
