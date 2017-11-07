package com.example.sony.training.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sony.training.R;
import com.example.sony.training.User;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 11/05/17.
 */

public class ProfileRecyclerViewAdapter extends RecyclerView.Adapter<ProfileRecyclerViewAdapter.RecyclerViewHolder> {
    private List<User> users =  new ArrayList<>();
    public static final int ITEM_TYPE_NORMAL = 0;
    public static final int ITEM_TYPE_HEADER = 1;
    public ProfileRecyclerViewAdapter(List<User> users) {
        this.users = users;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE_NORMAL) {
            View normalView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
            return new RecyclerViewHolder(normalView); // view holder for normal items
        } else if (viewType == ITEM_TYPE_HEADER) {
            View headerRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_layout, parent, false);
            return new RecyclerViewHolder(headerRow); // view holder for header items
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        final int itemType = getItemViewType(position);

        if (itemType == ITEM_TYPE_NORMAL) {
            holder.mTxtName.setText(users.get(position).getName());
            holder.mTxtHello.setText(users.get(position).getHello());
        }

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (users.get(position).getName().equals("ITEM_TYPE_HEADER")) {
            return ITEM_TYPE_HEADER;
        } else {
            return ITEM_TYPE_NORMAL;
        }
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
