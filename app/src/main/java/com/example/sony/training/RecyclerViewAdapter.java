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
 * Created by daolq on 11/6/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter {

    private Context mContext;

    private List<User> mUsers = new ArrayList<>();

    public RecyclerViewAdapter(Context context) {
        mContext = context;
    }

    public void updateData(List<User> users) {
        mUsers = users;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.layout_item_recyclerview, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        User user = mUsers.get(position);
        String text = user.getName() + " Tuoi: " + user.getAge();
        itemViewHolder.setDataIntoTextView(text);
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.textviewName);
        }

        public void setDataIntoTextView(String text) {
            mTextView.setText(text);
        }
    }
}
